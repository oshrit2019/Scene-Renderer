package elements;

import primitives.*;
import java.util.ArrayList;
import java.util.List;
//class for camera
public class Camera 
{
	protected Point3D _P0;
	protected Vector _vUp;
	protected Vector _vTo;
	protected Vector _vRight;
	public Camera(Point3D _P0, Vector _vUp, Vector _vTo, Vector _vRight)
//constructor
	{
		this._P0 = _P0;
		this._vUp = _vUp;
		this._vTo = _vTo;
		this._vRight = _vRight;
	}
	public Camera() 
	//default constructor

	{
		Coordinate c=new Coordinate(0);
		this._P0 =new Point3D(c,c,c);
		this._vUp = new Vector(new Point3D(c,new Coordinate(1),c));
		this._vTo = new Vector(new Point3D(c,c,new Coordinate(-1)));
		this._vRight = new Vector(new Point3D(new Coordinate(1),c,c));
	}
	public Camera(Camera ca)
	//copy constructor	

	{
		this._P0 =new Point3D(ca._P0);	
		this._vUp = new Vector(ca._vUp);
		this._vTo = new Vector(ca._vTo);
		this._vRight = new Vector(ca._vRight);
	}
	public Point3D get_P0()
	//get _p0
	{
		return new Point3D(_P0);
	}
	public void set_P0(Point3D _P0) 
	//set_P0
	{
		this._P0 = _P0;
	}
	public Vector get_vUp()	
	//get _vUp
 	{
		return new Vector(_vUp);
	}
	public void set_vUp(Vector _vUp)
	//set _vUp
	{
		this._vUp = _vUp;
	}
	public Vector get_vTo() 
	//get _vTo
{
		return new Vector(_vTo);
	}
	public void set_vTo(Vector _vTo) 
	//get _p0
	{
		this._vTo = _vTo;
	}
	public Vector get_vRight() 
	//get_vRight
	{
		return new Vector(_vRight);
	}
	public void set_vRight(Vector _vRight) 
	//set _vRight
	{
		this._vRight = _vRight;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)//when the objects is equal
			return true;
		if (obj == null)//when the object is null
			return false;
		if (getClass() != obj.getClass())//the class is not equal
			return false;
		Camera other = (Camera) obj;//casting to vector
		if (_P0 == null)//check _P0
		{
			if (other._P0 != null)
				return false;
		} else if (!_P0.equals(other._P0))
			return false;
		if (_vRight == null)//check _vRight
		{
			if (other._vRight != null)
				return false;
		} else if (!_vRight.equals(other._vRight))
			return false;
		if (_vTo == null) //check _vTo
		{
			if (other._vTo != null)
				return false;
		} else if (!_vTo.equals(other._vTo))
			return false;
		if (_vUp == null) //check _vUp
		{
			if (other._vUp != null)
				return false;
		} else if (!_vUp.equals(other._vUp))
			return false;
		return true;
	}
	@Override
	public String toString()
//return string with all the information about camera 
	{
		return "Camera [_P0=" + _P0 + ", _vUp=" + _vUp + ", _vTo=" + _vTo + ", _vRight=" + _vRight + "]";
	}
	public List<Ray> constructRayThroughPixel(int Nx, int Ny, double x, double y, double screenDist, double screenWidth, double screenHeight)
	//constructRayThroughPixel
	{
		List<Ray> list= new ArrayList<Ray>();
		//find the width and height for one pixel
		double Rx= screenWidth/Nx;
		double Ry= screenHeight/Ny;
		
		Vector vto=this.get_vTo().normalize().scale(screenDist);
		//find the vector vTo
		Point3D pc=this.get_P0().add(vto);
		//find the Point3D in the middle of view plane 
		
		//calculate the vector that we search 
		double nx=(double)Nx/2;
		double ny=(double)Ny/2;
		double dright= (x-nx)*Rx+(Rx/2.0);
		double dup= (y-ny)*Ry+(Ry/2.0);
		Vector vright= this.get_vRight().scale(dright);;
		Vector vup=this.get_vUp().scale(dup);
		Point3D pc2=pc.add(vright);
		
		Point3D RU=pc2.substrct(vup);
		Vector vend= new Vector(new Point3D(RU)).normalize();
		Ray r1=new Ray(RU,vend );
		r1.set_direction(r1.get_direction().normalize());
		
		
		Point3D p1= new Point3D(RU.getX().substrct(new Coordinate(Rx/2)),RU.getY().add(new Coordinate(Ry/2)),RU.getZ());
		Vector vp1= new Vector(new Point3D(p1)).normalize();
		Ray r2=new Ray(p1,vp1 );
		r2.set_direction(r2.get_direction().normalize());
		
		Point3D p2= new Point3D(RU.getX().add(new Coordinate(Rx/2)),RU.getY().add(new Coordinate(Ry/2)),RU.getZ());
		Vector vp2= new Vector(new Point3D(p2)).normalize();
		Ray r3=new Ray(p2,vp2 );
		r3.set_direction(r3.get_direction().normalize());
		
		Point3D p3= new Point3D(RU.getX().add(new Coordinate(Rx/2)),RU.getY().substrct(new Coordinate(Ry/2)),RU.getZ());
		Vector vp3= new Vector(new Point3D(p3)).normalize();
		Ray r4=new Ray(p3,vp3 );
		r4.set_direction(r4.get_direction().normalize());
		
		Point3D p4= new Point3D(RU.getX().substrct(new Coordinate(Rx/2)),RU.getY().substrct(new Coordinate(Ry/2)),RU.getZ());
		Vector vp4= new Vector(new Point3D(p4)).normalize();
		Ray r5=new Ray(p4,vp4 );
		r5.set_direction(r5.get_direction().normalize());
		
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);

		return list;
		
	}



}
