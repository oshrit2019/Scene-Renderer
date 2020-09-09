package test;

import static org.junit.Assert.*;

import java.util.List;

import primitives.*;
import org.junit.Test;
import elements.*;
//this part is test for the function in class camera
public class CameraTests {

	@Test
	public void testRaysConstruction() 
	//test to rays construction
	{
		Coordinate c=new Coordinate(0);
		Point3D pUp=new Point3D(c,new Coordinate(1),c);
		Point3D pTo=new Point3D(c,c,new Coordinate(-1));
		Point3D pRight=new Point3D(new Coordinate(1),c,c);	
		Point3D p0=new Point3D(c,c,c);
		Vector vUp=new Vector(pUp);
		Vector vTo=new Vector(pTo);
		Vector vRight=new Vector(pRight);
		Camera cam=new Camera(p0,vUp,vTo,vRight);		
		List<Ray> r1= cam.constructRayThroughPixel(3,3,0,0,1,9,9);
		Point3D p1=new Point3D (new Coordinate(0),new Coordinate(0),new Coordinate(0));
		Point3D p2=new Point3D (new Coordinate(-3),new Coordinate(3),new Coordinate(-1));
		Vector v=new Vector(p2);
		Vector v3=v.normalize();
		Ray r2=new Ray(p1,v3);
		assertEquals(r1,r2);
		
		
		
		Coordinate c_=new Coordinate(0);
		Point3D pUp_=new Point3D(c_,new Coordinate(1),c_);
		Point3D pTo_=new Point3D(c_,c_,new Coordinate(-1));
		Point3D pRight_=new Point3D(new Coordinate(1),c_,c_);	
		Point3D p0_=new Point3D(c_,c_,c_);
		Vector vUp_=new Vector(pUp_);
		Vector vTo_=new Vector(pTo_);
		Vector vRight_=new Vector(pRight_);
		Camera cam_=new Camera(p0_,vUp_,vTo_,vRight_);		
		List<Ray> r1_= cam_.constructRayThroughPixel(4,3,2,1,2,16,9);
		Point3D p1_=new Point3D (new Coordinate(0),new Coordinate(0),new Coordinate(0));
		Point3D p2_=new Point3D (new Coordinate(-2),new Coordinate(-3),new Coordinate(-2));
		Vector v_=new Vector(p2_);
		Vector v3_=v_.normalize();
		Ray r2_=new Ray(p1_,v3_);
		System.out.println(r1_);
		assertEquals(r1_,r2_);
		
	}

}
