package fr.imtld.ilog;

public class Fifo {
	protected Object[] v;
	protected int size;

	public Fifo() {
		v = new Object[100];
		size = 0;
	}

	public void append(Object o) {
		v[size] = o;
		size++;
	}

	public Object get() {
		if (size == 0)
			return null;
		Object o = v[0];
		size--;
		for (int i = 0; i < size; i++)
			v[i] = v[i + 1];
		v[size] = null;
		return o;
	}
}
