package fr.imtld.ilog;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class Dialog {
	Thread thread;
	Runnable runnable;
	Socket sock;
	public Dialog(Socket sock) {
		this.sock = sock;
		runnable = new Runnable() {
			@Override
			public void run() {
				Thread thrCur = Thread.currentThread();
				String name = thrCur.getName();
				System.out.printf("%s entering Dialog#run\n", name);
				try {
					OutputStream os = sock.getOutputStream();
					PrintWriter pw = new PrintWriter(os, true);
					pw.println(new Date());
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}				System.out.printf("%s leaving Dialog#run", name);
				thread = null;
			}
		};
	}
	public boolean start() {
		if (thread == null) {
			thread = new Thread(runnable);
			thread.start();
			return true;
		}
		return false;
	}

	public void stop() {
		if (thread != null)
			thread.interrupt();
	}
}