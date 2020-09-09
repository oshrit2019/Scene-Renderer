package geometries;
import java.util.List;
import java.awt.Color;
import primitives.*;
// abstract class for Geometry
public abstract class Geometry {
	protected  Color emission;
protected Material _material;

/*--------constructors------------*/

	public Geometry(Color color, Material material)
	//constructor
	{
		this.emission = color;
		this._material= material;
	}

	public Geometry()
	//Default constructor
	{
		this.emission=new Color(255,255,255);
		this._material=new Material();
	}
	
	public  Geometry(Geometry g)
	//copy constructor
	{
		this.emission=g.emission;
		this._material=g._material;
	}
	
	
	/*------getter/setter------*/
	public Color getEmission()
	//get Color
	{
		Color c=emission;
		return c;
	}
	public void setEmission(Color color)
	//set Color
	{
		this.emission = color;
	}
	
	public Material get_material() {
		return new Material(_material);
	}

	public void set_material(Material _material) {
		this._material = _material;
	}

	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)//when the objects is equal
			return true;
		if (obj == null)//when the objects is equal
			return false;
		if (getClass() != obj.getClass())//the class is not equal
			return false;
		Geometry other = (Geometry) obj;//casting to Geometry
		if (_material == null) {
			if (other._material != null)
				return false;
		} else if (!_material.equals(other._material))
			return false;
		if (emission == null) {
			if (other.emission != null)//Check color
				return false;
		} else if (!emission.equals(other.emission))//when the color not equal
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Geometry [emission=" + emission + ", _material=" + _material + "]";
	}

	public abstract Vector getNormal(Point3D p);//Abstract function to find normal
	public abstract List<Point3D> findIntersections(Ray r);//Abstract function to find Intersections

}
