package fr.imtld.ilog;

public class Producer implements Runnable {
	Fifo fifo;

	public Producer(Fifo fifo) {
		this.fifo = fifo;
	}

	public void run() {
		synchronized(this){
			try {
				while (fifo.size == 100) wait();	
			} catch (InterruptedException e) {
			}
		for (int i = 0; i < 100; i++) {
			fifo.append(i);
		}
		System.err.println("producer ended");
	}
}
}