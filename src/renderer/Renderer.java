package renderer;
import scene.*;
import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import primitives.*;
import geometries.*;
import elements.*;
//this part is class of renderer
public class Renderer 
{
	protected Scene  _scene;
	protected ImageWriter _imageWriter;
	private static int RECURSION_LEVEL = 4;


	// ***************** Constructors ********************** //
	public Renderer(Scene _scene, ImageWriter _imageWriter) 
	{
		super();
		this._scene = _scene;
		this._imageWriter = _imageWriter;
	}

	public Renderer() {
		super();
		this._scene = new Scene ();
		this._imageWriter = new ImageWriter("defualt",500,500,500,500);
	}
	public Renderer(Renderer render) {
		super();
		this._scene = render._scene;
		this._imageWriter = render._imageWriter;
	}
	// ***************** Getters/Setters ********************** // 
	public Scene get_scene() {
		return new Scene (_scene);
	}

	public void set_scene(Scene _scene) {
		this._scene = _scene;
	}

	public ImageWriter get_imageWriter() {
		return _imageWriter;
	}

	public void set_imageWriter(ImageWriter _imageWriter) {
		this._imageWriter = _imageWriter;
	}

	@Override
	public boolean equals(Object obj)
	//Check if the objects is equal
	{
		if (this == obj)//when the objects is equal
			return true;
		if (obj == null)//when the object is null
			return false;
		if (getClass() != obj.getClass())//the class is not equal
			return false;
		Renderer other = (Renderer) obj;
		if (_imageWriter == null) {
			if (other._imageWriter != null)
				return false;
		} else if (!_imageWriter.equals(other._imageWriter))
			return false;
		if (_scene == null) {
			if (other._scene != null)
				return false;
		} else if (!_scene.equals(other._scene))
			return false;
		return true;
	}

	@Override
	public String toString()
	//insert the data to string
	{
		return "Renderer [_scene=" + _scene + ", _imageWriter=" + _imageWriter + "]";
	}

	public void printGrid(int interval,int x,int y) 
	//print on the image grid
	{
		for(int i=0; i<x; i++)//Pass all the X
			for(int j=0; j<y; j++)//Pass all the Y
			{
				if(i%interval==0|| j%interval==0||i==x-1||j==y-1)//when i or j is divide with interval or in the end view plane
					this._imageWriter.writePixel(i,j,255,255,255);
			}

	}

	private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray) 
	//get Scene Ray Intersections
	{

		Iterator<Geometry> geometries = _scene.getGeometriesIterator();
		Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry,List<Point3D>>();

		while (geometries.hasNext())//when geometries not empty
		{
			Geometry geometry = geometries.next();
			List<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);	
			if(geometryIntersectionPoints.size()!=0)
				intersectionPoints.put(geometry, geometryIntersectionPoints);

		}
		//	if(intersectionPoints.isEmpty())
		//		return null;
		return intersectionPoints;
	}

	private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints)
	//get Closest Point
	{

		double distance = Double.MAX_VALUE;
		Point3D P0 = _scene.get_camera().get_P0();
		Map<Geometry, Point3D> minDistancePoint = new HashMap <Geometry, Point3D>();

		for (Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet())//when the list of intersection Points not empty
		{
			for(Point3D point: entry.getValue())
				if (P0.distance(point) < distance)//When the distance of this point is smaller than the distance of the previous point
				{				
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance = P0.distance(point);
				}
		}
		return minDistancePoint;
	}

	public void renderImage() throws Exception
	//render Image
	{
		//For each point (i,j) in the view plane
		for(int i=0;i<this._imageWriter.getNy();i++)
		{
			for(int j=0;j<this._imageWriter.getNx();j++)
			{
				if (i==350 && j==325)
					System.out.print("hi");
				List<Ray> listRay = _scene.get_camera().constructRayThroughPixel(_imageWriter.getNx(),
						_imageWriter.getNy(), j,i,_scene.get_screenDistance(), _imageWriter.getWidth(), 
						_imageWriter.getHeight());
				int red=0;
				int green=0;
				int blue=0;
				for (int k=0; k<5; k++)
				{
					Map<Geometry, List<Point3D>> intersectionPoints =getSceneRayIntersections(listRay.get(k));
					if(intersectionPoints.isEmpty())//if isEmpty(intersectionPoints)
					{

						//_imageWriter.writePixel(j, i, _scene.get_background());
						Color color=_scene.get_background();
						red+= color.getRed();
						green+= color.getGreen();
						blue+= color.getBlue();
						
					}
					else
					{
						Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
						for(Entry<Geometry, Point3D> entry: closestPoint.entrySet())
						{

							//_imageWriter.writePixel(j, i, calcColor(entry.getKey(),entry.getValue(),listRay.get(k)));
							Color c= calcColor(entry.getKey(),entry.getValue(),listRay.get(k));
							red+= c.getRed();
							green+= c.getGreen();
							blue+= c.getBlue();
						}

					}
				}
				red= red/5;
				green=green/5;
				blue= blue/5;
				
				_imageWriter.writePixel(j, i, addColor(new Color(0,0,0), new Color(red,green,blue)));
			}
		}

	}
	
	

	
	private Color calcColor(Geometry geometry,Point3D closestPoint,Ray inRay) throws Exception
	{
		return calcColor( geometry, closestPoint, inRay ,0);
	}
	private Color calcColor(Geometry geometry,Point3D p, Ray inRay,int level) throws Exception
	//calculate color
	{
		if (level == RECURSION_LEVEL) 
			return new Color(0, 0, 0);

		Color ambientLight = _scene.get_ambientLight().getIntensity(p);
		Color emissionLight= geometry.getEmission();
		Iterator<Light> lights =_scene.getLightsIterator();
		Color diffuseLight=new Color(0,0,0);
		Color specularLight=new Color(0,0,0);
		while (lights.hasNext())//go over all the kind of lights
		{
			Light light=lights.next();
			if (!occluded(light, p, geometry))
				//When there is no shadow
			{
				//Calculate diffuse light
				Color diffuse=calcDiffusiveComp(geometry.get_material().get_Kd(),
						geometry.getNormal(p),
						light.getL(p) ,
						light.getIntensity(p));

				diffuseLight=addColor(diffuseLight,diffuse);
				Point3D p0=_scene.get_camera().get_P0();
				//Calculate specular light
				Color specular=calcSpecularComp(geometry.get_material().get_Ks(),
						new Vector(p0.substrct(new Vector(p))),
						geometry.getNormal(p),
						light.getL(p),
						geometry.get_material().get_n(), 
						light.getIntensity(p));
				specularLight=addColor(specularLight,specular);
			}
		}
		// Recursive call for a reflected ray
		double kr = geometry.get_material().get_Kr();
		Color reflectedLight= new Color(0,0,0);
		if (kr != 0)
		{
			Color reflectedColor = new Color(0,0,0);
			Ray reflectedRay = constructReflectedRay(geometry.getNormal(p), p, inRay);
			Map<Geometry,Point3D> reflectedEntry = findClosestIntersection(reflectedRay, geometry);
			for (Entry<Geometry, Point3D> entry: reflectedEntry.entrySet())
			{
				reflectedColor = calcColor(entry.getKey(), entry.getValue(), reflectedRay,level+1);
				reflectedLight =ColorScale(reflectedColor,kr);
			}
		}

		// Recursive call for a refracted ray
		double kt = geometry.get_material().get_Kt();
		Color refractedLight = new Color(0,0,0);
		if (kt != 0)
		{
			Color refractedColor = new Color(0,0,0);
			Ray refractedRay = constructRefractedRay(geometry.getNormal(p), p, inRay);
			Map<Geometry,Point3D> refractedEntry = findClosestIntersection(refractedRay, geometry);
			for (Entry<Geometry, Point3D> entry1: refractedEntry.entrySet())
			{
				refractedColor = calcColor(entry1.getKey(),entry1.getValue(), refractedRay ,level+1);		
				refractedLight = ColorScale(refractedColor,kt);
			}
		}
		return addColor(addColor(addColor(diffuseLight,specularLight),addColor(ambientLight,emissionLight)),addColor(reflectedLight,refractedLight));

	}

	private Map<Geometry,Point3D> findClosestIntersection(Ray reflectedRay, Geometry geometry) 
	//find point intersection and closes point with the ray reflected or refracted and geometry 
	{
		Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(reflectedRay);
		if (geometry instanceof FlatGeometry)// if the ray intersection with àhe flat geometry that sent a ray
			intersectionPoints.remove(geometry);
		Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
		return closestPoint;
	}

	private Ray constructReflectedRay(Vector N, Point3D p, Ray r)
	// calculation the ray reflected 
	{
		Vector D= r.get_direction().normalize();
		Vector v= N.scale(-2*D.dotProduct(N));
		Vector vDN = D.add(v).normalize();
		Vector v1= N.scale(2);
		Point3D p1= new Point3D(p.add(v1));
		return new Ray(p1, vDN);
	}

	private Ray constructRefractedRay(Vector N, Point3D p, Ray r)
	// calculation the ray refracted 
	{	
		Vector N1 = N.scale(-2.0);
		p = p.add(N1);
		return new Ray(p,r.get_direction());
	}

	private Color calcDiffusiveComp(double kd,Vector normal,Vector L,Color Iam)
	//calculate Diffusive 
	{
		Vector normal1=normal.normalize();
		Vector l=L.normalize();
		double KNL= Math.abs(kd*normal1.dotProduct(l));
		return ColorScale(Iam,KNL);
	}

	private Color calcSpecularComp(double ks,Vector V,Vector normal,Vector L,double shine,Color Il)
	//calculate Specular 
	{
		Vector V1=V.normalize();
		Vector normal1=normal.normalize();
		Vector L1= L.normalize();
		double dot = (L1.dotProduct(normal1))*2;
		//	if(dot>0)dot=0;
		Vector R = L1.substrct(normal1.scale(dot)).normalize();
		double temp = ks * Math.pow(V1.normalize().dotProduct(R), shine);
		double scelar = Math.abs(temp);
		return ColorScale(Il,scelar);
	}


	private boolean occluded(Light light, Point3D point, Geometry geometry) 
	//Shadow check
	{
		Vector lightDirection = light.getL(point);
		Vector lightDirection1= lightDirection.scale(-1);

		Point3D geometryPoint = new Point3D(point);
		Vector epsVector = new Vector(geometry.getNormal(point));
		Vector epsVector1= epsVector.scale(0.1);

		Point3D geometryPoint1= geometryPoint.add(epsVector1);
		Ray lightRay = new Ray(geometryPoint1, lightDirection1);
		Map<Geometry, List<Point3D>> intersectionPoints =getSceneRayIntersections(lightRay);//Finding intersection points with the ray of lighting
		if(intersectionPoints.size()!=0){
			// Flat geometry cannot self intersect
			if (geometry instanceof FlatGeometry)
				//remove point with flat geometry
			{
				intersectionPoints.remove(geometry);
			}
			for (Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet())
				if (entry.getKey().get_material().get_Kt() == 0 && entry.getKey().get_material().get_Kr()==0)
					return true;
		}
		return false;
	}

	Color ColorScale( Color c,double d)
	// multiplication the color in scaler
	{
		int red=(int)(c.getRed()*d);
		int green=(int)(c.getGreen()*d);
		int blue=(int)(c.getBlue()*d);
		if (red<0)		red=0;
		if (green<0)	green=0;
		if (blue<0)		blue=0;
		if(red>255)red=255;
		if(green>255)green=255;
		if(blue>255)blue=255;
		return new Color(red,green,blue);
	}
	private Color addColor(Color c1,Color c2)
	//add Color
	{
		int red=c1.getRed()+c2.getRed();
		int green=c1.getGreen()+c2.getGreen();
		int blue=c1.getBlue()+c2.getBlue();
		if (red<0)		red=0;
		if (green<0)	green=0;
		if (blue<0)		blue=0;
		if(red>255)red=255;
		if(green>255)green=255;
		if(blue>255)blue=255;
		return new Color(red,green,blue);
	}

}
