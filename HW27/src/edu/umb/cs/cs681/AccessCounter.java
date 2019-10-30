package edu.umb.cs.cs681;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AccessCounter {

	private ConcurrentHashMap<Path, AtomicInteger> concurrentHashMap;
	private ArrayList<Path> acmapfiles;
	private Random randomGenerator;
	private AtomicInteger fileCount;

	public AccessCounter() {

		concurrentHashMap = new ConcurrentHashMap<>();
		acmapfiles = new ArrayList<Path>();
		randomGenerator = new Random();

		acmapfiles.add(Paths.get("file_root", "a.html"));
		acmapfiles.add(Paths.get("file_root", "b.html"));
		acmapfiles.add(Paths.get("file_root", "c.html"));
		acmapfiles.add(Paths.get("file_root", "d.html"));
		acmapfiles.add(Paths.get("file_root", "e.html"));
	}

	public Path getRamdomPath() {
		int index = randomGenerator.nextInt(acmapfiles.size());
		Path randomFile = acmapfiles.get(index);
		return randomFile;
	}

	public void increment(Path randomFile) {

		if (concurrentHashMap.keySet().contains(randomFile)) {
			fileCount = concurrentHashMap.get(randomFile);
			fileCount.incrementAndGet();
			concurrentHashMap.put(Paths.get(randomFile.toString()), fileCount);
		} else {
			concurrentHashMap.putIfAbsent(Paths.get(randomFile.toString()), new AtomicInteger(1));
		}

	}

	public int getCount(Path randomFile) {

		if (concurrentHashMap.keySet().contains(randomFile)) {

			AtomicInteger indiCount = concurrentHashMap.get(randomFile);
			return indiCount.get();
		} else {

			return 0;
		}

	}

}
