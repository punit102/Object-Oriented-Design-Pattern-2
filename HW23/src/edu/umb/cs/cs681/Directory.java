package edu.umb.cs.cs681;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends FSElement {

	private ArrayList<FSElement> fselements;
	private FileSystem fs;

	public Directory(Directory parent, String name, String owner, int size) {
		super(parent, name, owner, size);
		fs = FileSystem.getInstance();
		fselements = new ArrayList<FSElement>();
	}

	public ArrayList<FSElement> getChildren() {
		return fselements;
	}

	public void appendChild(FSElement f) {
		addChild(f, fs.getInsertionLocation(this, f));
		
	}

	public void removeChild(FSElement f) {
		fselements.remove(f);
	}

	
	public void printName() {
		System.out.print(" Directory:- " + getName() + "  Parent :" + getParent()+"\n");
		Iterator<FSElement> fileIterator = fselements.iterator();
		while (fileIterator.hasNext()) {
			FSElement file = fileIterator.next();
			file.printName();
		}
		
	}
	
	public int getSize() {
		int totalSize = 0;
		for (FSElement temp : fselements) {

			totalSize = totalSize + temp.getSize();
		}
		return totalSize;
	}
	
	public int getDiskUtil() {
		return 0;
	}

	public void addChild(FSElement child, int insertionLocation) {
		fselements.add(insertionLocation, child);

	}
	
}
