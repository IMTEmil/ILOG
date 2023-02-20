package fr.imtld.ilog;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket sockServer;
	Thread thread;
	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			Thread thrCur = Thread.currentThread();
			String name = thrCur.getName();
			System.out.printf("%s entering Server#run\n", name);
			try {
				sockServer = new ServerSocket(2013);
				while (true) { // not that infinite ! (because of surrounding try / catch)
					Socket sock = sockServer.accept(); // exit to IOException if sockServer closed
					Dialog dlg = new Dialog(sock);
					dlg.start();
				}
			} catch (IOException e) {
				System.out.printf("server stopped\n");
			}
			System.out.printf("%s leaving Server#run\n", name);
			thread = null;
		}
	};

	public boolean start() {
		if (thread == null) {
			thread = new Thread(runnable);
			thread.start();
			return true;
		}
		return false;
	}

	public void stop() {
		if (thread != null) {
			try {
				sockServer.close(); // supersedes thread.interrupt()
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}