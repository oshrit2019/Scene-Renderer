package elements;
import java.awt.Color;
import primitives.Point3D;
import primitives.Vector;
//class point Light extends Light
public class PointLight extends Light {

	protected Point3D _position;
	protected double _kc;
	protected double _kl;
	protected double _kq  ;




	/*---------constructors---------*/
	public PointLight() {
		super();
		this._position = new Point3D();
		this._kc = 0;
		this._kl = 0;
		this._kq = 0;
	}
	public PointLight(PointLight pointLight) {
		super(pointLight._color);
		this._position = new Point3D(pointLight._position);

		this._kc = pointLight._kc;
		this._kl = pointLight._kl;
		this._kq = pointLight._kq;
	}public PointLight(Color c,Point3D _position, double _kc, double _kl, double _kq) {
		super(c);
		this._position = _position;
		this._kc = _kc;
		this._kl = _kl;
		this._kq = _kq;
	}
	/*---------getter/setter---------*/
	public Point3D get_position() {
		return new Point3D(_position);
	}


	public void set_position(Point3D _position) {
		this._position = _position;
	}


	public double get_kc() {
		return _kc;
	}


	public void set_kc(double _kc) {
		this._kc = _kc;
	}


	public double get_kl() {
		return _kl;
	}


	public void set_kl(double _kl) {
		this._kl = _kl;
	}


	public double get_kq() {
		return _kq;
	}


	public void set_kq(double _kq) {
		this._kq = _kq;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)//when the objects is equal
			return true;
		if (obj == null)//when the object is null
			return false;
		if (getClass() != obj.getClass())//the class is not equal
			return false;
		PointLight other = (PointLight) obj;//casting to Point Light
		if (Double.doubleToLongBits(_kc) != Double.doubleToLongBits(other._kc))//check kc
			return false;
		if (Double.doubleToLongBits(_kl) != Double.doubleToLongBits(other._kl))//check kl
			return false;
		if (Double.doubleToLongBits(_kq) != Double.doubleToLongBits(other._kq))//check kq
			return false;
		if (_position == null)//check position
		{
			if (other._position != null)
				return false;
		} else if (!_position.equals(other._position))
			return false;
		return true;
	}


	@Override
	public String toString() 
	//insert data to string
	{
		return "PointLight [_position=" + _position + ", _kc=" + _kc + ", _kl=" + _kl + ", _kq=" + _kq + "]";
	}



	public Color getIntensity(Point3D point) throws Exception
	//get Intensity of point light

	{
		double dis=point.distance(_position);
		double kd=_kc+_kl*dis+_kq*dis*dis;
		if(kd==0)  throw new Exception();
		if(kd<1)
			kd=1;
		Color color = new Color(super.get_color().getRGB());
		int red=(int)(color.getRed()/kd);
		int green=(int)(color.getGreen()/kd);
		int blue=(int)(color.getBlue()/kd);
		if(red<0) red=0;
		if(green<0) green=0;
		if(blue<0) blue=0;
		if(red>255) red=255;
		if(green>255) green=255;
		if(blue>255) blue=255;
		return new Color (red,green,blue);
	}
	
	public Vector getL(Point3D point)
	//Returns the vector from the Point source to the cut point
	{
		return new Vector (point.substrct(new Vector(_position))).normalize();
	}

}
