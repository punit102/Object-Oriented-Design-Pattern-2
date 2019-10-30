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

	public Polygon(ArrayList<Point> points){
				this(points,(Polygon p)->{
				if(points.size() == 3)
				{
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
				}
				else 
				{
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
				}		
			});	
		}
	
	public ArrayList<Point> getPoint()
	{
		return points;
	}

	public AreaCalculator setAreaCalc(AreaCalculator areaCalc)
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
		return areaCalc.getArea(this);
	}
	
}