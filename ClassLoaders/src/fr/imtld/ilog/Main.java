package fr.imtld.ilog;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
	public Method getMain(Class<?> cls) throws Exception {
		
		int mod = cls.getModifiers();
		
		Method m = cls.getDeclaredMethod("main", String[].class);
		
		if (cls.equals(Main.class) 
				&& Modifier.isPublic(mod) && Modifier.isStatic(mod)
				&& m.getReturnType().equals(Void.TYPE))
		{
			return m;
		}
		
		return null;
	}

	public void exec(String[] args) throws Exception {
		Class<?> cls = Class.forName(args[0]);
		Method meth = getMain(cls);
		if (meth != null)
			meth.invoke(null, (Object) null); // no command line arguments
	}
	
	public static void main(String[] args) throws Exception {
		new Main().exec(args);
	}
}