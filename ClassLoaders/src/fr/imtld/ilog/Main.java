package fr.imtld.ilog;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class Main {
	protected URLClassLoader cl;

	public void call(Object o, String namMeth) throws Exception {
		Class<?> cls = o.getClass();
		String namClass = cls.getCanonicalName();
		Method m = cls.getMethod(namMeth);
		System.out.printf("%s#%s()", namClass, namMeth);
		Object res = m.invoke(o);
		if (m.getReturnType() != void.class)
			System.out.printf(" -> %s", res);
		System.out.println();
	}

	public void initClassLoader(String namDir) throws Exception {
		MyClassLoader cl = new MyClassLoader(null);
		
		File f = new File(namDir);
		
		File[] fs = f.listFiles();
		ArrayList<File> filtered_f = new ArrayList<File>();
		
		for (File file : fs) {
			if (!file.toString().endsWith(".jar"))
			{
				filtered_f.add(file);
			}
		}
		
	}

	public void exec(String[] args) throws Exception {
		initClassLoader("lib");
		Class<?> cls = cl.loadClass(args[0]);
		Constructor<?> ct = cls.getDeclaredConstructor();
		Object o = ct.newInstance();
		call(o, args[1]);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().exec(args);
	}
}