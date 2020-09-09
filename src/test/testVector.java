package test;
import primitives.*;

import static org.junit.Assert.*;
import org.junit.Test;
//this part is tests to function in vector class 
public class testVector {

	@Test
	public void testAdd()
	//test to add function
	{
		Coordinate c=new Coordinate(5);
		Point3D p1=new Point3D(c,c,c);
		Vector v1=new Vector(p1);		
		Coordinate c2=new Coordinate(20);
		Point3D p2=new Point3D(c2,c2,c2);
		Vector v2=new Vector(p2);
		Vector v3= new Vector(v1.add(v2));
		Coordinate c3=new Coordinate(25);
		Point3D p4=new Point3D(c3,c3,c3);
		Vector v4=new Vector(p4);
		assertEquals(v3, v4);
		System.out.println(v3);
		
	}
	@Test
	public void testSubtract() 
	//test to Subtract function
	{
		Coordinate c=new Coordinate(20);
		Point3D p1=new Point3D(c,c,c);
		Vector v1=new Vector(p1);
		Coordinate c2=new Coordinate(5);
		Point3D p2=new Point3D(c2,c2,c2);
		Vector v2=new Vector(p2);
		Coordinate c3=new Coordinate(15);
		Point3D p3=new Point3D(c3,c3,c3);
		Vector v3=new Vector(p3);
		Vector v4= new Vector(v1.substrct(v2));
		System.out.println(v4);
		assertEquals(v4,v3);
	}
	@Test
	public void testScaling()
	//test to Scaling function
	{
		Coordinate c=new Coordinate(20);
		Point3D p1=new Point3D(c,c,c);
		Vector v1=new Vector(p1);
		Coordinate c2=new Coordinate(40);
		Point3D p2=new Point3D(c2,c2,c2);
		Vector v2=new Vector(p2);
		Vector v3 = new Vector(v1.scale(2));
		assertEquals(v3,v2);
	}
	@Test
	public void testNormalize () 
	//test to normalize function
	{
		Coordinate c=new Coordinate(0);
		Coordinate c2=new Coordinate(4);

		Point3D p1=new Point3D(c,c2,c);
		Vector v1=new Vector(p1);
		Coordinate c3=new Coordinate(1);
		Point3D p2=new Point3D(c,c3,c);
		Vector v2=new Vector(p2);
		Vector v3= new Vector(v1.normalize());
		assertEquals(v3,v2);
	}
	 
	@Test
	public void testLength () 
	//test to length function
	{
		Coordinate c=new Coordinate(3);
		Point3D p1=new Point3D(c,c,c);
		Vector v1=new Vector(p1);
		double x=5.196152423;
		double y=v1.length();
		assertEquals(y,x,0.002);
	}
	@Test
	public void testCrossProduct() 
	//test to cross product function
	{
		Coordinate c=new Coordinate(3);
		Point3D p1=new Point3D(c,c,c);
		Vector v1=new Vector(p1);
		 c=new Coordinate(2);
		Point3D p2=new Point3D(c,c,c);
		Vector v2=new Vector(p2);
		 c=new Coordinate(0);
		Point3D p3=new Point3D(c,c,c);
		Vector v3=new Vector(p3);
		
		Vector v4=v1.crossProduct(v2);
		assertEquals(v4,v3);
	}
	@Test
	public void  testDotProduct()
	//test to dot product function
	{
		Coordinate c=new Coordinate(3);
		Point3D p1=new Point3D(c,c,c);
		Vector v1=new Vector(p1);
		c=new Coordinate(3);
		Point3D p2=new Point3D(c,c,c);
		Vector v2=new Vector(p2);
		double x=v1.dotProduct(v2);
		double y=27;
		assertEquals(x,y,0.0);
	}
}
