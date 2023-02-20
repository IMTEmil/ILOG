package fr.imtld.ilog;

import java.util.concurrent.Executor;

public class CurrentThreadExecutor implements Executor {
	public void execute(Runnable command) {
		command.run();
	}
}