package fr.imtld.ilog;

public class Counter {
	int value;

	public void up() {
		value++;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}

	public static void main(String[] args) throws Exception {
		Counter cnt = new Counter();
		System.out.println(cnt);
		cnt.up();
		System.out.println(cnt);
	}
}