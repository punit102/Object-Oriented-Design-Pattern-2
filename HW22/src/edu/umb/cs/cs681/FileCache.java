package edu.umb.cs.cs681;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantReadWriteLock;

abstract class FileCache {

	private HashMap<Integer, File> cache = new HashMap<Integer, File>();
	private ArrayList<String> cacheFiles = new ArrayList<String>();
	private int i = 1;
	private final int size = 3;
	private String fileContent;
	private Scanner scanner;
	private ReentrantReadWriteLock rwlock;

	public int doIncrement() {
		return i++;
	}
	
	public FileCache()
	{
		rwlock = new ReentrantReadWriteLock();
	}
	
	
	
	public String fetch(String targetFile) throws FileNotFoundException {
		rwlock.writeLock().lock();
		try {
			if (cacheFiles.contains(targetFile)) {
				scanner = new Scanner(new File(targetFile));
				while (scanner.hasNextLine()) {
					fileContent = scanner.nextLine();
					System.out.println("Your inserted file is already in the cache and its content is: " + fileContent);
				}

			} else {
				if (cache.size() < size) {
					cacheFiles.add(targetFile);
					cacheFile(targetFile);
					scanner = new Scanner(new File(targetFile));
					while (scanner.hasNextLine()) {
						fileContent = scanner.nextLine();
					}

					System.out.println("This is new File and it is successfully Added: " + targetFile);
					System.out.println("THis added file content is: " + fileContent);
				} else {

					cacheFiles.remove(0);
					replace(targetFile);
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

			rwlock.readLock().lock();
		} finally {
			rwlock.writeLock().unlock();
		}

		// System.out.println("Hashmap:"+cache);
		// System.out.println("ArrayList:"+cacheFiles);
		try {

			return fileContent;
		}

		finally {
			rwlock.readLock().unlock();
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
