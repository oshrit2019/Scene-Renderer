package test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import geometries.*;
import primitives.*;
import org.junit.Test;
//this part is tests to function in sphere class

public class testSphere {

	@Test
	public void testGetNormal() 
	//test to get normal function
	{
		Color c=Color.black;
		Coordinate coor=new Coordinate(0);
		Point3D p1=new Point3D(coor,coor,coor);
		Point3D p2= new Point3D(new Coordinate(1), coor, coor);
		Point3D p3= new Point3D(new Coordinate(-1), coor, coor);
		Sphere sp =new Sphere(c,new Material(),1, p1);
		Vector v=sp.getNormal(p2);
		assertEquals(v, new Vector(p3));
	}
	
	@Test
	public void IntersectionTest()
	// test to find Intersection with sphere
	{
		Sphere s = new Sphere(new Color(1,0,0),new Material(),200,new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-400)));
		double h = Math.pow(3, -0.5);
		Coordinate c1=new Coordinate(h);
		Coordinate c2=new Coordinate(-h);
        Point3D p1=new Point3D(c1,c2,c2);
		Ray ray =new Ray(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0)),new Vector(p1));
		List<Point3D> intersections = s.findIntersections(ray);
		assertEquals(intersections.isEmpty(),true);
		
	    Coordinate c3=new Coordinate(0);
		Coordinate c4=new Coordinate(-1);
        Point3D p2=new Point3D(c3,c3,c4);
		Ray ray1 =new Ray(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0)),new Vector(p2));
		List<Point3D> intersections1 = s.findIntersections(ray1);
		List<Point3D> temp = new ArrayList<Point3D>();
		temp.add(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-200)));
		temp.add(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-600)));
		assertEquals(intersections1,temp);
	}

}
