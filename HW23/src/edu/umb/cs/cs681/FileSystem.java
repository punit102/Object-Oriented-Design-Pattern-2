package edu.umb.cs.cs681;

import java.util.ArrayList;
import java.util.Comparator;

public class FileSystem {

	private static FileSystem instance;
	private Directory root_dir;
	private Directory current_dir;
	private Directory dir;

	FileSystem(Directory dir) {
		this.dir = dir;
	}
	
	FileSystem()
	{
		
	}
	
	public void showAllElements() {
		dir.printName();
	}

	public void setRoot(Directory root) {
		this.root_dir = root;
	}

	public Directory getRoot() {
		return root_dir;
	}

	public void setCurrent(Directory current_dir) {
		this.current_dir = current_dir;
	}

	public Directory getCurrent() {
		return current_dir;
	}

	public void addChild(Directory current_dir, FSElement child) {
		
		current_dir.addChild(child, getInsertionLocation(current_dir, child));
	}

	public void removeChild(Directory current_dir, FSElement child) {
	
		current_dir.removeChild(child);
	}

	public ArrayList<FSElement> getChildren() {
		return getChildren();
	}

	public static FileSystem getInstance() {
		if (instance == null) {
			instance = new FileSystem();
		}
		return instance;
	}

	public void sort(Directory dir, Comparator<FSElement> f) {
		
		dir.getChildren().sort(f);
	}

	public int getInsertionLocation(Directory dir, FSElement fs) {

		for (int i = 0; i < dir.getChildren().size(); i++) {
			if (dir.getChildren().get(i).getName().compareToIgnoreCase(fs.getName()) == 0) {
				return -10;
			}
			if (dir.getChildren().get(i).getName().compareToIgnoreCase(fs.getName()) > 0) {
				return i;
			}
		}
		return dir.getChildren().size();
	}

}
