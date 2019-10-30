package edu.umb.cs.cs681;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class AccessCounter {

	private HashMap<Path, Integer> acmap;
	private ArrayList<Path> acmapfiles;
	private Random randomGenerator;
	//private Path randomFile;
	private int fileCount;

	public AccessCounter() {
		acmap = new HashMap<Path, Integer>();
		acmapfiles = new ArrayList<Path>();
		randomGenerator = new Random();
		acmapfiles.add(Paths.get("file_root","a.html"));
		acmapfiles.add(Paths.get("file_root","b.html"));
		acmapfiles.add(Paths.get("file_root","c.html"));
		acmapfiles.add(Paths.get("file_root","d.html"));
		acmapfiles.add(Paths.get("file_root","e.html"));	
	}

	public Path getRamdomPath() {
		int index = randomGenerator.nextInt(acmapfiles.size());
		Path randomFile = acmapfiles.get(index);
		return randomFile;
	}

	public void increment(Path randomFile) {
	
		if (acmap.containsKey(randomFile)) {
			
			fileCount = acmap.get(randomFile);
			//++fileCount;
			acmap.put(Paths.get(randomFile.toString()), ++fileCount);
		} else {
			
			acmap.put(Paths.get(randomFile.toString()), 1);
		}

	}

	public int getCount(Path randomFile) {

		if (acmap.containsKey(randomFile)) {
			int indiCount = acmap.get(randomFile);
			return indiCount;
		} else {
			return 0;
		}

	}

}
