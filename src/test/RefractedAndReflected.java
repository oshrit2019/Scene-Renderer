package test;


import java.awt.Color;
import org.junit.Test;
import elements.*;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Renderer;
import scene.Scene;

public class RefractedAndReflected {

	@Test
	public void refractedLight() throws Exception
	//test to reflected light
	{
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		scene.addLight(new AmbientLight(new Color(0, 0, 0), 0));
		Sphere sphere1 = new Sphere(new Color(0, 0, 100),new Material(1,1,20,0,0.5),500, new Point3D(0.0, 0.0,-1000));
		Sphere sphere2 = new Sphere(new Color(100, 0, 0),new Material(1,1,20,0,0),250, new Point3D(0.0, 0.0,-1000));
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200,-200,-150),0.1, 0.00001, 0.000005, 
				new Vector(new Point3D(2, 2, -3))));
		scene.addGeometry(sphere1);
		scene.addGeometry(sphere2);

		ImageWriter imageWriter = new ImageWriter("refracted Light test", 500, 500, 500, 500);

		Renderer render = new Renderer(scene, imageWriter);

		render.renderImage();
	//	render.printGrid(50,500, 500);

		imageWriter.writeToimage();
	}
	
	
	/*
	@Test
	public void refractedLight2() throws Exception
	//test to spot light 
	{
		Scene scene = new Scene();
		scene.set_screenDistance(100);
		scene.addLight(new AmbientLight(new Color(0, 0, 0), 0));
				Triangle triangle1 = new Triangle(new Color(0,0,0), new Material(),new Point3D(  3500,  -3500, -2000),
						new Point3D( -3500, 3500, -1000),
						new Point3D(  -3500, -3500, -2000));
				scene.addGeometry(triangle1);
				
				Triangle triangle2 = new Triangle(new Color(0,0,0), new Material(),new Point3D(  3500,  -3500, -2000),
						new Point3D( -3500, 3500, -1000),
						new Point3D(  -3500, -3500, -2000));
				scene.addGeometry(triangle1);
				
				
				ImageWriter imageWriter = new ImageWriter("refracted Light test2", 500, 500, 500, 500);

				Renderer render = new Renderer(scene, imageWriter);

				render.renderImage();

				imageWriter.writeToimage();
				

	}*/
	
/*	@Test
	public void PointTestRflected() throws Exception
	//test to point light 
	{

		Scene scene = new Scene();
		//------------add Grometries to scene--------------//
		Sphere sphere = new Sphere(new Color(0, 0, 100), new Material(),100, new Point3D(0.0, 0.0, -200));
		Material m=new Material();
		m.set_n(20);
		sphere.set_material(m);

		Triangle triangle = new Triangle(new Color(0,0,0), new Material(1,1,0,1,0),new Point3D(  3500,  3500, -2000),
				new Point3D( -3500, -3500, -1000),
				new Point3D(  -3500, 3500, -2000));

		Triangle triangle2 = new Triangle(new Color(0,0,0), new Material(1,1,0,1,0),new Point3D(  3500,  3500, -2000),
				new Point3D( 3500,  -3500, -1000),
				new Point3D( -350, -3500, -1000));



		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(sphere);
		
        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(0, 200, -100), 
				0, 0.000001, 0.0000005));


		ImageWriter imageWriter = new ImageWriter("Point test Reflected", 500, 500, 500, 500);

		Renderer render = new Renderer(scene,imageWriter);

		render.renderImage();
	//	render.printGrid(50,500, 500);
		imageWriter.writeToimage();

	}
	*/
	
	
/*	@Test
	public void pointLightTestreflacted() throws Exception
	//test to point light 
	{

		Scene scene = new Scene();
		//------------add Grometries to scene--------------//
		Sphere sphere = new Sphere(new Color(0, 0, 100), new Material(),100, new Point3D(0.0, 0.0, -200));
		Material m=new Material();
		m.set_n(20);
		sphere.set_material(m);

		Triangle triangle = new Triangle(new Color(0,0,0), new Material(1,1,0,1,0),new Point3D(  3500,  3500, -2000),
				new Point3D( -3500, -3500, -1000),
				new Point3D(  -3500, 3500, -2000));

		Triangle triangle2 = new Triangle(new Color(0,0,0), new Material(1,1,0,1,0),new Point3D(  3500,  3500, -2000),
				new Point3D( 3500,  -3500, -1000),
				new Point3D( -3500, -3500, -1000));



		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				0, 0.000001, 0.0000005));


		ImageWriter imageWriter = new ImageWriter("Point test reflacted", 500, 500, 500, 500);

		Renderer render = new Renderer(scene,imageWriter);
		render.renderImage();
		imageWriter.writeToimage();

	}
	*/


	
		@Test
		public void recursiveTest()throws Exception{
			
			Scene scene = new Scene();
			scene.set_screenDistance(300);
			
			Sphere sphere = new Sphere(new Color(0,0,100),new Material(1,1,20,0,0.5),500, new Point3D(0.0, 0.0, -1000));
		//	sphere.get_material().set_n(20);
			//sphere.setEmmission(new Color(0, 0, 100));
			//sphere.get_material().set_Kt(0.5);
			scene.addGeometry(sphere);
			
			Sphere sphere2 = new Sphere(new Color(100, 20, 20),new Material(1,1,20,0,0), 250, new Point3D(0.0, 0.0, -1000));
			//sphere2.get_material().set_n(20);
			//sphere2.setEmmission(new Color(100, 20, 20));
		//	sphere2.get_material().set_Kt(0);
			
			scene.addGeometry(sphere2);
			
			scene.addLight(new SpotLight(new Color(255, 100, 100) ,new Point3D(-200, -200, -150), 
					    0.1, 0.00001, 0.000005,new Vector(new Point3D(2, 2, -3))));
		
			ImageWriter imageWriter = new ImageWriter("Recursive Test", 500, 500, 500, 500);
			
			Renderer render = new Renderer(scene,imageWriter);
			
			render.renderImage();
			render.get_imageWriter().writeToimage();			
		}
		
	
		@Test
		public void recursiveTest2() throws Exception{
			
			Scene scene = new Scene();
			scene.set_screenDistance(300);
			
			Sphere sphere = new Sphere(new Color(0, 0, 100),new Material(1,1,20,0,0.5),300, new Point3D(-550, -500, -1000));
			
			scene.addGeometry(sphere);
			
			Sphere sphere2 = new Sphere(new Color(100, 20, 20),new Material(1,1,20,0,0),150, new Point3D(-550, -500, -1000));
			
			scene.addGeometry(sphere2);
			
			Triangle triangle = new Triangle(new Color(20, 20, 20),new Material(1,1,20,1,0),new Point3D(  1500, -1500, -1500),
					 						 new Point3D( -1500,  1500, -1500),
					 						 new Point3D(  200,  200, -375));
			
			Triangle triangle2 = new Triangle(new Color(20, 20, 20),new Material(1,1,20,0.5,0),new Point3D(  1500, -1500, -1500),
											  new Point3D( -1500,  1500, -1500),
											  new Point3D( -1500, -1500, -1500));
		
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);

			scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
				   0, 0.00001, 0.000005, new Vector(new Point3D(-2, -2, -3))));
		
			ImageWriter imageWriter = new ImageWriter("Recursive Test 2", 500, 500, 500, 500);
			
			Renderer render = new Renderer(scene,imageWriter);
			
			render.renderImage();
		//	render.printGrid(50,500, 500);
			render.get_imageWriter().writeToimage();
			
		}
		
		/*@Test
		public void recursiveTest3()throws Exception{
			
			Scene scene = new Scene();
			scene.set_screenDistance(300);
			
			Sphere sphere = new Sphere(new Color(0, 0, 100),new Material(1,1,20,0,0.5),300, new Point3D(0, 0, -1000));
			
			scene.addGeometry(sphere);
			
			Sphere sphere2 = new Sphere(new Color(100, 20, 20),new Material(1,1,20,0,0),150, new Point3D(0, 0, -1000));
			
			scene.addGeometry(sphere2);
			
			Triangle triangle = new Triangle(new Color(20, 20, 20),new Material(1,1,1,1,0),new Point3D(  2000, -1000, -1500),
					 						 new Point3D( -1000,  2000, -1500),
					 						 new Point3D(  700,  700, -375));
			
			Triangle triangle2 = new Triangle(new Color(20, 20, 20),new Material(1,1,1,0.5,0),new Point3D(  2000, -1000, -1500),
											  new Point3D( -1000,  2000, -1500),
											  new Point3D( -1000, -1000, -1500));
			
			
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);

			scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
					    0, 0.00001, 0.000005,new Vector(new Point3D(-2, -2, -3))));
		
			ImageWriter imageWriter = new ImageWriter("Recursive Test 3", 500, 500, 500, 500);
			
			Renderer render = new Renderer(scene,imageWriter);
			
			render.renderImage();
			render.get_imageWriter().writeToimage();
			
		}*/
		

}
