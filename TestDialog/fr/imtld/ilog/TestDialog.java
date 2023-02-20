package fr.imtld.ilog;

import java.io.IOException;

public class TestDialog {
	public static void main(String[] args) {
		Thread thrCur = Thread.currentThread();
		String name = thrCur.getName();
		System.out.printf("%s entering TestDialog#main\n", name);
		Dialog dlg = new Dialog();
		Thread thrDlg = new Thread(dlg);
		thrDlg.start();
		try {
			System.in.read(); // blocks waiting for "Enter" key
			thrDlg.interrupt();
		} catch (IOException e) {
		}
		System.out.printf("%s leaving TestDialog#main\n", name);
	}
}