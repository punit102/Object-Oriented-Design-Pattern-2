package edu.umb.cs.cs681;

public class Link extends FSElement {

	private FSElement target;
	private int size;

	public Link(Directory parent, String name, String owner, int size, FSElement target) {
		super(parent, name, owner, size);
		this.target = target;
		this.size = size;

	}
	
	public void printName() {
		System.out.print("       Link:-" + getName()+"  Parent : "+getParent()+"\n");
	}
	
	public int getSize() {
		return size;
	}

	public int getTargetSize() {
		return target.getSize();
	}
	
	public int getDiskUtil() {
		return 0;
	}
	
	

}
