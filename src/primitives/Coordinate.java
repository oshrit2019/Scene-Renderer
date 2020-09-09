package primitives;
//class of coordinate
public class Coordinate {
	protected double _coordinate;

	/*-----------constructors------------*/
	public Coordinate(double _coordinate) 
	//Constructor
	{
		this._coordinate = _coordinate;
	}
	public Coordinate()
	//Default c_tor
	{
		this._coordinate = 0;
	}
	public Coordinate(Coordinate c)
	//copy constructor
	{
		this._coordinate = c._coordinate;
	}


	/*----------Getter/Setter---------*/
	public double get_coordinate() 
	//get coordinate 
	{
		double b=_coordinate;
		return b;
	}
	public void set_coordinate(double _coordinate)
	//set coordinate
	{
		this._coordinate = _coordinate;
	}


	@Override
	public boolean equals(Object obj)
	//equals
	{
		if (this == obj)//when the objects is equal
			return true;
		if (obj == null)//when the object is null
			return false;
		if (getClass() != obj.getClass())//the class is not equal
			return false;
		Coordinate other = (Coordinate) obj;
		if (Double.doubleToLongBits(_coordinate) != Double.doubleToLongBits(other._coordinate))//when the coordinate not equal
			return false;
		return true;
	}
	@Override
	public String toString() 
	//insert to string
	{
		return "Coordinate :" + _coordinate;
	}

	public Coordinate add(Coordinate c)
	//add two Coordinate
	{
       
		double d=this._coordinate+c._coordinate;
	//	this._coordinate=d;
	    Coordinate coor=new Coordinate(d);
		return coor;
	}

	public Coordinate substrct (Coordinate c)
	//substrct two Coordinate
	{
		
		double x=this._coordinate-c._coordinate;
		Coordinate c2 =new Coordinate(x);
		return c2;
	}

}
