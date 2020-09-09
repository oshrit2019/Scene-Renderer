package test;

import renderer.*;
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class ImageWriterTest 
//tests to image writer
{	
	public void printGrid(ImageWriter image, int interval) 
	{
		for(int i=0; i<500; i++)
			for(int j=0; j<500; j++)
				if(i%interval==0|| j%interval==0)
					image.writePixel(i,j,255,255,255);
				else
					image.writePixel(i,j,0,0,0);

	}
	@Test 
	public void test1()
	{
		ImageWriter image= new ImageWriter ("test1",500,500,500,500);
		printGrid(image,50);
		for(int i=150;i<350;i++)
		{
			for(int j=300;j<500;j++)
				image.writePixel(i,j,255,255,0);
		}
		image.writeToimage();

		assertTrue(true);
	}
	
	@Test 
	public void test2()
	{
		ImageWriter image= new ImageWriter ("test2",500,500,500,500);
		printGrid(image,50);
		int[] rgbArray=new int[3];
		rgbArray[0]=150;
		rgbArray[1]=255;
		rgbArray[2]=250;
		for(int i=151;i<200;i++)
		{
			for(int j=101;j<150;j++)
				image.writePixel(i,j,rgbArray);
		}

		image.writeToimage();

		assertTrue(true);
	}
	@Test
	public void test3()
	{
		ImageWriter image= new ImageWriter ("test3",500,500,500,500);
		printGrid(image,50);
		Color c=new Color(192,153,189);
		
		for(int i=151;i<200;i++)
		{
			for(int j=101;j<300;j++)
				image.writePixel(i,j,c);
		}
		for(int i=200;i<350;i++)
		{
			for(int j=250;j<300;j++)
				image.writePixel(i,j,c);
		}
		image.writeToimage();

		assertTrue(true);
	}

}
