package fr.imtld.ilog;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
	public static void displayClassLoader(Class<?> cls) {
		ClassLoader cl = cls.getClassLoader();
		String str = cl==null ? "bootstrap class loader" : cl.getClass().getCanonicalName();
		System.out.println(str);
	}

	public void exec(String[] args) throws Exception {
		File filFolder = new File("../Counter/bin");
		URL urlFolder = filFolder.toURI().toURL();
		URL[] urls = new URL [] { urlFolder };
		URLClassLoader cl = new URLClassLoader(urls);
		Class<?> cls = cl.loadClass(args[0]);
		displayClassLoader(cls);
//		Class<?> cls = Class.forName(args[0]);
	}

	public static void main(String[] args) throws Exception {
		new Main().exec(args);
	}
}