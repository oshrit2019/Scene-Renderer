package elements;

import java.awt.Color;


import primitives.*;
//class spot Light extends Light
public class SpotLight extends PointLight {
	protected Vector _direction;  

	/*---------constructors---------*/
	public SpotLight() {
		super();
		this._direction = new Vector();
	}
	public SpotLight(Color c, Point3D _position, double _kc, double _kl, double _kq,Vector _direction) {
		super(c,_position,_kc,_kl,_kq);
		this._direction = _direction;
	}
	public SpotLight(SpotLight spot) {
		super(spot._color,spot._position,spot._kc,spot._kl,spot._kq);
		this._direction = new Vector(spot._direction);
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
		if (!super.equals(obj))//when the objects is not equal
			return false;
		if (getClass() != obj.getClass())//the class is not equal
			return false;
		SpotLight other = (SpotLight) obj;//casting to spot Light
		if (_direction == null)//check direction 
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
		return "SpotLight [_direction=" + _direction + "]";
	}
	@Override
	public Vector getL(Point3D point)
	//Returns the vector from the light source to the cut point
	{
		return new Vector(point.substrct(new Vector(_position))).normalize(); 
	}

	public Color getIntensity(Point3D point) throws Exception
	//get Intensity of spot light

	{
		double dis= _position.distance(point);
		Vector D= this._direction.normalize();
		Vector L= new Vector(this.getL(point)).normalize();

		double DL= Math.abs(D.dotProduct(L));
		double kd= (this._kc+this._kl*dis+this._kq*dis*dis);
		if(kd<1) kd=1;
		if(kd==0)throw new Exception();
		double temp=DL/kd;
		double red= (this.get_color().getRed())*temp;
		double green= (this.get_color().getGreen())*temp;
		double blue= (this.get_color().getBlue())*temp;
		if(red>255) red=255;
		if(green>255) green=255;
		if(blue>255) blue=255;
		return new Color ((int)red,(int)green,(int)blue);
	}
}
