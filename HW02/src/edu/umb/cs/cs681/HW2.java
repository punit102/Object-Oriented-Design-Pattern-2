package edu.umb.cs.cs681;

import java.awt.Point;
import java.util.ArrayList;

public class HW2 {

	public static void main(String[] args) {
		ArrayList<Point> al = new ArrayList<Point>();
		al.add(new Point(0, 0));
		al.add(new Point(4, 0));
		al.add(new Point(0, 6));

		Polygon p = new Polygon(al, (ArrayList<Point> points) -> {
			double x1 = points.get(0).getX();
			double y1 = points.get(0).getY();
			double x2 = points.get(1).getX();
			double y2 = points.get(1).getY();
			double x3 = points.get(2).getX();
			double y3 = points.get(2).getY();
			double a = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
			double b = Math.sqrt(Math.pow(Math.abs(x2 - x3), 2) + Math.pow(Math.abs(y2 - y3), 2));
			double c = Math.sqrt(Math.pow(Math.abs(x3 - x1), 2) + Math.pow(Math.abs(y3 - y1), 2));
			double s = (a + b + c) / 2;
			float area = (float) Math.sqrt(s * (s - a) * (s - b) * (s - c));
			return area;
		});
		System.out.println("Triangle area: " + p.getArea());

		p.addPoint(new Point(4, 6));
		p.setAreaCalc((ArrayList<Point> points) -> {
			double x1 = points.get(0).getX();
			double y1 = points.get(0).getY();
			double x2 = points.get(1).getX();
			double y2 = points.get(1).getY();
			double x3 = points.get(2).getX();
			double y3 = points.get(2).getY();
			//double x4 = points.get(3).getX();
			//double y4 = points.get(3).getY();
			double a = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
			double b = Math.sqrt(Math.pow(Math.abs(x1 - x3), 2) + Math.pow(Math.abs(y1 - y3), 2));
			double area = a * b;
			return (float) area;
		});
		
		System.out.println("During Transformation Triangle to Rectangle");
		System.out.println("Rectangle area: " + p.getArea());
		
		System.out.println("Reverse transformation ");
		
		p.removeLast(new Point(4, 6));
		
		p.setAreaCalc((ArrayList<Point> points) -> {
			double x1 = points.get(0).getX();
			double y1 = points.get(0).getY();
			double x2 = points.get(1).getX();
			double y2 = points.get(1).getY();
			double x3 = points.get(2).getX();
			double y3 = points.get(2).getY();
			double a = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
			double b = Math.sqrt(Math.pow(Math.abs(x2 - x3), 2) + Math.pow(Math.abs(y2 - y3), 2));
			double c = Math.sqrt(Math.pow(Math.abs(x3 - x1), 2) + Math.pow(Math.abs(y3 - y1), 2));
			double s = (a + b + c) / 2;
			float area = (float) Math.sqrt(s * (s - a) * (s - b) * (s - c));
			return area;
		});
		
		System.out.println("After transformation Rectangle to Triangle ");
		System.out.println("Triangle area:"+p.getArea()); 
		
		
	}
}
