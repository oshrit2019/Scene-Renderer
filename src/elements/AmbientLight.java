package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;
// class Ambient Light  that extends Light
public class AmbientLight extends Light{

	protected double _ka;
	/*---------constructors---------*/
	public AmbientLight() {
		super();
		this._ka = 0.1;
	}
	public AmbientLight(Color c,double _ka) {
		super(c);
		this._ka = _ka;
	}

	public AmbientLight(AmbientLight ambient) {
		super(ambient._color);
		this._ka = ambient._ka;
	}
	/*---------getter/setter---------*/
	public double get_ka() {
		return _ka;
	}

	public void set_ka(double _ka) {
		this._ka = _ka;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)//when the objects is equal
			return true;
		if (obj == null)//when the object is null
			return false;
		if (getClass() != obj.getClass())//the class is not equal
			return false;
		AmbientLight other = (AmbientLight) obj;//casting to ambient light
		if (Double.doubleToLongBits(_ka) != Double.doubleToLongBits(other._ka))//check ka
			return false;
		return true;
	}

	@Override
	public String toString()
	//insert data to string
	{
		return "AmbientLight [_ka=" + _ka + "]";
	}
	 public Vector getL(Point3D point)
	   //Returns the vector from the Ambient source to the cut point
	   {
		Vector v=new Vector(new Point3D(0,0,0)); 
		
		return 	v.normalize();
		}

	public Color getIntensity(Point3D point)
	//get Intensity of ambient light
	{
		Color _color=new Color(this.get_color().getRGB());
		int red= (int)(_color.getRed()*this._ka);
		int green =(int)(_color.getGreen()*this._ka);
		int blue =(int)(_color.getBlue()*this._ka);
		return new Color (red,green,blue);
	}
	
}
