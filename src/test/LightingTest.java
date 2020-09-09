
package test;

import java.awt.Color;


import org.junit.Test;
import elements.*;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;

public class LightingTest 
//tests to light
{


	@Test 
	public void emmissionTest() throws Exception
	// test to emmission
	{

		Scene scene = new Scene();
		/*------------add Grometries to scene--------------*/
		scene.addGeometry(new Sphere(new Color(255,0,0), new Material(),50, new Point3D(0.0, 0.0, -149)));

		Triangle triangle = new Triangle(new Color(0,255,0), new Material(),new Point3D( 100, 0, -149),
				new Point3D(  0, 100, -149),
				new Point3D( 100, 100, -149));

		Triangle triangle2 = new Triangle(new Color(0,0,255), new Material(),new Point3D( 100, 0, -149),
				new Point3D(  0, -100, -149),
				new Point3D( 100,-100, -149));

		Triangle triangle3 = new Triangle(new Color(255,255,0), new Material(),new Point3D(-100, 0, -149),
				new Point3D(  0, 100, -149),
				new Point3D(-100, 100, -149));

		Triangle triangle4 = new Triangle(new Color(255,0,255), new Material(),new Point3D(-100, 0, -149),
				new Point3D(  0,  -100, -149),
				new Point3D(-100, -100, -149));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		//scene.addGeometry(triangle5);

		ImageWriter imageWriter = new ImageWriter("Emmition test", 500, 500, 500, 500);

		Renderer render = new Renderer(scene, imageWriter);

		render.renderImage();
		render.printGrid(50,500, 500);
		imageWriter.writeToimage();
	}



	@Test
	public void spotLightTest2() throws Exception
	// test to spot light
	{

		Scene scene = new Scene();
		scene.set_screenDistance(200);
		Material m=new Material(1,1,1,0,0);
		m.set_n(20);
		/*------------add Grometries to scene--------------*/
		Sphere sphere = new Sphere(new Color(0, 0, 100),new Material(1,1,1,1,1),500, new Point3D(0.0, 0.0,-1000));
		sphere.set_material(m);;
		scene.addGeometry(sphere);


		Triangle triangle = new Triangle( new Color (0, 0, 100),new Material(1,1,1,1,1),new Point3D(-125,-225, -260),
				new Point3D(-225, -125, -260),
				new Point3D(-225,-225, -270));
		Material m1=new Material(1,1,1,0,0);
		m1.set_n(4);
		triangle.set_material(m);
		scene.addGeometry(triangle);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200,-200,-150),0.1, 0.00001, 0.000005, 
				new Vector(new Point3D(2, 2, -3))));

		ImageWriter imageWriter = new ImageWriter("Spot test 2", 500, 500, 500, 500);

		Renderer render = new Renderer(scene, imageWriter);

		render.renderImage();

		imageWriter.writeToimage();


	}


	@Test
	public void spotLightTest() throws Exception
	//test to spot light 
	{

		Scene scene = new Scene();
		/*------------add Grometries to scene--------------*/
		Sphere sphere = new Sphere(new Color(0, 0, 100), new Material(),800, new Point3D(0.0, 0.0, -1000));
		Material m=new Material();
		m.set_n(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		scene.addLight(new SpotLight(new Color(255,100,100), new Point3D(-200, -200, -100), 
				0, 0.00001, 0.000005,new Vector(new Point3D(2, 2, -3))));
		ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);

		Renderer render = new Renderer(scene,imageWriter);

		render.renderImage();
		render.printGrid(50,500, 500);

		imageWriter.writeToimage();

	}

	@Test
	public void pointLightTest() throws Exception
	//test to point light
	{

		Scene scene = new Scene();
		/*------------add Grometries to scene--------------*/
		Sphere sphere = new Sphere (new Color(0, 0, 100), new Material(),800, new Point3D(0.0, 0.0, -1000));
		Material m=new Material();
		m.set_n(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100), 
				0, 0.00001, 0.000005));

		ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);

		Renderer render = new Renderer(scene,imageWriter);

		render.renderImage();

		imageWriter.writeToimage();
	}

	
	@Test
	public void spotLightTest3() throws Exception
	//test to spot light 
	{

		Scene scene = new Scene();
		/*------------add Grometries to scene--------------*/
		Triangle triangle = new Triangle(new Color(0,0,0), new Material(),new Point3D(  3500,  3500, -2000),
				new Point3D( -3500, -3500, -1000),
				new Point3D(  -3500, 3500, -2000));

		Triangle triangle2 = new Triangle(new Color(0,0,0), new Material(),new Point3D(  3500,  3500, -2000),
				new Point3D( 3500,  -3500, -1000),
				new Point3D( -3500, -3500, -1000));


		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				0, 0.000001, 0.0000005,new Vector(new Point3D(-2, -2, -3))));


		ImageWriter imageWriter = new ImageWriter("Spot test 3", 500, 500, 500, 500);

		Renderer render = new Renderer( scene,imageWriter);

		render.renderImage();
		imageWriter.writeToimage();

	}

	@Test
	public void pointLightTest2() throws Exception
	//test to point light 
	{

		Scene scene = new Scene();
		/*------------add Grometries to scene--------------*/
		Sphere sphere = new Sphere(new Color(0, 0, 100), new Material(),100, new Point3D(0.0, 0.0, -200));
		Material m=new Material();
		m.set_n(20);
		sphere.set_material(m);

		Triangle triangle = new Triangle(new Color(0,0,0), new Material(),new Point3D(  3500,  3500, -2000),
				new Point3D( -3500, -3500, -1000),
				new Point3D(  -3500, 3500, -2000));

		Triangle triangle2 = new Triangle(new Color(0,0,0), new Material(),new Point3D(  3500,  3500, -2000),
				new Point3D( 3500,  -3500, -1000),
				new Point3D( -3500, -3500, -1000));



		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				0, 0.000001, 0.0000005));


		ImageWriter imageWriter = new ImageWriter("Point test 2", 500, 500, 500, 500);

		Renderer render = new Renderer(scene,imageWriter);
		render.renderImage();
		imageWriter.writeToimage();

	}

	@Test
	public void spotLightTest4() throws Exception
	//test to spot light 
	{

		Scene scene = new Scene();
		scene.set_screenDistance(200);
		Material m=new Material(1,1,1,0,0);
		m.set_n(20);
		/*------------add Grometries to scene--------------*/
		Sphere sphere = new Sphere(new Color(0, 0, 100),new Material(1,1,1,1,1),500, new Point3D(0.0, 0.0,-1000));
		sphere.set_material(m);;
		scene.addGeometry(sphere);


		Triangle triangle = new Triangle( new Color (0, 0, 100),new Material(1,1,1,1,1),new Point3D(-50,-250, -500),
				new Point3D(-400, -250, -500),
				new Point3D(-25,-100, -500));
		Material m1=new Material(1,1,1,1,1);
		m1.set_n(4);
		triangle.set_material(m);
		scene.addGeometry(triangle);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200,-200,-150),0.1, 0.00001, 0.000005, 
				new Vector(new Point3D(2, 2, -3))));

		ImageWriter imageWriter = new ImageWriter("Spot test 4", 500, 500, 500, 500);

		Renderer render = new Renderer(scene, imageWriter);

		render.renderImage();

		imageWriter.writeToimage();


	}
	}