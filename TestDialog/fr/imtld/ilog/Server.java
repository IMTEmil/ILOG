package fr.imtld.ilog;

public class Server { // no longer a Runnable
	Thread thread;
	Runnable runnable = new Runnable() { 
		@Override
		public void run() {
			Thread thrCur = Thread.currentThread();
			String name = thrCur.getName();
			System.out.printf("%s entering Server#run\n", name);
			while (!Thread.interrupted()) {
				System.out.printf("%s looping in Server#run\n", name);
			}
			System.out.printf("%s leaving Server#run", name);
			thread = null;
		}
	};

	public boolean start() {
		if (thread == null) {
			thread = new Thread(runnable);
			thread.start();
			return true;
		}
		return false;
	}

	public void stop() {
		if (thread != null)
			thread.interrupt();
	}
}