package me.nilme.exercise.java.proxy;


public class MyClassLoader extends ClassLoader {

	public Class<?> defineMyClass( byte[] b, int off, int len)
	{
		return super.defineClass(b, off, len);
	}

}