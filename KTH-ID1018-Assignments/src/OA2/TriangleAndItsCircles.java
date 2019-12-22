package OA2;

import java.util.Scanner;

public class TriangleAndItsCircles {

	/*
	 * TRIANGLE
	 * 
	 * In this program you will get various properties of a triangle with sides of
	 * your choice. No negative numbers are accepted.
	 * 
	 * Created by -----------------------------------------------------------------
	 * Tom K. Axberg - Assignment OU2 - ID1018 - KTH - 2019 November
	 */

	public static void main(String[] args) {

		// Here the program TRIANGLE will take non negative inputs and execute.
		Scanner in = new Scanner(System.in);
		System.out.println("Please input a in cm: ");
		double a = in.nextDouble();
		if (a > 0) {
			System.out.println("Please input b in cm: ");
		} else {
			throw new IllegalArgumentException("Invalid input. Please restart program.");
		}
		double b = in.nextDouble();
		if (b > 0) {
			System.out.println("Please input c in cm: ");
		} else {
			throw new IllegalArgumentException("Invalid input. Please restart program.");
		}
		double c = in.nextDouble();
		if (c < 0 || a + b == c || c + b == a || c + a == b) {
			throw new IllegalArgumentException("Invalid input. Please restart program.");
			
		}
		else if (c > 0) {
			double s = (a + b + c) / 2;
			System.out.println();
			triangle.area(a, b, c, s);
			System.out.println();
			triangle.alti1(a, b, c, s);
			System.out.println();
			
			triangle f = new triangle();
			
			f.alti2(a, b, c, s);
			System.out.println();
			triangle.alti3(a, b, c, s);
			System.out.println();
			triangle.outcircurf(a, b, c, s);
			System.out.println();
			triangle.inrcircurf(a, b, c, s);
			return;

		}
		
	}

}
