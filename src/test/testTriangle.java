package test;
import static org.junit.Assert.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import geometries.*;
import primitives.*;
import org.junit.Test;
//this part is tests to function in Triangle class
public class testTriangle {

	@Test
	public void testGetNormal() 
	//test to get normal function
	{
		Color c=Color.black;
		Coordinate coor1=new Coordinate(0);
		Coordinate coor2=new Coordinate(1);
		Point3D p1=new Point3D(coor2,coor1,coor1);
		Point3D p2=new Point3D(coor1,coor2,coor1);
		Point3D p3=new Point3D(coor1,coor1,coor2);
		Triangle tr=new Triangle(c,new Material(),p1,p2,p3);
		Vector v1=tr.getNormal(p1);
		Coordinate coor3= new Coordinate((double)(1/Math.sqrt(3)));
		Point3D p4=new Point3D(coor3,coor3,coor3);
        Vector v2=new Vector(p4);
        assertEquals(v2, v1);

	}
	
	@Test
	public void IntersectionTest()
	// test to find Intersection with triangle
	{
		Triangle t =new Triangle(new Color(0),new Material(), new Point3D(new Coordinate(100),new Coordinate(-100),new Coordinate(-200)), 
				new Point3D(new Coordinate(-100),new Coordinate(-100),new Coordinate(-200)),
				new Point3D(new Coordinate(0),new Coordinate(100),new Coordinate(-200)));
		double h = Math.pow(3, -0.5);
		Coordinate c=new Coordinate(0);
		Point3D p1=new Point3D(new Coordinate(h),new Coordinate(-h),new Coordinate(-h));
		Ray ray =new Ray(new Point3D(c,c,c),new Vector(p1));
		List<Point3D> intersections = t.findIntersections(ray);
		assertEquals(intersections.isEmpty(),true);
	
		Point3D p2=new Point3D(c,c,new Coordinate(-1));
		Ray ray1 =new Ray(new Point3D(c,c,c),new Vector(p2));
		List<Point3D> intersections1 = t.findIntersections(ray1);
		List<Point3D> temp = new ArrayList<Point3D>();
		Point3D p3=new Point3D	(c,c,new Coordinate(-200));
		temp.add(new Point3D(p3));
		assertEquals(intersections1,temp);
		
		Point3D p4=new Point3D	(new Coordinate(2),new Coordinate(-2),new Coordinate(-5));
		Ray ray2 =new Ray(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0)),new Vector(p4));
		List<Point3D> intersections2 = t.findIntersections(ray2);
		List<Point3D> temp2 = new ArrayList<Point3D>();
		temp2.add(new Point3D(new Coordinate(80),new Coordinate(-80),new Coordinate(-200)));
		assertEquals(intersections2,temp2);
		
		
	}

}
