package fr.imtld.ilog;

import static java.nio.file.StandardWatchEventKinds.*;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Monitor {
	public static void main(String[] args) throws Exception {
		FileSystem fs = FileSystems.getDefault();
		WatchService watcher = fs.newWatchService();
		Path dir = Paths.get("");
		dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
		while (true) {
			WatchKey key = watcher.take();
			for (WatchEvent<?> e : key.pollEvents()) {
				Kind<?> kind = e.kind();
				if (kind == OVERFLOW) {
					System.err.println("event(s) lost");
					continue;
				}
				System.out.printf("%s : %s\n", kind, e.context());
			}
			if (! key.reset()) {
				System.err.println(" folder no longer watched");
				return;
			}
		}
	}
}