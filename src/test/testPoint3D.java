package test;
import primitives.*;
import static org.junit.Assert.*;

import org.junit.Test;
//this part is tests to function in point3D class 

public class testPoint3D {

	@Test
	public void testAdd() 
	//test to add function
	{
		Coordinate c=new Coordinate(0);
		Point3D p1=new Point3D(c,c,c);		
		Coordinate c2=new Coordinate(20);		
		Point3D p2=new Point3D(c2,c2,c2);
		Vector v=new Vector(p2);
		Point3D p3= new Point3D(p1.add(v));
		assertEquals(p3, p2);		
		
		Point3D p1_=new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3));				
		Point3D p2_=new Point3D(new Coordinate(4),new Coordinate(5),new Coordinate(-2));
		Point3D p3_=new Point3D(new Coordinate(5),new Coordinate(7),new Coordinate(1));
		Vector v_=new Vector(p2_);
		Point3D p4=new Point3D(p1_.add(v_));
		assertEquals(p4, p3_);
		
	}
	@Test
	public void testSubtract() 
	//test to Subtract function
	{
		Coordinate c=new Coordinate(20);
		Point3D p1=new Point3D(c,c,c);
		Coordinate c2=new Coordinate(5);
		Point3D p2=new Point3D(c2,c2,c2);
		Vector v=new Vector(p2);
		Coordinate c3=new Coordinate(15);
		Point3D p3=new Point3D(c3,c3,c3);
		Point3D p4=new Point3D(p1.substrct(v));
		assertEquals(p4, p3);
	}

}
