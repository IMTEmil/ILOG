package fr.imtld.ilog;

import java.io.IOException;

public class TestDialog {
	public static void main(String[] args) {
		Thread thrCur = Thread.currentThread();
		String name = thrCur.getName();
		System.out.printf("%s entering TestDialog#main\n", name);
		Dialog dlg = new Dialog();
		dlg.start();		try {
			System.in.read();
			dlg.stop(); // stop requested (but not immediately effective)
			while (! dlg.start()) // start success one stop effective
				;
			System.in.read();
			dlg.stop();
		} catch (IOException e) {
		}
		System.out.printf("%s leaving TestDialog#main\n", name);
	}
}