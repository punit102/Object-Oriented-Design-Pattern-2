package edu.umb.cs.cs681;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Objects;


public class Polygon {
	private ArrayList<Point> points;
	private AreaCalculator areaCalc;
	
	public Polygon(ArrayList<Point> points,AreaCalculator areaCalc){
		this.points = Objects.requireNonNull(points);
		this.areaCalc = Objects.requireNonNull(areaCalc);	
	}
	
	AreaCalculator setAreaCalc(AreaCalculator areaCalc)
	{
		return this.areaCalc = Objects.requireNonNull(areaCalc);
	}
	public Point addPoint(Point point)
	{
			points.add(point);
			return point;
	}
	public Point removeLast(Point point)
	{
		points.remove(point);
		return point;
	}
	public float getArea()
	{
		return areaCalc.getArea(points);
	}
	
}
