package geometries;
import java.util.ArrayList;
import java.util.List;

//import java.util.Collection;
import java.awt.Color;

import primitives.*;
//class geometry plane
public class Plane extends Geometry implements FlatGeometry
{
 protected Point3D point;
 protected Vector vector;
 
	/*--------constructors------------*/
public Plane(Color color,Material _mat, Point3D point, Vector vector)
//constructor
{
	super(color,_mat);
	this.point = point;
	this.vector = vector;
}
public Plane() 
//Default constructor
{
	super();
	this.point = new Point3D();
	this.vector = new Vector();
}
public Plane(Plane p) 
//copy constructor
{
	super(p.emission,p._material);
	this.point = new Point3D(p.point);
	this.vector = new Vector(p.vector);
}
/*------getter/setter------*/
public Point3D getPoint() 
//get point
{
	return new Point3D(this.point);
}
public void setPoint(Point3D point)
//set Point
{
	this.point = point;
}
public Vector getVector()
//get Vector
{
	return new Vector(this.vector);
}
public void setVector(Vector vector) 
//set Vector
{
	this.vector = vector;
}

@Override
public boolean equals(Object obj) 
//Check if planes is equals
{
	if (this == obj)//when the objects is equal
		return true;
	if (!super.equals(obj))//when the super(color) not equals
		return false;
	if (getClass() != obj.getClass())//the class is not equal
		return false;
	Plane other = (Plane) obj;//casting to Plane
	if (point == null) //Check point
	{
		if (other.point != null)
			return false;
	} else if (!point.equals(other.point))
		return false;
	if (vector == null) //Check vector
	{
		if (other.vector != null)
			return false;
	} else if (!vector.equals(other.vector))
		return false;
	return true;
}
@Override
public String toString()
//insert to string
{
	return "Plane [point=" + point + ", vector=" + vector + "]";
}
public Vector getNormal(Point3D p)
//the function return the normal in the plane
{
	
	return new Vector(this.vector.normalize());
	
}
public List<Point3D> findIntersections(Ray r)
//find Intersections function in plane
{
	List<Point3D> list= new ArrayList<Point3D>();
	//find the normal to plane
	Vector N=this.getNormal(this.point);
	//normalize the normal
	Vector n1= new Vector(N.normalize());
	//calculate to find Intersections
	Point3D Q0=this.getPoint();
	Point3D _p0=r.get_POO();
	Point3D pQ=_p0.substrct(new Vector(Q0));
//	Vector Nv= new Vector(n1);
	double dNV= n1.dotProduct(r.get_direction());
	double dPQ= n1.dotProduct(new Vector(pQ));
	double t= -1*(dPQ/dNV);
	if (t>0)// when the direction of ray other side of direction of the plane 
	{
		Vector direction=r.get_direction().scale(t);	
		Point3D p0=r.get_POO().add(direction);
    	Point3D p=new Point3D(p0);
	    //add to list
    	list.add(p);
	}
	return list;
	
}


}
