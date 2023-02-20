package fr.imtld.ilog;

import java.io.IOException;

public class TestFifo {
	public static void main(String[] args) {
		Fifo fifo = new Fifo();

		Consumer c = new Consumer(fifo);
		Thread thrC = new Thread(c);
		thrC.start();

		Producer p = new Producer(fifo);
		Thread thrP = new Thread(p);
		thrP.start();
		
		try {
			System.in.read();
		} catch (IOException e) {
		}
		System.out.println("primary thread ended");
	}
}