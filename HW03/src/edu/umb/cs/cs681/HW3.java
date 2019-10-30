package edu.umb.cs.cs681;

import java.awt.Point;
import java.util.ArrayList;

public class HW3 {

	public static void main(String[] args) {
		
		ArrayList<Point> al = new ArrayList<Point>();
		Polygon p = new Polygon(al);
		p.addPoint(new Point(0, 0));
		p.addPoint(new Point(4, 0));
		p.addPoint(new Point(0, 6));
		System.out.println("Variant code of HW2");
		System.out.println("Triangle Area:" + p.getArea());
		p.addPoint(new Point(4, 6));
		
		System.out.println("During Transformation Triangle to Rectangle");
		System.out.println("Rectangle area: " + p.getArea());
		
		System.out.println("Reverse transformation ");
		
		p.removeLast(new Point(4,6));
		
		System.out.println("After transformation Rectangle to Triangle ");
		System.out.println("Triangle area:"+p.getArea()); 

	}

}
