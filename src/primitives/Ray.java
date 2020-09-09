package primitives;
//class Ray
public class Ray {
	protected  Point3D _POO;
	protected Vector  _direction;
	
	
	/*-----------constructors------------*/
	public Ray(Point3D _POO, Vector _direction) 
	//constructor
	{
		this._POO = _POO;
		this._direction = _direction;
	}
	public Ray() 
	//Default constructor
	{
		this._POO = new Point3D();
		this._direction = new Vector();
	}
	public Ray(Ray r)
	//copy constructor
	{
		this._POO =new Point3D(r._POO);
		this._direction = new Vector(r._direction);
	}
	/*----------Getter/Setter---------*/
	public Point3D get_POO() 
	//get _poo
	{
		return new Point3D(_POO);
	}
	public void set_POO(Point3D _POO) 
	//set _poo
	{
		this._POO = _POO;
	}
	public Vector get_direction() 
	//get direction
	{
		return new Vector(_direction);
	}
	public void set_direction(Vector _direction) 
	//set direction
	{
		this._direction = _direction;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)//when the objects is equal
			return true;
		if (obj == null)//when the object is null
			return false;
		if (getClass() != obj.getClass())//the class is not equal
			return false;
		Ray other = (Ray) obj;//casting to ray
		if (_POO == null) {
			if (other._POO != null)//check point
				return false;
		} else if (!_POO.equals(other._POO))
			return false;
		if (_direction == null)// check the direction vector
		{
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}
	@Override
	public String toString() 
	//insert data to string
	{
		return "Ray [_POO=" + _POO + ", _direction=" + _direction + "]";
	}
	
	
}
