package OA2;

public class triangle {

	/* TRIANGLE
	 * 
	 * In this program you will get various properties of a triangle with sides of
	 * your choice. No negative numbers are accepted.
	 * 
	 * Created by -----------------------------------------------------------------
	 * Tom K. Axberg - Assignment OU2 - ID1018 - KTH - 2019 November
	 */

	// Area calculated with Heron's formula
	public static double area(double side1, double side2, double side3, double s) {
		double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		System.out.println("The area of the triangle is: " + area + "cm^2");
		return area;
	}

	// The length of side1's altitude calculated and it's length and altitude
	// printed
	public static double alti1(double side1, double side2, double side3, double s) {

		double h1 = (2 / side1) * Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		System.out.println(
				"The length of side a is " + side1 + "cm and the legth of it´s " + "altitude is " + h1 + "cm.");
		return h1;
	}

	// The length of side2's altitude calculated and it's length and altitude
	// printed
	public double alti2(double side1, double side2, double side3, double s) {

		double h2 = (2 / side2) * Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		System.out.println(
				"The length of side b is " + side2 + "cm and the legth of it´s " + "altitude is " + h2 + "cm.");
		return h2;
	}

	// The length of side3's altitude calculated and it's length and altitude
	// printed
	public static double alti3(double side1, double side2, double side3, double s) {

		double h3 = (2 / side3) * Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		System.out.println(
				"The length of side c is " + side3 + "cm and the legth of it´s " + "altitude is " + h3 + "cm.");
		return h3;
	}

	// Radius of the circle that contains the triangle with the triangles edges
	// touching the circle.
	public static double outcircurf(double side1, double side2, double side3, double s) {

		double R = (side1 * side2 * side3) / (4 * Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)));
		System.out.println("The radius of the curcumcircle is: " + R);
		return R;
	}

	// Radius of the circle that fits in the triangle with the circle touching the
	// triangles sides.
	public static double inrcircurf(double side1, double side2, double side3, double s) {

		double r = Math.sqrt(((s - side1) * (s - side2) * (s - side3)) / s);
		System.out.println("The radius of the incircle is: " + r);
		return 2 * Math.PI * r;
	}

}
