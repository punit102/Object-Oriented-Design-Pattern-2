package edu.umb.cs.cs681;

public class File extends FSElement {

	private int fileSize;
	public File(Directory parent, String name, String owner, int size) {
		super(parent, name, owner, size);
		this.fileSize = size;
	}
	
	public void printName() {
		System.out.print("       File:-" + getName()+"  Parent : "+getParent()+"\n");
	}

	public int getDiskUtil() {
		return fileSize;
	}
	
	
	
}
