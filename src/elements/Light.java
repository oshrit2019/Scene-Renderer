package elements;

import java.awt.Color;

import primitives.*;
//abstract class Light
public abstract class Light 
{
	protected Color _color;
	/*--------constructors------------*/
	public Light() 
	{
		super();
		this._color = new Color(255,255,255);
	}
	
	public Light(Color _color) {
		super();
		this._color = _color;
	}
	public Light(Light light) {
		super();
		this._color =light._color;
	}
	/*------getter/setter------*/
	public Color get_color() {
		return new Color(_color.getRGB());
	}
	public void set_color(Color _color) {
		this._color = _color;
	}
	
	@Override
	public boolean equals(Object obj)
	//check if 2 lights is equal
	{
		if (this == obj)//when the objects is equal
			return true;
		if (obj == null)//when the object is null
			return false;
		if (getClass() != obj.getClass())//the class is not equal
			return false;
		Light other = (Light) obj;//casting to Light
		if (_color == null) //check color
		{
			if (other._color != null)
				return false;
		} else if (!_color.equals(other._color))
			return false;
		return true;
	}
@Override
public String toString() 
//insert data on the light to string
{
	return "Light [_color=" + _color + "]";
}
public abstract Vector getL(Point3D point);//abstract function
public abstract Color getIntensity(Point3D point) throws Exception;//abstract function


  
}
