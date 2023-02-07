package fr.imtld.ilog;

public class Main {
	public static void displayClassLoader(Class<?> cls) {
		ClassLoader cl = cls.getClassLoader();
		String str = cl==null ? "bootstrap class loader" : cl.getClass().getCanonicalName();
		System.out.println(str);
	}

	public void exec(String[] args) throws Exception {
		displayClassLoader(String.class);
	}

	public static void main(String[] args) throws Exception {
		new Main().exec(args);
	}
}