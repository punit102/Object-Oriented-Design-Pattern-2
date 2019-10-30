package edu.umb.cs.cs681;

public class FSElement {

	private String name;
	private String owner;
	private int size;
	private Directory parent;
	private Boolean isFile;

	public FSElement(Directory parent, String name, String owner, int size) {
		this.parent = parent;
		this.name = name;
		this.owner = owner;
		this.size = size;
	}

	public Directory getParent() {
		return parent;
	}

	boolean isFile() {

		isFile = this instanceof File;
		return isFile;
	}

	public int getSize() {
		return size;
	}

	public String getName() {
		return name;

	}

	public String getOwner() {
		return owner;
	}

	public String toString() {
		return name;
	}

	public void printName() {

	}

	public String changeOwner(String ownerName) {
		this.owner = ownerName;
		return owner;
	}
	
	public int getDiskUtil() {
		return 0;
	}

	
	
	
	
	

}