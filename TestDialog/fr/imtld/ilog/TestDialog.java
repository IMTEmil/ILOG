package fr.imtld.ilog;

public class TestDialog {
	public static void main(String[] args) {
		Thread thrCur = Thread.currentThread();
		String name = thrCur.getName();
		System.out.printf("%s entering TestDialog#main\n", name);
		Dialog dlg = new Dialog();
		dlg.run();
		while (true) {
			System.out.printf("%s looping in TestDialog#main\n", name);
		}
//		System.out.printf("%s leaving TestDialog#main\n", name);
	}
}