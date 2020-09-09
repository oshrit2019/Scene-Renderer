package elements;

import java.awt.Color;

import primitives.*;
//class Directional Light extends Light
public class DirectionalLight extends Light {


	protected Vector _direction;
	/*---------constructors---------*/
	public DirectionalLight() {
		super();
		this._direction = new Vector();
	}
	public DirectionalLight(Color c,Vector _direction) {
		super(c);
		this._direction = _direction;
	}
	public DirectionalLight(DirectionalLight directionLight) {
		super(directionLight._color);
		this._direction = new Vector(directionLight._direction);
	}
	/*---------getter/setter---------*/
	public Vector get_direction() {
		return new Vector(_direction);
	}
	public void set_direction(Vector _direction) {
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
		DirectionalLight other = (DirectionalLight) obj;//casting to Directional Light
		if (_direction == null) //check direction
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
		return "DirectionalLight [_direction=" + _direction + "]";
	}
	public Vector getL(Point3D point)
	//Returns the vector from the light source to the cut point
	{
		return new Vector(point.substrct(_direction)).normalize(); 
	}

	public Color getIntensity(Point3D point)
	//get Intensity of Directional light
	{
		return this.get_color();
	}

}
