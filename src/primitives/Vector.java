package primitives;
//class vector
public class Vector 
{
	protected Point3D _head;

	/*-----------constructors------------*/
	public Vector(Point3D _head)
	//constructor
	{
		this._head = _head;
	}
	public Vector() 
	//Default constructor
	{
		this._head = new Point3D();
	}
	public Vector(Vector v)
	//copy constructor
	{
		this._head = new Point3D(v._head);
	}
	/*----------Getter/Setter---------*/
	public Point3D get_head()
	//get head
	{
	    return new Point3D(_head);
	}

	public void set_head(Point3D _head)
	//set head
	{
		this._head = _head;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)//when the objects is equal
			return true;
		if (obj == null)//when the object is null
			return false;
		if (getClass() != obj.getClass())//the class is not equal
			return false;
		Vector other = (Vector) obj;//casting to vector
		if (_head == null) {
			if (other._head != null)//check head
				return false;
		} else if (!_head.equals(other._head))//when the head not equal
			return false;
		return true;
	}

	@Override
	public String toString() 
	//insert data to string
	{
		return "Vector (" + _head+" )" ;
	}

	public Vector add(Vector vector) 
	//add between 2 vectors
	{
		return new Vector(this._head.add(vector));
	}
	public Vector substrct(Vector vector) 
	//substrct between 2 vectors
	{
		return new Vector(this._head.substrct(vector));
	}
	public Vector scale(double scalingFacor)
	//Multiplication in scale
	{
		Coordinate cx= new Coordinate(this._head.x._coordinate*scalingFacor);
		Coordinate cy=new Coordinate(this._head.y._coordinate*scalingFacor);
		Coordinate cz=new Coordinate(this._head.z._coordinate*scalingFacor);
		Vector v= new Vector(new Point3D(cx,cy,cz));
		return v;
	}
	public double length()
	//Calculate length of vector
	{
		return this._head.distance(new Point3D());
	}
	public Vector normalize()
	//to normalize the vector
	{
		if(this.length()!=0){
		return new Vector(this.scale(1/this.length()));
		}
		return new Vector(this);
	}

	public Vector crossProduct (Vector vector)
	//doing cross Product between 2 vectors
	{
		Vector v=new Vector();
		v._head.x._coordinate=(this._head.y._coordinate*vector._head.z._coordinate)-(this._head.z._coordinate*vector._head.y._coordinate);
		v._head.y._coordinate=(this._head.z._coordinate*vector._head.x._coordinate)-(this._head.x._coordinate*vector._head.z._coordinate);
		v._head.z._coordinate=(this._head.x._coordinate*vector._head.y._coordinate)-(this._head.y._coordinate*vector._head.x._coordinate);
		return v;
	}
	public double dotProduct(Vector vector)
	//doing dot Product between 2 vectors
	{
		return this._head.x._coordinate*vector._head.x._coordinate+
				this._head.y._coordinate*vector._head.y._coordinate+
				this._head.z._coordinate*vector._head.z._coordinate;
	}
}
