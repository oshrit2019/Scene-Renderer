package scene;
import java.awt.Color;
import java.util.List;
import geometries.*;
import java.util.ArrayList;
import java.util.Iterator;

import elements.*;
//class to defined the scene
public class Scene {
	protected String _sceneName;
	protected Color _background;
	protected List<Geometry> _geometries ;
    protected Camera _camera;
    protected double _screenDistance;
    protected AmbientLight  _ambientLight;
    protected List<Light>  _lights;
    
	// ***************** Constructors ********************** //
	public Scene(String _sceneName, Color _background, List<Geometry> _geometries, Camera _camera,
			double _screenDistance,AmbientLight  ambientLight,List<Light>  lights)
	//constructor
	{
		this._sceneName = _sceneName;
		this._background = _background;
		this._geometries = _geometries;
		this._camera = new Camera(_camera);
		this._screenDistance = _screenDistance;
		this._ambientLight=ambientLight;
		this._lights=lights;
	}

	public Scene() 
	//Default constructor
	{
		this._sceneName = "defualt";
		this._background = Color.black;
		this._geometries = new ArrayList<Geometry>();
		this._camera = new Camera();
		this._screenDistance = 100;
		this._ambientLight=new AmbientLight();
		this._lights=new ArrayList<Light>();
	}
	public Scene(Scene s) 
	//copy constructor
	{
		this._sceneName = s._sceneName;
		this._background = s._background;
		this._geometries = new ArrayList<Geometry>(s._geometries);
		this._camera = new Camera(s._camera);
		this._screenDistance = s._screenDistance;
		this._ambientLight=new AmbientLight(s._ambientLight);
		this._lights=new ArrayList<Light>(s._lights);
	}
	// ***************** Getters/Setters ********************** // 
	public String get_sceneName() 
	//get sceneName
	{
		String name=_sceneName;
		return name;
	}

	public void set_sceneName(String _sceneName) 
	//set sceneName
	{
		this._sceneName = _sceneName;
	}

	public Color get_background()
	 //get background
	{
		Color c=_background;
		return c;
	}

	public void set_background(Color _background) 
	//set background
	{
		this._background = _background;
	}

	public List<Geometry> get_geometries() 
	//get geometries
	{
		return new ArrayList<Geometry>(_geometries);
	}

	public void set_geometries(List<Geometry> _geometries) 
	//set geometries
	{
		this._geometries = _geometries;
	}

	public Camera get_camera()
//	get camera
	{
		
		return new Camera(_camera);
	}

	public void set_camera(Camera _camera)
	//set camera
	{
		this._camera = _camera;
	}

	public double get_screenDistance() 
	//get screenDistance
	{
		double d=_screenDistance;
		return d;
	}

	public void set_screenDistance(double _screenDistance) 
	//set screenDistance
	{
		this._screenDistance = _screenDistance;
	}

	public AmbientLight get_ambientLight() {
		return new  AmbientLight(_ambientLight);
	}

	public void set_ambientLight(AmbientLight _ambientLight) {
		this._ambientLight = _ambientLight;
	}

	public List<Light> get_lights() {
		return new ArrayList<Light>(_lights);
	}

	public void set_lights(List<Light> _lights) {
		this._lights = _lights;
	}


	@Override
	public boolean equals(Object obj) 
	//equals between 2 scene
	{
		if (this == obj)//when the objects is equal
			return true;
		if (obj == null)//when the object is null
			return false;
		if (getClass() != obj.getClass())//the class is not equal
			return false;
		Scene other = (Scene) obj;//casting to scene
		if (_ambientLight == null) 
		{
			if (other._ambientLight != null)//when ambientLight is null
				return false;
		} else if (!_ambientLight.equals(other._ambientLight))
			return false;
		if (_background == null)//when _background is null
		{
			if (other._background != null)
				return false;
		} else if (!_background.equals(other._background))
			return false;
		if (_camera == null)//when camera is null 
		{
			if (other._camera != null)
				return false;
		} else if (!_camera.equals(other._camera))
			return false;
		if (_geometries == null)//when geometries is null
		{
			if (other._geometries != null)
				return false;
		} else if (!_geometries.equals(other._geometries))
			return false;
		if (_lights == null) {
			if (other._lights != null)
				return false;
		} else if (!_lights.equals(other._lights))
			return false;
		if (_sceneName == null) {
			if (other._sceneName != null)
				return false;
		} else if (!_sceneName.equals(other._sceneName)) //when _sceneName is null
			return false;
		if (Double.doubleToLongBits(_screenDistance) != Double.doubleToLongBits(other._screenDistance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Scene [_sceneName=" + _sceneName + ", _background=" + _background + ", _geometries=" + _geometries
				+ ", _camera=" + _camera + ", _screenDistance=" + _screenDistance + ", _ambientLight=" + _ambientLight
				+ ", _lights=" + _lights + "]";
	}

	public void addGeometry (Geometry g)
	//add geometry to list
	{
	this._geometries.add(g);	
	}
	
	public Iterator<Geometry>getGeometriesIterator()
	// iterator to geometries
	{
		return _geometries.iterator();

	}
	public void addLight(Light l)
	//add Light
	{
		this._lights.add(l);
	}

	public Iterator<Light>getLightsIterator ()
	// iterator to Lights
	{
		return this._lights.iterator();

	}
}