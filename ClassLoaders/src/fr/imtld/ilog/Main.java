package fr.imtld.ilog;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {
	public static void displayClassLoader(Class<?> cls) {
		ClassLoader cl = cls.getClassLoader();
		String str = cl==null ? "bootstrap class loader" : cl.getClass().getCanonicalName();
		System.out.println(str);
	}
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

	public void exec(String[] args) throws Exception {
	Class<?> cls = Class.forName(args[0]);
	Constructor<?> ct = cls.getDeclaredConstructor();
	Object o = ct.newInstance();
	call(o, args[1]);
	call(o, args[2]);
}
	

	public static void main(String[] args) throws Exception {
		new Main().exec(args);
	}
}