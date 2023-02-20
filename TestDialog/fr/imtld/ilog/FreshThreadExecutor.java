package fr.imtld.ilog;

import java.util.concurrent.Executor;

public class FreshThreadExecutor implements Executor {
	public void execute(Runnable command) {
		Thread thrNew = new Thread(command);
		thrNew.start();
	}
}