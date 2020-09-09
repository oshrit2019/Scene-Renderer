package test;
import geometries.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.Collection;
import elements.*;
import primitives.*;
import static org.junit.Assert.*;
import java.awt.Color;
import org.junit.Test;
//this part is tests to function in plane class
public class testPlane {

	@Test
	public void testGetNormal() 
	//test to get normal function
	{
		Color c=Color.black;
		Material _mat=new Material();
		Coordinate coor=new Coordinate(0);
		Point3D p1=new Point3D(new Coordinate(1),new Coordinate(1),coor);
		Point3D p3=new Point3D(coor,coor,new Coordinate(1));
		Vector v1=new Vector(p1);
		Vector v2=new Vector(new Point3D(new Coordinate(1),new Coordinate(1),coor));
		Vector v2_=v2.normalize();
		Plane pl=new Plane(c,_mat,p1,v1);
		Vector v3=pl.getNormal(p3);
		assertEquals(v2_, v3);		
	}
	
	@Test
	public void testIntersectionPoints()
	//test Intersection Points
	{
		Vector vector_direction=new Vector
	    (new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-1)));
		Point3D p=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-3));
		Material _mat=new Material();
		//defined plane
		Plane plane=new Plane(Color.black,_mat,p,vector_direction);
		Coordinate c=new Coordinate(0);
		Point3D pUp=new Point3D(c,new Coordinate(1),c);
		Point3D pTo=new Point3D(c,c,new Coordinate(-1));
		Point3D pRight=new Point3D(new Coordinate(1),c,c);	
		Point3D p0=new Point3D(c,c,c);
		Vector vUp=new Vector(pUp);
		Vector vTo=new Vector(pTo);
		//defined camera
		Vector vRight=new Vector(pRight);
		Camera cam=new Camera(p0,vUp,vTo,vRight);
		//call to construct Ray function
		List<Ray> r= cam.constructRayThroughPixel(3,3,1,1,1,9,9);
		//call to find Intersections function
		List<Point3D> list=plane.findIntersections(r.get(0));
		Point3D p2=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-3));
		List<Point3D> list2= new ArrayList<Point3D>();
		//add to list
		list2.add(p2);
		assertEquals(list,list2);		
        Point3D p5=new Point3D(list.get(0));
        assertEquals(p2,p5);		

	        	Vector _vector_direction=new Vector
			    (new Point3D(new Coordinate(-3),new Coordinate(-3),new Coordinate(0)));
				Point3D _p=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-3));
				//defined plane
				Plane _plane=new Plane(Color.black,_mat,_p,_vector_direction);
				Coordinate _c=new Coordinate(0);
				Point3D _pUp=new Point3D(_c,new Coordinate(1),_c);
				Point3D _pTo=new Point3D(_c,_c,new Coordinate(-1));
				Point3D _pRight=new Point3D(new Coordinate(1),_c,_c);	
				Point3D _p0=new Point3D(_c,_c,_c);
				Vector _vUp=new Vector(_pUp);
				Vector _vTo=new Vector(_pTo);
				Vector _vRight=new Vector(_pRight);
				//defined camera
				Camera _cam=new Camera(_p0,_vUp,_vTo,_vRight);
				//call to construct Ray function
				List<Ray> _r= _cam.constructRayThroughPixel(3,3,2,0,1,9,9);
				//call to find Intersections function
				List<Point3D> _list=_plane.findIntersections(_r.get(0));
				Point3D _p2=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0));
				List<Point3D> _list2= new ArrayList<Point3D>();
				//add to list 
				_list2.add(_p2);
				assertEquals(_list,_list2);
				Point3D _p5=new Point3D(_list.get(0));
				assertEquals(_p2,_p5);
	}

}
