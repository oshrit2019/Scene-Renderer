package geometries;
import java.util.ArrayList;
import java.util.List;


import java.awt.Color;


import primitives.*;
//class for geometry triangle
public class Triangle extends Geometry implements FlatGeometry
{

	protected Point3D _p1;
	protected Point3D _p2;
	protected Point3D _p3;

	/*--------constructors------------*/
	public Triangle(Color color,Material _mat, Point3D _p1, Point3D _p2, Point3D _p3) 
	{// constructor
		super(color,_mat);
		this._p1 = _p1;
		this._p2 = _p2;
		this._p3 = _p3;
	}

	public Triangle()
	{//Default constructor
		super();
		Point3D p =new Point3D();
		this._p1 = p;
		this._p2 = p;
		this._p3 = p;
	}

	public Triangle(Triangle t) 
	{//copy constructor
		super(t.emission,t._material);
		this._p1 = new Point3D(t._p1);
		this._p2 = new Point3D(t._p2);
		this._p3 = new Point3D(t._p3);
	}
	/*------getter/setter------*/
	public Point3D get_p1() 
	{//get p1
		return new Point3D(_p1);
	}

	public void set_p1(Point3D _p1) 
	{//set p1
		this._p1 = _p1;
	}

	public Point3D get_p2() 
	{//get p2
		return new Point3D(_p2);
	}

	public void set_p2(Point3D _p2) 
	{//set p2
		this._p2 = _p2;
	}

	public Point3D get_p3() 
	{//get p3
		return new Point3D(_p3);
	}

	public void set_p3(Point3D _p3) 
	{//set p3
		this._p3 = _p3;
	}
	@Override
	public boolean equals(Object obj) 
	{	//check if the triangles is equal
		if (this == obj)//when the objects is equal
			return true;
		if (!super.equals(obj))//when the super(color) not equals 
			return false;
		if (getClass() != obj.getClass())//the class is not equal
			return false;
		Triangle other = (Triangle) obj;
		if (_p1 == null) {
			if (other._p1 != null)// check p1
				return false;
		} else if (!_p1.equals(other._p1))//when the p1 not equal
			return false;
		if (_p2 == null) {
			if (other._p2 != null)//check p2
				return false;
		} else if (!_p2.equals(other._p2))//when the p2 not equal
			return false;
		if (_p3 == null) {
			if (other._p3 != null)//check p3
				return false;
		} else if (!_p3.equals(other._p3))//when the p3 not equal
			return false;
		return true;
	}

	@Override
	public String toString() 
	{	//insert to string
		return "Triangle [_p1=" + _p1 + ", _p2=" + _p2 + ", _p3=" + _p3 + "]";
	}

	public Vector getNormal(Point3D p)
	//the function return the normal in the triangle
	{

		Vector v1 = new Vector(this._p1.substrct(new Vector(this._p3)));
		Vector v2 = new Vector(this._p2.substrct(new Vector(this._p3)));
		return v1.crossProduct(v2).normalize();
	}


	public List<Point3D> findIntersections(Ray r)
	//find Intersections function
	{
		
		Vector Normal=this.getNormal(_p2);//find normal to triangle
		Plane pl=new Plane(super.getEmission(),super.get_material(), this._p1,Normal.normalize());//plane
		
		List<Point3D> tempIntersection= pl.findIntersections(r);
		List<Point3D> Intersections = new ArrayList<Point3D>();
		
		if(tempIntersection.isEmpty())
			return Intersections;
		//Calculate if point in the triangle 
		Vector v1 = new Vector (this._p1.substrct(new Vector(r.get_POO())));
		Vector v2 = new Vector (this._p2.substrct(new Vector(r.get_POO())));
		Vector v3 = new Vector (this._p3.substrct(new Vector(r.get_POO())));
		Vector N1 = new Vector(v2.crossProduct(v1).normalize());
		Vector N2 = new Vector(v3.crossProduct(v2).normalize());
		Vector N3 = new Vector(v1.crossProduct(v3).normalize());
		Point3D p_tmp = tempIntersection.get(0);
		Vector v = new Vector(p_tmp.substrct(new Vector(r.get_POO())));

		double s1 = v.dotProduct(N1);
		double s2 = v.dotProduct(N2);
		double s3 = v.dotProduct(N3);
			//Check if the sign is equal
		if (Math.signum(s2)==Math.signum(s3)&&Math.signum(s1)==Math.signum(s3)&& Math.signum(s2)!=0)
			Intersections.add(p_tmp);
		
	
		return Intersections;	
	}
}
