package primitives;
//import java.awt.Color;
//import geometries.Sphere;

//this part is the test case on the primitives 
class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		/*Coordinate x1=new Coordinate(2);
		Coordinate y1=new Coordinate(3);
		Coordinate z1=new Coordinate(4);
		Coordinate x2=new Coordinate(5);
		Coordinate y2=new Coordinate(6);
		Coordinate z2=new Coordinate(7);
		Point3D p1= new Point3D(x1,y1,z1);
		Point3D p2= new Point3D(x2,y2,z2);
		Vector v1= new Vector (p1);
		Vector v2= new Vector (p2);
		System.out.println(x1.add(x2));
		System.out.println(x2.substrct(x1));
		System.out.println(v1.crossProduct(v2));
		System.out.println(v1.dotProduct(v2));
		System.out.println(v1.equals(v2));
		p1.add(v2);
		System.out.println(p1.toString());
		p1.substrct(v2);
		System.out.println(p1.toString());
		v1.substrct(v2);
		System.out.println(v1.toString());
		System.out.println(v1.length());
		v1.normalize();
		System.out.println(v1.toString());
		System.out.println(v1.length());*/
		//Color c=Color.black;
		Coordinate coor=new Coordinate(0);
		Point3D p1=new Point3D(new Coordinate(0),new Coordinate(0),coor);
		//Sphere sp =new Sphere(c,1, p1);
		Point3D p2= new Point3D(new Coordinate(1), coor, coor);
	//	Point3D p3= new Point3D(new Coordinate(-1), coor, coor);
	
		Vector v3= new Vector(p1);
		
	//	Vector v=sp.getNormal(p2);
		//System.out.println(v.toString());
		 v3.substrct(new Vector(p2));

		System.out.println(v3.toString());

	//	Coordinate x=new Coordinate(0);
		//Coordinate y=new Coordinate(1);
//		x.substrct(y);
//		System.out.println(x.toString());
		
		
	}

}
