
package test;

import geometries.*;
import primitives.*;
import renderer.*;
import scene.*;

import java.awt.Color;

import org.junit.Test;

import elements.*;
public class testRenderer 
// tests to Render Image
{
	@Test
	public void RendererImage1() throws Exception
	//test to Renderer Image
	{
		
		Scene scene = new Scene();
		Color c=new Color(255,255,255);
		/*------------add Grometries to scene--------------*/
		scene.addGeometry(new Sphere(c,new Material(), 50, new Point3D(0.0, 0.0, -150)));
		
		Triangle triangle = new Triangle(c,new Material(),new Point3D( 100, 0, -149),
				 						 new Point3D(  0, 100, -149),
				 						 new Point3D( 100, 100, -149));
		
		Triangle triangle2 = new Triangle(c,new Material(),new Point3D(100, 0, -149),
				 			 			  new Point3D(  0, -100, -149),
				 			 			  new Point3D( 100,-100, -149));
		
		Triangle triangle3 = new Triangle(c,new Material(),new Point3D(-100, 0, -149),
				 						  new Point3D(  0, 100, -149),
				 						  new Point3D(-100, 100, -149));
		
		Triangle triangle4 = new Triangle(c,new Material(),new Point3D(-100, 0, -149),
				 			 			  new Point3D(  0,  -100, -149),
				 			 			  new Point3D(-100, -100, -149));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		scene.set_background(new Color(152,20,30));
		//create image writer
		ImageWriter imageWriter = new ImageWriter("Render test1", 500, 500, 500, 500);
		
		Renderer render = new Renderer(scene,imageWriter);
		//call to render Image function
		render.renderImage();		
		render.printGrid(50,500,500);
		imageWriter.writeToimage();		
		
	}
	@Test
	public void RendererImage2()  throws Exception
	//test to Renderer Image
	{
		Scene scene = new Scene();
		/*------------add Grometries to scene--------------*/
		Triangle triangle = new Triangle(new Color(255, 255, 255),new Material(),new Point3D( 70,  0, -200),
				 new Point3D( 70, -100, -200),
				 new Point3D(  -70, -100, -200));
		Triangle triangle1 = new Triangle(new Color(255, 255, 255),new Material(),new Point3D( -70,  -100, -200),
				 new Point3D( 70, 0, -200),
				 new Point3D( -70, 0, -200));
		Triangle triangle2 = new Triangle(new Color(255, 255, 255),new Material(),new Point3D( 0,  100, -200),
				 new Point3D( 0, 0, -200),
				 new Point3D(  100, 0, -200));
		Triangle triangle3 = new Triangle(new Color(255, 255, 255),new Material(),new Point3D( 0,  100, -200),
				 new Point3D( 0, 0, -200),
				 new Point3D(  -100, 0, -200));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
	
		//create image writer
		ImageWriter imageWriter = new ImageWriter("Render test2", 500, 500, 500, 500);
		
		Renderer render = new Renderer(scene,imageWriter);
		//call to render Image function
		render.renderImage();
		render.printGrid(50,500,500);
		render.get_imageWriter().writeToimage();
	}
	@Test
	public void RendererImage3()  throws Exception
	{
		Scene scene = new Scene();
			
		/*------------add Grometries to scene--------------*/
		//scene.addGeometry(new Sphere(new Color(255,255,255),10, new Point3D(-10, 60, -200)));
		Triangle triangle2 = new Triangle(new Color(255, 255, 255),new Material(),new Point3D( -10,  55, -200),
				 new Point3D( -10, 80, -200),
				 new Point3D(  20,80, -200));
		scene.addGeometry(triangle2);
		scene.addGeometry(new Sphere(new Color(255,255,255),new Material(), 35, new Point3D(-10, 20, -200)));
		scene.addGeometry(new Sphere(new Color(255,255,255),new Material(), 70, new Point3D(-10, -40, -200)));
		
		ImageWriter imageWriter = new ImageWriter("Render test3", 500, 500, 500, 500);
		
		Renderer render = new Renderer(scene,imageWriter);
		//call to render Image function
		render.renderImage();
		render.printGrid(50,500,500);
		render.get_imageWriter().writeToimage();
	}
	
	
	
	
	@Test
	public void RendererImage4() throws Exception
	//test to Renderer Image
	{
		
		Scene scene = new Scene();
		Color c=new Color(196,145,55);
		/*------------add Grometries to scene--------------*/
		scene.addGeometry(new Sphere(c,new Material(), 50, new Point3D(0.0, 0.0, -150)));
		
		Triangle triangle = new Triangle(new Color(255,0,55),new Material(),new Point3D( 100, 0, -149),
				 						 new Point3D(  0, 100, -149),
				 						 new Point3D( 100, 100, -149));
		
		Triangle triangle2 = new Triangle(new Color(0,56,55),new Material(),new Point3D(100, 0, -149),
				 			 			  new Point3D(  0, -100, -149),
				 			 			  new Point3D( 100,-100, -149));
		
		Triangle triangle3 = new Triangle(new Color(196,168,176),new Material(),new Point3D(-100, 0, -149),
				 						  new Point3D(  0, 100, -149),
				 						  new Point3D(-100, 100, -149));
		
		Triangle triangle4 = new Triangle(new Color(96,45,155),new Material(),new Point3D(-100, 0, -149),
				 			 			  new Point3D(  0,  -100, -149),
				 			 			  new Point3D(-100, -100, -149));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		//create image writer
		ImageWriter imageWriter = new ImageWriter("Render test4", 500, 500, 500, 500);
		
		Renderer render = new Renderer(scene,imageWriter);
		//call to render Image function
		render.renderImage();		
		render.printGrid(50,500,500);
		imageWriter.writeToimage();		
		
	}
	@Test
	public void RendererImage5()  throws Exception
	//test to Renderer Image
	{
		Scene scene = new Scene();
		/*------------add Grometries to scene--------------*/
		Triangle triangle = new Triangle(new Color(255, 200, 200),new Material(),new Point3D( 70,  0, -200),
				 new Point3D( 70, -100, -200),
				 new Point3D(  -70, -100, -200));
		Triangle triangle1 = new Triangle(new Color(200, 200, 255),new Material(),new Point3D( -70,  -100, -200),
				 new Point3D( 70, 0, -200),
				 new Point3D( -70, 0, -200));
		Triangle triangle2 = new Triangle(new Color(200, 255, 200),new Material(),new Point3D( 0,  100, -200),
				 new Point3D( 0, 0, -200),
				 new Point3D(  100, 0, -200));
		Triangle triangle3 = new Triangle(new Color(200, 200, 200),new Material(),new Point3D( 0,  100, -200),
				 new Point3D( 0, 0, -200),
				 new Point3D(  -100, 0, -200));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
	
		//create image writer
		ImageWriter imageWriter = new ImageWriter("Render test5", 500, 500, 500, 500);
		
		Renderer render = new Renderer(scene,imageWriter);
		//call to render Image function
		render.renderImage();
		render.printGrid(50,500,500);
		render.get_imageWriter().writeToimage();
	}
	@Test
	public void RendererImage6()  throws Exception
	{
		Scene scene = new Scene();
			
		/*------------add Grometries to scene--------------*/
		//scene.addGeometry(new Sphere(new Color(255,255,255),10, new Point3D(-10, 60, -200)));
		Triangle triangle2 = new Triangle(new Color(100, 20, 100),new Material(),new Point3D( -10,  55, -200),
				 new Point3D( -10, 80, -200),
				 new Point3D(  20,80, -200));
		scene.addGeometry(triangle2);
		scene.addGeometry(new Sphere(new Color(120,190,70),new Material(), 35, new Point3D(-10, 20, -200)));
		scene.addGeometry(new Sphere(new Color(150,198,75),new Material(), 70, new Point3D(-10, -40, -200)));
		
		ImageWriter imageWriter = new ImageWriter("Render test6", 500, 500, 500, 500);
		
		Renderer render = new Renderer(scene,imageWriter);
		//call to render Image function
		render.renderImage();
		render.printGrid(50,500,500);
		render.get_imageWriter().writeToimage();
	}
	
	@Test
	public void renderLightTest1()  throws Exception
	{
		Sphere s = new Sphere(new Color(75, 102, 0) ,new Material(), 40 ,new Point3D(-100,10,-149));
		Sphere s1 = new Sphere(new Color(112, 153, 0) ,new Material(), 30 ,new Point3D(-50,10,-149));
		Sphere s2 = new Sphere(new Color(168, 230, 0) ,new Material(), 25 ,new Point3D(0,10,-149));
		Sphere s3 = new Sphere(new Color(112, 153, 0),new Material(), 30 ,new Point3D(50,10,-149));
		Sphere s4 = new Sphere(new Color(75, 102, 0) ,new Material(), 40 ,new Point3D(100,10,-149));
		s.get_material().set_n(50);
		s1.get_material().set_n(20);
		s2.get_material().set_n(100);
		s3.get_material().set_n(20);
		s4.get_material().set_n(100);
		Scene sc =new Scene();
		sc.addGeometry(s);
		sc.addGeometry(s1);
		sc.addGeometry(s3);
		sc.addGeometry(s4);
		sc.addGeometry(s2);
		sc.set_background(new Color(201, 177, 131));
		//point originally was 200 200 100
		sc.addLight(new PointLight(new Color(255, 255, 255), new Point3D(0, 10, -100), 
					   0, 0.01, 0.05));
		
		sc.addLight(new PointLight(new Color(255, 255, 255), new Point3D(0, 10, -100), 
				   0, 0.01, 0.05));
		sc.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 
				0, 0.00001, 0.000005,new Vector(new Point3D(2, 2, -3))));
		
		ImageWriter imageWriter = new ImageWriter("LightTest1", 500, 500, 500, 500);
		
		Renderer render = new Renderer(sc,imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
	}

	/*@Test
	public void spotLightTest(){
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere(new Color(0, 0, 100),new Material(1,1,20),800, new Point3D(0.0, 0.0, -100));
		
		scene.addGeometry(sphere);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 
				0, 0.00001, 0.000005,new Vector(new Point3D(2, 2, -3))));
	
		ImageWriter imageWriter = new ImageWriter("SpotLightTest2", 500, 500, 500, 500);
		
		Renderer render = new Renderer(scene, imageWriter);
		render.renderImage();
		imageWriter.writeToimage();
		
	}*/
}
