package test;


import java.awt.Color;

import org.junit.Test;

import elements.*;

import geometries.*;
import primitives.*;
import renderer.ImageWriter;
import renderer.Renderer;
import scene.Scene;

public class FinalTest {

	/*	@Test
	public void test() throws Exception
	{
		Triangle t1=new Triangle(new Color(50,200,100),new Material(1,1,20,0,0),
				new Point3D(0,-100,-200),new Point3D(0,200,-200),new Point3D(300,300,-290));
		Triangle t2=new Triangle(new Color(50,50,100),new Material(1,1,20,0,0),
				new Point3D(0,-100,-200),new Point3D(100,-25,-100),new Point3D(300,300,-290));
		Triangle t3=new Triangle(new Color(150,50,100),new Material(1,1,20,0,0),
				new Point3D(0.2,-100,-200),new Point3D(0.2,200,-200),new Point3D(-300,300,-290));
		Triangle t4=new Triangle(new Color(50,50,100),new Material(1,1,20,0,0),
				new Point3D(0.2,-100,-200),new Point3D(-100,-25,-100),new Point3D(-300,300,-290));
		Triangle t5=new Triangle(new Color(50,150,100),new Material(1,1,20,0,0),
				new Point3D(300,300,-290),new Point3D(0,200,-200),new Point3D(-300,300,-290));
		Triangle t6=new Triangle(new Color(50,50,100),new Material(1,1,20,0,0),
				new Point3D(300,300,-290),new Point3D(-300,300,-290),new Point3D(0,305,-290));
		Triangle t7=new Triangle(new Color(200,150,100),new Material(1,1,20,0,0),
				new Point3D(-100,-25,-100),new Point3D(-300,-25,-100),new Point3D(-10,-100,-200));
		Triangle t8=new Triangle(new Color(50,50,100),new Material(1,1,20,0,0),
				new Point3D(100,-25,-100),new Point3D(-100,-25,-100),new Point3D(0,100,-290));
		Triangle triangle = new Triangle(new Color(20, 20, 20),new Material(1,1,20,1,0),new Point3D(  700,  400, -400),
				new Point3D( -700, -400, -160),
				new Point3D(  -700, 400, -400));

		Triangle triangle2 = new Triangle(new Color(20, 20, 20),new Material(1,1,20,1,0),new Point3D(  700,  400, -400),
				new Point3D( 700,  -400, -160),
				new Point3D( -700, -400, -160));
		Scene scene = new Scene();
		Sphere sphere1 = new Sphere(new Color(200,150,100), new Material(),50, new Point3D(-100, -70, -100));
		scene.addGeometry(sphere1);
		scene.addGeometry(t1);
		//scene.set_background(Color.white);
		scene.addGeometry(t2);
		scene.addGeometry(t3);
		scene.addGeometry(t4);
		scene.addGeometry(t5);
		scene.addGeometry(t6);
		scene.addGeometry(t7);
		//scene.addGeometry(t8);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				0, 0.000001, 0.0000005));
		scene.addLight(new SpotLight(new Color(0, 100, 200),  new Point3D(-200, -50, -50), 
				   0, 0.00001, 0.000005, new Vector(new Point3D(-2, -2, -3))));
		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				0, 0.000001, 0.0000005));

		ImageWriter imageWriter = new ImageWriter("Final test", 500, 500, 500, 500);

		Renderer render = new Renderer(scene, imageWriter);

		render.renderImage();
		//render.printGrid(50,500, 500);
		imageWriter.writeToimage();


	}*/

/*	@Test
	public void test() throws Exception
	{
		Scene scene = new Scene();
		scene.set_background(new Color(165,220,243));
		Sphere sphere1 = new Sphere(new Color(71,40,4), new Material(1,1,20,0,0),70, new Point3D(-100, -70, -200));
		Sphere sphere2 = new Sphere(new Color(71,40,4), new Material(1,1,20,0,0),70, new Point3D(-50, -50, -200));
		Sphere sphere3 = new Sphere(new Color(71,40,4), new Material(1,1,20,0,1),70, new Point3D(0, -30, -200));
		Sphere sphere4 = new Sphere(new Color(71,40,4), new Material(1,1,20,0,0),70, new Point3D(50, -10, -200));
		Sphere sphere5 = new Sphere(new Color(71,40,4), new Material(1,1,20,0,0),9, new Point3D(275,190,-200));
		Sphere sphere6 = new Sphere(new Color(0,0,0), new Material(1,1,20,0,0),7, new Point3D(185,200,-200));
		Sphere sphere62 = new Sphere(new Color(255,255,255), new Material(1,1,20,0,1),9, new Point3D(185,200,-200));
		//cloud 1
		Sphere sphere71 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),45, new Point3D(50,350,-200));
		Sphere sphere72 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),50, new Point3D(0,350,-200));
		Sphere sphere73 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),45, new Point3D(-50,350,-200));
		Sphere sphere74 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),30, new Point3D(-90,350,-200));
		Sphere sphere75 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),30, new Point3D(90,350,-200));
		//cloud 2
		Sphere sphere81 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),45, new Point3D(-270,350,-200));
		Sphere sphere82 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),30, new Point3D(-310,350,-200));
		Sphere sphere83 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),30, new Point3D(-230,350,-200));

		//cloud 3
		Sphere sphere91 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),45, new Point3D(270,350,-200));
		Sphere sphere92 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),30, new Point3D(310,350,-200));
		Sphere sphere93 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),30, new Point3D(230,350,-200));




		Triangle t1=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(30,59,-200),new Point3D(-130,-7,-200),new Point3D(-100,-70,-200));
		Triangle t2=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(100,-77,-200),new Point3D(-90,-150,-200),new Point3D(-100,-70,-200));
		Triangle t3=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(20,25,-200),new Point3D(135,0,-200),new Point3D(80,200,-200));
		Triangle t4=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(80,200,-200),new Point3D(180,230,-200),new Point3D(102,116,-200));
		Triangle t5=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(180,230,-200),new Point3D(280,180,-200),new Point3D(125,150,-200));
		Triangle t6=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(120,150,-200),new Point3D(98,110,-200),new Point3D(135,0,-200));
		Triangle t7=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(122,110,-200),new Point3D(120,150,-200),new Point3D(180,162,-200));
		
		Triangle t10=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(120,210,-200),new Point3D(130,250,-200),new Point3D(150,220,-200));
		Triangle t11=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(140,210,-205),new Point3D(150,260,-205),new Point3D(170,220,-205));
		//heir
		Triangle t8=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,204,-200),new Point3D(75,197,-200),new Point3D(0,200,-201));
		Triangle t9=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,197,-200),new Point3D(75,183,-200),new Point3D(0,190,-201));
		Triangle t91=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,183,-200),new Point3D(75,176,-200),new Point3D(0,180,-201));
		Triangle t92=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,176,-200),new Point3D(75,169,-200),new Point3D(0,170,-201));
		Triangle t93=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,169,-200),new Point3D(75,162,-200),new Point3D(0,160,-201));
		Triangle t94=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,162,-200),new Point3D(75,155,-200),new Point3D(0,150,-201));
		Triangle t95=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,155,-200),new Point3D(75,148,-200),new Point3D(0,140,-201));
		Triangle t96=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,148,-200),new Point3D(75,141,-200),new Point3D(0,130,-201));
		Triangle t97=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,141,-200),new Point3D(75,134,-200),new Point3D(0,120,-201));
		Triangle t98=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,134,-200),new Point3D(75,127,-200),new Point3D(0,110,-201));
		Triangle t99=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,127,-200),new Point3D(75,120,-200),new Point3D(0,100,-201));
		Triangle t910=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,120,-200),new Point3D(75,113,-200),new Point3D(0,90,-201));
		Triangle t911=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,113,-200),new Point3D(75,106,-200),new Point3D(0,80,-201));
		Triangle t912=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,106,-200),new Point3D(75,99,-200),new Point3D(0,70,-201));
		Triangle t913=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,99,-200),new Point3D(75,92,-200),new Point3D(0,60,-201));
		Triangle t914=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,92,-200),new Point3D(75,85,-200),new Point3D(0,50,-201));
		Triangle t915=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,85,-200),new Point3D(75,78,-200),new Point3D(0,40,-201));
		//the hourse's mouth
		Triangle tMouth=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(180,230,-200),new Point3D(280,178,-200),new Point3D(280,200,-200));
		//leg 1
		Triangle t12=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(60,-80,-200),new Point3D(110,-50,-200),new Point3D(160,-150,-200));
		Triangle t13=new Triangle(new Color(71,40,4),new Material(1,1,20,1,0),
				new Point3D(160,-150,-200),new Point3D(185,-200,-200),new Point3D(60,-80,-200));
		Triangle t14=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(185,-200,-200),new Point3D(190,-260,-200),new Point3D(145,-163,-200));
		//leg 2
		Triangle t15=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(110,-50,-200),new Point3D(130,0,-200),new Point3D(220,-100,-200));
		Triangle t16=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(220,-100,-200),new Point3D(190,-85,-200),new Point3D(230,-200,-200));
		//leg 3
		Triangle t17=new Triangle(new Color(71,40,4),new Material(1,1,20,0,1),
				new Point3D(-201,-100,-200),new Point3D(-130,-130,-200),new Point3D(-93,-282,-200));
		Triangle t18=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-152.7,-182,-200),new Point3D(-125,-280,-200),new Point3D(-94.3,-280,-200));
		Triangle t19=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-120,-350,-200),new Point3D(-127,-279,-200),new Point3D(-95,-279,-200));
		Triangle t20=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-120,-350,-200),new Point3D(-102,-300,-200),new Point3D(-75,-400,-200));	
		//leg 4
		Triangle t21=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-120,-120,-200),new Point3D(-60,-90,-200),new Point3D(-29,-290,-200));
		Triangle t22=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-31,-290,-201),new Point3D(-47,-250,-201),new Point3D(-175,-380,-201));
		Triangle t23=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-175,-380,-200),new Point3D(-140,-358,-200),new Point3D(-130,-420,-200));
		//tail
		Triangle t24=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-185,-80,-200),new Point3D(-180,-90,-200),new Point3D(-250,-220,-200));
		Triangle t25=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-193,-70,-200),new Point3D(-190,-80,-200),new Point3D(-250,-210,-200));
		Triangle t26=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-193,-60,-200),new Point3D(-195,-70,-200),new Point3D(-250,-200,-200));


		Triangle triangle2 = new Triangle(new Color(37, 108, 34),new Material(1,1,20,0,0),new Point3D( 1500, -850, -350),
				new Point3D( -1000,  -1000, -350),
				new Point3D( -1000, -500, -350));

		scene.addGeometry(sphere1);
		scene.addGeometry(sphere2);
		scene.addGeometry(sphere3);
		scene.addGeometry(sphere4);
		scene.addGeometry(sphere5);
		//eyes
		scene.addGeometry(sphere6);
		scene.addGeometry(sphere62);
		//cloud 1
		scene.addGeometry(sphere71);
		scene.addGeometry(sphere72);
		scene.addGeometry(sphere73);
		scene.addGeometry(sphere74);
		scene.addGeometry(sphere75);
		//cloud 2
		scene.addGeometry(sphere81);
		scene.addGeometry(sphere82);
		scene.addGeometry(sphere83);
		//cloud 2
		scene.addGeometry(sphere91);
		scene.addGeometry(sphere92);
		scene.addGeometry(sphere93);
	


		scene.addGeometry(t1);
		scene.addGeometry(t2);
		scene.addGeometry(t3);
		scene.addGeometry(t4);
		scene.addGeometry(t5);
		scene.addGeometry(t6);
		scene.addGeometry(t7);
		//heir
	//	scene.addGeometry(t8);
		scene.addGeometry(t9);
		scene.addGeometry(t91);
		scene.addGeometry(t92);
		scene.addGeometry(t93);
		scene.addGeometry(t94);
		scene.addGeometry(t95);		
		scene.addGeometry(t96);
		scene.addGeometry(t97);
		scene.addGeometry(t98);
		scene.addGeometry(t99);		
		scene.addGeometry(t910);
		scene.addGeometry(t911);
		scene.addGeometry(t912);		
		scene.addGeometry(t913);
		scene.addGeometry(t914);
		scene.addGeometry(t915);
		

		scene.addGeometry(t10);
		scene.addGeometry(t11);
		//leg1
		scene.addGeometry(t12);
		scene.addGeometry(t13);
		scene.addGeometry(t14);
		//leg 2
		scene.addGeometry(t15);
		scene.addGeometry(t16);
		//leg 3
		scene.addGeometry(t17);
		scene.addGeometry(t18);
		scene.addGeometry(t19);
		scene.addGeometry(t20);
		//leg 4
		scene.addGeometry(t21);
		scene.addGeometry(t22);
		scene.addGeometry(t23);
		//tail
		scene.addGeometry(t24);
		scene.addGeometry(t25);
		scene.addGeometry(t26);
		scene.addGeometry(tMouth);
		scene.addGeometry(triangle2);

		
		scene.addLight(new PointLight(new Color(0, 100, 200),  new Point3D(0,450,150), 
				0, 0.0001, 0.0005));
		ImageWriter imageWriter = new ImageWriter("Final test", 500, 500, 500, 500);
		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-275, 270, -100), 
				0, 0.000001, 0.0000005));
		scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(220, 240, -150), 
				   0, 0.00001, 0.000005, new Vector(new Point3D(-2, -2, -3))));
		Renderer render = new Renderer(scene, imageWriter);

		render.renderImage();
		//render.printGrid(50,500, 500);
		imageWriter.writeToimage();

	}*/
	@Test
	public void test() throws Exception
	{
		Scene scene = new Scene();
		scene.set_background(new Color(165,220,243));
		Sphere sphere1 = new Sphere(new Color(71,40,4), new Material(1,1,20,0,0),70, new Point3D(-100, -70, -200));
		Sphere sphere2 = new Sphere(new Color(71,40,4), new Material(1,1,20,0,0),70, new Point3D(-50, -50, -200));
		Sphere sphere3 = new Sphere(new Color(71,40,4), new Material(1,1,20,0,1),70, new Point3D(0, -30, -200));
		Sphere sphere4 = new Sphere(new Color(71,40,4), new Material(1,1,20,0,0),70, new Point3D(50, -10, -200));
		Sphere sphere5 = new Sphere(new Color(71,40,4), new Material(1,1,20,0,0),9, new Point3D(275,190,-200));
		Sphere sphere6 = new Sphere(new Color(0,0,0), new Material(1,1,20,0,0),7, new Point3D(185,200,-200));
		Sphere sphere62 = new Sphere(new Color(247,247,236), new Material(1,1,20,0,1),9, new Point3D(185,200,-200));
		//cloud 1
		Sphere sphere71 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),45, new Point3D(50,350,-200));
		Sphere sphere72 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),50, new Point3D(0,350,-200));
		Sphere sphere73 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),45, new Point3D(-50,350,-200));
		Sphere sphere74 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),30, new Point3D(-90,350,-200));
		Sphere sphere75 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),30, new Point3D(90,350,-200));
		//cloud 2
		Sphere sphere81 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),45, new Point3D(-270,350,-200));
		Sphere sphere82 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),30, new Point3D(-310,350,-200));
		Sphere sphere83 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),30, new Point3D(-230,350,-200));

		//cloud 3
		Sphere sphere91 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),45, new Point3D(270,350,-200));
		Sphere sphere92 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),30, new Point3D(310,350,-200));
		Sphere sphere93 = new Sphere(new Color(171,246,243), new Material(1,1,20,0,0),30, new Point3D(230,350,-200));




		Triangle t1=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(30,59,-200),new Point3D(-130,-7,-200),new Point3D(-100,-70,-200));
		Triangle t2=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(100,-77,-200),new Point3D(-90,-150,-200),new Point3D(-100,-70,-200));
		Triangle t3=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(20,25,-200),new Point3D(135,0,-200),new Point3D(80,200,-200));
		Triangle t4=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(80,200,-200),new Point3D(180,230,-200),new Point3D(102,116,-200));
		Triangle t5=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(180,230,-200),new Point3D(280,180,-200),new Point3D(125,150,-200));
		Triangle t6=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(120,150,-200),new Point3D(98,110,-200),new Point3D(135,0,-200));
		Triangle t7=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(122,110,-200),new Point3D(120,150,-200),new Point3D(180,162,-200));
		
		Triangle t10=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(120,210,-200),new Point3D(130,250,-200),new Point3D(150,220,-200));
		Triangle t11=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(140,210,-205),new Point3D(150,260,-205),new Point3D(170,220,-205));
		//heir
		Triangle t8=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,204,-200),new Point3D(75,197,-200),new Point3D(0,200,-201));
		Triangle t9=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,197,-200),new Point3D(75,183,-200),new Point3D(0,190,-201));
		Triangle t91=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,183,-200),new Point3D(75,176,-200),new Point3D(0,180,-201));
		Triangle t92=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,176,-200),new Point3D(75,169,-200),new Point3D(0,170,-201));
		Triangle t93=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,169,-200),new Point3D(75,162,-200),new Point3D(0,160,-201));
		Triangle t94=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,162,-200),new Point3D(75,155,-200),new Point3D(0,150,-201));
		Triangle t95=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,155,-200),new Point3D(75,148,-200),new Point3D(0,140,-201));
		Triangle t96=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,148,-200),new Point3D(75,141,-200),new Point3D(0,130,-201));
		Triangle t97=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,141,-200),new Point3D(75,134,-200),new Point3D(0,120,-201));
		Triangle t98=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,134,-200),new Point3D(75,127,-200),new Point3D(0,110,-201));
		Triangle t99=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,127,-200),new Point3D(75,120,-200),new Point3D(0,100,-201));
		Triangle t910=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,120,-200),new Point3D(75,113,-200),new Point3D(0,90,-201));
		Triangle t911=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,113,-200),new Point3D(75,106,-200),new Point3D(0,80,-201));
		Triangle t912=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,106,-200),new Point3D(75,99,-200),new Point3D(0,70,-201));
		Triangle t913=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,99,-200),new Point3D(75,92,-200),new Point3D(0,60,-201));
		Triangle t914=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,92,-200),new Point3D(75,85,-200),new Point3D(0,50,-201));
		Triangle t915=new Triangle(new Color(100,100,100),new Material(1,1,20,0,0),
				new Point3D(80,85,-200),new Point3D(75,78,-200),new Point3D(0,40,-201));
		//the hourse's mouth
		Triangle tMouth=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(180,230,-200),new Point3D(280,178,-200),new Point3D(280,200,-200));
		//leg 1
		Triangle t12=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(60,-80,-200),new Point3D(110,-50,-200),new Point3D(160,-150,-200));
		Triangle t13=new Triangle(new Color(71,40,4),new Material(1,1,20,1,0),
				new Point3D(160,-150,-200),new Point3D(185,-200,-200),new Point3D(60,-80,-200));
		Triangle t14=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(185,-200,-200),new Point3D(190,-260,-200),new Point3D(145,-163,-200));
		//leg 2
		Triangle t15=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(110,-50,-200),new Point3D(130,0,-200),new Point3D(220,-100,-200));
		Triangle t16=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(220,-100,-200),new Point3D(190,-85,-200),new Point3D(230,-200,-200));
		//leg 3
		Triangle t17=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-201,-100,-200),new Point3D(-130,-130,-200),new Point3D(-93,-282,-200));
		Triangle t18=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-152.7,-182,-200),new Point3D(-125,-280,-200),new Point3D(-94.3,-280,-200));
		Triangle t19=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-120,-350,-200),new Point3D(-127,-279,-200),new Point3D(-95,-279,-200));
		Triangle t20=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-120,-350,-200),new Point3D(-102,-300,-200),new Point3D(-75,-400,-200));	
		//leg 4
		Triangle t21=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-120,-120,-200),new Point3D(-60,-90,-200),new Point3D(-29,-290,-200));
		Triangle t22=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-31,-290,-201),new Point3D(-47,-250,-201),new Point3D(-175,-380,-201));
		Triangle t23=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-175,-380,-200),new Point3D(-140,-358,-200),new Point3D(-130,-420,-200));
		//tail
		Triangle t24=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-185,-80,-200),new Point3D(-180,-90,-200),new Point3D(-250,-220,-200));
		Triangle t25=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-193,-70,-200),new Point3D(-190,-80,-200),new Point3D(-250,-210,-200));
		Triangle t26=new Triangle(new Color(71,40,4),new Material(1,1,20,0,0),
				new Point3D(-193,-60,-200),new Point3D(-195,-70,-200),new Point3D(-250,-200,-200));


		Triangle triangle2 = new Triangle(new Color(37, 108, 34),new Material(1,1,20,0,0),new Point3D( 1500, -850, -210),
				new Point3D( -2000,  -1000, -210),
				new Point3D( 1000,100, -210));
		Triangle triangle3 = new Triangle(new Color(100,100,100),new Material(1,1,20,1,0),new Point3D( 4000, 8000, -250),
				new Point3D( -4000,  -2100, -250),
				new Point3D( 4000, -2500, -250));

		scene.addGeometry(sphere1);
		scene.addGeometry(sphere2);
		scene.addGeometry(sphere3);
		scene.addGeometry(sphere4);
		scene.addGeometry(sphere5);
		//eyes
		scene.addGeometry(sphere6);
	//	scene.addGeometry(sphere62);
		//cloud 1
		scene.addGeometry(sphere71);
		scene.addGeometry(sphere72);
		scene.addGeometry(sphere73);
		scene.addGeometry(sphere74);
		scene.addGeometry(sphere75);
		//cloud 2
		scene.addGeometry(sphere81);
		scene.addGeometry(sphere82);
		scene.addGeometry(sphere83);
		//cloud 2
		scene.addGeometry(sphere91);
		scene.addGeometry(sphere92);
		scene.addGeometry(sphere93);
	


		scene.addGeometry(t1);
		scene.addGeometry(t2);
		scene.addGeometry(t3);
		scene.addGeometry(t4);
		scene.addGeometry(t5);
		scene.addGeometry(t6);
		scene.addGeometry(t7);
		//heir
	//	scene.addGeometry(t8);
		scene.addGeometry(t9);
		scene.addGeometry(t91);
		scene.addGeometry(t92);
		scene.addGeometry(t93);
		scene.addGeometry(t94);
		scene.addGeometry(t95);		
		scene.addGeometry(t96);
		scene.addGeometry(t97);
		scene.addGeometry(t98);
		scene.addGeometry(t99);		
		scene.addGeometry(t910);
		scene.addGeometry(t911);
		scene.addGeometry(t912);		
		scene.addGeometry(t913);
		scene.addGeometry(t914);
		scene.addGeometry(t915);
		

		scene.addGeometry(t10);
		scene.addGeometry(t11);
		//leg1
		scene.addGeometry(t12);
		scene.addGeometry(t13);
		scene.addGeometry(t14);
		//leg 2
		scene.addGeometry(t15);
		scene.addGeometry(t16);
		
		//leg 3
		scene.addGeometry(t17);
		scene.addGeometry(t18);
		scene.addGeometry(t19);
		scene.addGeometry(t20);
		//leg 4
		scene.addGeometry(t21);
		scene.addGeometry(t22);
		scene.addGeometry(t23);
		//tail
		scene.addGeometry(t24);
		scene.addGeometry(t25);
		scene.addGeometry(t26);
		scene.addGeometry(tMouth);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);

		
		/*scene.addLight(new PointLight(new Color(0, 100, 200),  new Point3D(0,450,150), 
				0, 0.0001, 0.0005));*/
		ImageWriter imageWriter = new ImageWriter("Final test", 500, 500, 500, 500);
		scene.addLight(new SpotLight(new Color(246, 246, 67), new Point3D(-300,500 , 300), 
				 0, 0.00001, 0.000005, new Vector(new Point3D(-2, -2, -3))));
		
		/*scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(220, 240, -150), 
				   0, 0.00001, 0.000005, new Vector(new Point3D(-2, -2, -3))));*/
		Renderer render = new Renderer(scene, imageWriter);

		render.renderImage();
		//render.printGrid(50,500, 500);
		imageWriter.writeToimage();

	}

}
