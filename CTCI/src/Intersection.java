import java.util.Scanner;

public class Intersection {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x11 = sc.nextDouble();
		double y11 = sc.nextDouble();
		double x12 = sc.nextDouble();
		double y12 = sc.nextDouble();
		
		Point p11 = new Point(x11, y11);
		Point p12 = new Point(x12, y12);
		
		double x21 = sc.nextDouble();
		double y21 = sc.nextDouble();
		double x22 = sc.nextDouble();
		double y22 = sc.nextDouble();
		
		Point p21 = new Point(x21, y21);
		Point p22 = new Point(x22, y22);
		
		Line l1 = new Line(p11, p12);
		Line l2 = new Line(p21, p22);
		
		Point intersect = l1.getIntersect(l2);
		
		if(intersect == null) {
			System.out.println("No Intersection.");
		}
		else {
			System.out.println("Intersection = (" + intersect.x + "," + intersect.y + ").");
		}
	}
	
}

class Point{
	double x;
	double y;
	
	Point(double x, double y){
		this.x = x;
		this.y = y;
	}
}

class Line{
	Point p1;
	Point p2;
	double slope;
	double intercept;
	
	Line(Point p1, Point p2){
		this.p1 = p1;
		this.p2 = p2;
		this.slope = (p2.y - p1.y) / (p2.x - p1.x);
		this.intercept = p1.y - slope * p1.x;
	}
	
	Point getIntersect(Line l2) {
		if(this.slope == l2.slope) {
			if(this.intercept == l2.intercept) {
				if(this.isOnLine(l2.p1)) {
					return l2.p1;
				}
				else if(this.isOnLine(l2.p2)) {
					return l2.p2;
				}
				else {
					return null;
				}
			}
			else {
				return null;
			}
		}
		else {
			double x = (l2.intercept - this.intercept) / (this.slope - l2.slope);
			double y = x * this.slope + this.intercept;
			Point intersect = new Point(x, y);
			if(this.isOnLine(intersect) && l2.isOnLine(intersect)) {
				return intersect;
			}
			else {
				return null;
			}
		}
	}
	
	boolean isOnLine(Point p) {
		if(p.x >= this.p1.x && p.x <= this.p2.x && p.y >= this.p1.y && p.y <= this.p2.y) {
			return true;
		}
		else {
			return false;
		}
	}
}