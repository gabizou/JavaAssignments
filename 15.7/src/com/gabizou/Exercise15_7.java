package com.gabizou;

public class Exercise15_7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GeometricObject geoObject1 = new Circle(5);
		GeometricObject geoObject2 = new Rectangle(5,3);
		System.out.println("The larger object's area is " + max(geoObject1, geoObject2));
	}

	public static double max(GeometricObject geoObject1, GeometricObject geoObject2) {
		if(geoObject1.getArea()>geoObject2.getArea()) {
			System.out.println("The larger object is Circle");
			return geoObject1.getArea();
		} else {
			System.out.println("The larger object is Rectangle");
			return geoObject2.getArea();
		}
	}
	
}
