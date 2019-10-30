package edu.umb.cs.cs681;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

abstract class FileCache {

	private HashMap<Integer, File> cache = new HashMap<Integer, File>();
	private ArrayList<String> cacheFiles = new ArrayList<String>();
	private int i = 1;
	private final int size = 3;
	private String fileContent;
	private Scanner scanner;
	private ReentrantLock lock = new ReentrantLock();

	public int doIncrement() {
		return i++;
	}

	public String fetch(String targetFile) throws FileNotFoundException {
		lock.lock();
		try{
			if (cacheFiles.contains(targetFile)) {
				scanner = new Scanner(new File(targetFile));
				while (scanner.hasNextLine()) {
					fileContent = scanner.nextLine();
					System.out.println("Your inserted file is already in the cache and its content is: " + fileContent);
				}

			} else {
				if (cache.size() < size) {
					cacheFiles.add(targetFile);
					lock.lock();
					try {
						cacheFile(targetFile);
					} finally {
						lock.unlock();
					}
					scanner = new Scanner(new File(targetFile));
					while (scanner.hasNextLine()) {
						fileContent = scanner.nextLine();
					}

					System.out.println("This is new File and it is successfully Added: " + targetFile);
					System.out.println("THis added file content is: " + fileContent);
				} else {

					cacheFiles.remove(0);
					lock.lock();
					try {
						replace(targetFile);
					} finally {
						lock.unlock();
					}

					cacheFiles.add(targetFile);

					scanner = new Scanner(new File(targetFile));
					while (scanner.hasNextLine()) {
						fileContent = scanner.nextLine();
						System.out.println("We added this file " + targetFile
								+ " and raplce with other system file using FIFO implementation");
						System.out.println("Your file content is: " + fileContent);

					}

				}

			}
			// System.out.println("Hashmap:"+cache);
			// System.out.println("ArrayList:"+cacheFiles);
			return fileContent;
		}
		finally
		{
			lock.unlock();
		}
		

	}

	private void cacheFile(String targetFile) {
		this.cache.put(doIncrement(), new File(targetFile));
	}

	abstract void replace(String targetFile);

	public HashMap<Integer, File> getCache() {
		return cache;
	}

}
