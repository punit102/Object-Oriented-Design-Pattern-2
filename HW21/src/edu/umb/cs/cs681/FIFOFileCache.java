package edu.umb.cs.cs681;

import java.io.File;
import java.util.Collections;

public class FIFOFileCache extends FileCache{

	void replace(String targetFile) {

		int maxKey = Collections.max(getCache().keySet());
		int minKey = Collections.min(getCache().keySet());
		getCache().remove(minKey);
		getCache().put(++maxKey, new File(targetFile));
	}
	
	
}
