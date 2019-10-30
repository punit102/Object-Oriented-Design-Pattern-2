package edu.umb.cs.cs681;

public class HW23 {


	public static void main(String args[])
	{
		
		Directory abc = new Directory(null, "abc", "Tonny", 0);
		File a = new File(abc, "a.txt", "Tonny", 5);
		File b = new File(abc, "b.txt", "Tonny", 10);
		File c = new File(abc, "c.txt", "Tonny", 5);
		File d = new File(abc, "d.txt", "Tonny", 10);
		File e = new File(abc, "e.txt", "Tonny", 5);
		abc.appendChild(a);
		abc.appendChild(b);
		abc.appendChild(c);
		abc.appendChild(d);
		abc.appendChild(e);
		
		FileQueue filequeue = new FileQueue();		
		
		FileCrawler crawler = new FileCrawler(abc,filequeue);
		FileIndexer indexer = new FileIndexer(filequeue);

		Thread ti1 = new Thread(crawler);
		Thread ti2 = new Thread(indexer);
		ti1.start();
		ti2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		crawler.setDone();
		indexer.setDone();
		System.exit(0);
	
	}

}
