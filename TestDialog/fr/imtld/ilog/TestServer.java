package fr.imtld.ilog;

import java.io.IOException;

public class TestServer {
	public static void main(String[] args) {
		Thread thrCur = Thread.currentThread();
		String name = thrCur.getName();
		System.out.printf("%s entering TestServer#main\n", name);
		Server srv = new Server();
		srv.start();
		try {
			System.in.read();
			srv.stop();		} catch (IOException e) {
		}
		System.out.printf("%s leaving TestServer#main\n", name);
	}
}