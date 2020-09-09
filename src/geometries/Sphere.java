package geometries;
import java.util.ArrayList;
import java.util.List;

import java.awt.Color;

import primitives.*;
//class geometry sphere
public class Sphere extends Geometry 
{
	protected  double _radius;
	protected  Point3D _center;
	
	/*--------constructors------------*/
	public Sphere(Color color,Material _mat, double _radius, Point3D _center) 
	//constructor
	{
		super(color,_mat);
		this._radius = _radius;
		this._center = _center;
	}
	public Sphere() 
	//default constructor 
	{
		super();
		this._radius = 0;
		this._center =new Point3D();
	}
	public Sphere(Sphere s) 
	//copy constructor
	{
		super(s.emission,s._material);
		this._radius = s._radius;
		this._center = new Point3D(s._center);
	}
	/*------getter/setter------*/
	public double get_radius()	
	//get radius
	{
		return _radius;
	}
	public void set_radius(double _radius) 
	//set radius
	{
		this._radius = _radius;
	}
	public Point3D get_center() 
	//get center
	{
		return new Point3D(_center);
	}
	public void set_center(Point3D _center)
	//set center
	{
		this._center = _center;
	}

	@Override
	public boolean equals(Object obj)
	//Check if sphere is equals
	{
		if (this == obj)//when the objects is equal
			return true;
		if (!super.equals(obj))//when the super(color) not equals
			return false;
		if (getClass() != obj.getClass())//the class is not equal
			return false;
		Sphere other = (Sphere) obj;//casting to Sphere
		if (_center == null) {
			if (other._center != null)
				return false;
		} else if (!_center.equals(other._center))
			return false;
		if (Double.doubleToLongBits(_radius) != Double.doubleToLongBits(other._radius))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sphere [_radius=" + _radius + ", _center=" + _center + "]";
	}
	public Vector getNormal(Point3D p)
	//the function return the normal in the Sphere
	{
		Vector v=new Vector(p.substrct(new Vector(_center))).normalize();
		return v;
	}
	
	
	public List<Point3D> findIntersections(Ray r)
	//find Intersections function
	{
		/*List <Point3D> lst=new ArrayList<Point3D>();
		Point3D L= this._center.substrct(new Vector(r.get_POO()));
		Vector Vl=new Vector(L);
		Vector vdirection= r.get_direction().normalize();
		double	tm=Vl.dotProduct(vdirection);
		double lengthL=Vl.length();
		double d=Math.pow((Math.pow(lengthL, 2)-Math.pow(tm, 2)),0.5);
		//Check if the point in or on the sphere
		if(d>this._radius)
		{
		return lst;
		}
		else
		{
			double th= Math.pow(Math.pow(this._radius, 2)-Math.pow(d,2), 0.5);
			double t1= tm-th;
			double t2= tm+th;
			//calculate P1
			if(t1>0)
			{
				Vector v=new Vector(vdirection.scale(t1));
				Point3D p1=new Point3D(r.get_POO().add(v));
				lst.add(p1);
				
			}
			//calculate P2
			if(t2>0 && t1!=t2)
			{
				Vector v2=new Vector(vdirection.scale(t2));
				Point3D p2=new Point3D(r.get_POO().add(v2));
				lst.add(p2);
			}
			return lst;
			
		}*/
		List<Point3D> Intersections = new ArrayList<Point3D>();
		Vector V = r.get_direction().normalize();
		Vector L = new Vector (_center.substrct(new Vector(r.get_POO())));
		double tm = L.dotProduct(V);
		double d = Math.sqrt((Math.pow(L.length(),2)- Math.pow(tm, 2)));
		if (d > this._radius)
			return Intersections;
		double th = Math.pow(Math.pow(this.get_radius(), 2)- Math.pow(d, 2),0.5);
		double t1 = tm - th;
		double t2 = tm + th;
		if (t1 >0)
			Intersections.add(new Point3D(r.get_POO().add(new Vector(V.scale(t1).get_head()))));
		if (t2 >0)
			Intersections.add(new Point3D(r.get_POO().add(new Vector(V.scale(t2).get_head()))));
		return Intersections;
	}
	
	
}
