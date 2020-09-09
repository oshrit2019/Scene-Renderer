package primitives;
//class point3D
public class Point3D  {
	
	protected Coordinate x;
	protected Coordinate y;
	protected Coordinate z;
	
	/*-----------constructors------------*/
	public Point3D(Coordinate x, Coordinate y, Coordinate z)
	//Constructor
	{
		this.x=x;
		this.y=y;
		this.z = z;
	}
	public Point3D() 
	//Default constructor
	{
		this.x = new Coordinate();
		this.y = new Coordinate();		
		this.z = new Coordinate();
	}
	   public Point3D(double x, double y, double z)
	    //constructor
	    {
	    	this.x = new Coordinate(x);
			this.y = new Coordinate(y);
			this.z = new Coordinate(z);
		}
    public Point3D(Point3D  p)
    //copy constructor
    {
    	this.x = new Coordinate(p.x);
		this.y = new Coordinate(p.y);
		this.z = new Coordinate(p.z);
	}

	@Override
	public boolean equals(Object obj)//equals between 2 point3d
	{
		if (this == obj)//when the objects is equal
			return true;
		if (obj == null)//when the object is null
			return false;
		if (getClass() != obj.getClass())//the class is not equal
			return false;
		Point3D other = (Point3D) obj;//casting to point3D
		if (x == null) //when x is null
		{
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) //when y is null
		{
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		if (z == null)//when z is null
		{
			if (other.z != null)
				return false;
		} else if (!z.equals(other.z))
			return false;
		return true;
	}
	
@Override
	public String toString()
//insert to string the data is in the class 
{
		return "Point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
/*----------Getter/Setter---------*/
public Coordinate getX()
//get x
{
		return new Coordinate(x);
	}
	public void setX(Coordinate x)
	//set x
	{
		this.x = x;
	}
	public Coordinate getY()
	//get y
	{
		return new Coordinate(y);
	}
	public void setY(Coordinate y)
	//set y
	{
		this.y = y;
	}
	public Coordinate getZ() 
	//get z
	{
		return new Coordinate(z);
	}
	public void setZ(Coordinate z)
	//set z
	{
		this.z = z;
	}
	public double distance (Point3D p)
	//calculate distance
	{
		double a=this.x.substrct(p.x)._coordinate;
		double b=this.y.substrct(p.y)._coordinate;
		double c=this.z.substrct(p.z)._coordinate;
		double help= Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2)+Math.pow(c, 2));
		return help;
	}
  public Point3D add(Vector vector) 
   //add between point to vector
   {	
	  Point3D p1= vector.get_head();
	  Coordinate cx=p1.getX();
		Coordinate cy=p1.getY();
		Coordinate cz=p1.getZ();
		Point3D p2= new Point3D(this.getX().add(cx), this.getY().add(cy), this.getZ().add(cz));
		return p2;
	}
   public Point3D substrct(Vector vector) 
   //substrct between point to vector
   {	
	   
		Coordinate cx=this.x.substrct(vector.get_head().getX());
		Coordinate cy=this.y.substrct(vector.get_head().getY());
		Coordinate cz=this.z.substrct(vector.get_head().getZ());
        Point3D p= new Point3D(cx,cy,cz);
        return p;
	}
	

}
