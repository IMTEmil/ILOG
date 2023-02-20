package fr.imtld.ilog;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Executor;

public class Dialog {
	Executor executor;
	Runnable runnable;
	Socket sock;
	public Dialog(Socket sock, Executor executor) {
		this.sock = sock;
		this.executor = executor;
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
				}
				System.out.printf("%s leaving Dialog#run", name);
			}
		};
	}

	public void start() {
		executor.execute(runnable);
	}
}