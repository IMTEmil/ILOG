package fr.imtld.ilog;

public class Consumer implements Runnable {
	protected Fifo fifo;
	public Consumer(Fifo fifo) {
		this.fifo = fifo;
	}
	public void run() {
		synchronized(this)
		{
		int count=0;
		try {
			while (fifo.size == 0) wait();
		} catch (InterruptedException e) {
			
		}
		while (count < 100) {
			Object o = fifo.get();
			if (o != null) {
				if ((int)o != count)
					System.err.println(o + " while expecting "+count);
				count++;
			}
		}
		System.out.println("consumer ended");
	}
	}
}