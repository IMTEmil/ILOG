package fr.imtld.ilog;

import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader extends URLClassLoader {
	public MyClassLoader(URL[] urls) {
		super(urls);
	}

	@Override
	protected Class<?> findClass(String namClass) throws ClassNotFoundException {
		System.out.printf("loading %s\n", namClass);
		return super.findClass(namClass);
	}
}