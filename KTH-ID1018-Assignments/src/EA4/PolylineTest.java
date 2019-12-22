package EA4;

public class PolylineTest {

	public static void main(String[] args) {
		Point p1 = new Point("A", 3, 4);
		Point p2 = new Point("B", -2, -1);
		Point p3 = new Point("C", 4, 6);
		Point p4 = new Point("D", -5, 3);
		Point p5 = new Point("E", 7, -1);
		Point p6 = new Point("F", -3, 3);
		Point p7 = new Point("G", -4, -3);
		Point p8 = new Point("H", 2, 0);
		Point p9 = new Point("I", 0, -6);
		Point p10 = new Point("J", -1, -4);
		Point p11 = new Point("K", -8, 6);
		Point p12 = new Point("L", 5, -9);
		Point p13 = new Point("M", -3, 2);

		/*
		 * Testing Polyline
		 */
		Point[] arr1 = { p1, p2, p4, p6, p3 };
		Point[] arr2 = { p11, p2, p9, p7, p13 };
		Point[] arr3 = { p2, p5, p1, p12, p9 };
		Point[] arr4 = { p6, p3, p4, p5, p10 };
		Point[] arr5 = { p9, p8, p3, p12, p11 };
		Point[] arr6 = { p8, p4, p6, p13, p12 };

		// Type Vpolylines
		VPolyline Vpy1 = new VPolyline(arr1);
		VPolyline Vpy2 = new VPolyline(arr2);
		VPolyline Vpy3 = new VPolyline(arr3);
		VPolyline Vpy4 = new VPolyline(arr4);
		VPolyline Vpy5 = new VPolyline(arr5);
		
		Vpy1.setColour("Yellow");
		Vpy2.setColour("Yellow");
		Vpy3.setColour("Yellow");
		
		// Type Npolylines
		Npolyline Npy1 = new Npolyline(arr1);
		Npolyline Npy2 = new Npolyline(arr3);
		Npolyline Npy3 = new Npolyline(arr4);
		Npolyline Npy4 = new Npolyline(arr5);
		Npolyline Npy5 = new Npolyline(arr6);
		
		Npy3.setColour("Yellow");
		Npy4.setColour("Yellow");
		Npy5.setColour("Yellow");
		
		
		// Type Polylines
		Polyline[] VpyA1 = {Vpy1, Vpy2, Vpy3, Vpy4};
		Polyline[] NpyA1 = {Npy3, Npy4, Npy5, Npy2};
		Polyline[] MpyA1 = {Vpy1, Vpy3, Npy4, Npy1};
		
		
//		System.out.println(Npy3);
//		Npy3.insertBefore(p13, "B");
//		System.out.println(Npy3);
		
	//	 Tester
//		System.out.println();
//		System.out.println(Vpy1);
//		System.out.println();
//
//		for (Point x : Vpy1) {
//			System.out.println(x);
//		}
//		
//		System.out.println();
//		System.out.println("Vpy1= " + Vpy1);
//		System.out.println("Length of Vpy1= " + Vpy1.length());
//		System.out.println();
		System.out.println(Npy1);
		System.out.println("Length of Npy1= " + Npy1.length() + "\n");
		Npy1.add(p12);
		System.out.println(Npy1);
		System.out.println("Length of Npy1= " + Npy1.length() + "\n");
		System.out.println("Iterating over Npy1");
		for (Point x : Npy1) 
			System.out.println(x);
		System.out.println("Length of Npy1: " + Npy1.length() + "\n");
		System.out.println();
		System.out.println(Npy1);
		System.out.println("Length of Npy1= " + Npy1.length() + "\n");
		System.out.println("adding before C");
		Npy1.insertBefore(p11, "C");
		System.out.println(Npy1);
		System.out.println("Length of Npy1= " + Npy1.length() + "\n");
		Npy1.remove("C");
		System.out.println(Npy1);
		System.out.println("Length of Npy1= " + Npy1.length() + "\n");
		Npy1.remove("L");
		System.out.println();
		System.out.println("Iterating over Npy1");
		for ( int i = 0; i < Npy1.getVertices().length; i++) {
			System.out.println(Npy1.getVertices()[i]);
		}
		System.out.println("Length of Npy1: " + Npy1.length() + "\n");
		System.out.println();
		System.out.println("Length and colour of Npy3= " + NpyA1[0].length() +", " + NpyA1[0].getColour() + "\n");
		System.out.println("Length and colour of Npy4= " + NpyA1[1].length() +", " + NpyA1[1].getColour() + "\n");
		System.out.println("Length and colour of Npy5= " + NpyA1[2].length() +", " + NpyA1[2].getColour() + "\n");
		System.out.println("Length and colour of Npy2= " + NpyA1[3].length() +", " + NpyA1[3].getColour() + "\n");
		System.out.println(" Shortest yellow polyline in VpyA1 is " + Polylines.FindSmalestYelPol(NpyA1) + "\n with length: " + Polylines.FindSmalestYelPol(NpyA1).length());

		
	}
}