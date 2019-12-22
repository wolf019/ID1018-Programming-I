package OA5;

import java.io.PrintWriter;

public class PolylineTest {

	public static void main(String[] args) {

		PrintWriter out = new PrintWriter(System.out, true);

		// test a constructor and a transformer
		Point p1 = new Point("A", 3, 4);
		Point p2 = new Point("B", -2, -1);
		Point p3 = new Point("C", 4, 6);
		Point p4 = new Point("D", -5, 3);
		Point p5 = new Point("E", 3, -1);

		/*
		 * Testing Polyline
		 */
		Point[] arr = { p1, p2, p3, p4, p5 };

		Polyline py1 = new Polyline(arr);

		// Print length
		out.println("Polyline py1:");
		out.println(py1);
		out.println();
		out.println(py1);
		out.println("Length:");
		out.println(py1.length() + " cm");

		// Adds Point p5 before point 'B' and prints the length..
		out.println();
		out.println("Adds E before B:");
		py1.addBefore(p5, "B");
		out.println(py1);
		out.println("Length:");
		out.println(py1.length() + " cm");

		// Polyline print iterator.
		out.println();
		out.println("Prints the iteration of py1: ");
		Polyline.PolylineIterator PyIt1 = py1.new PolylineIterator();
		while (PyIt1.hasVertex()) {
			out.println(PyIt1.vertex());
			PyIt1.advance();
		}

		// Creates randomPolyline and prints it, it's length and iterates its vertices
		// and prints them.
		out.println();
		out.println("Creates random polyline P"
				+ "pyIt1 and prints it: ");
		Polyline sd = SelectPolyline.randomPolyline();
		Polyline.PolylineIterator pyIt2 = sd.new PolylineIterator();
		out.println(sd);
		out.println("Length:");
		out.println(sd.length());
		out.println();
		out.println("Iteration of pyIt1: ");
		while (pyIt2.hasVertex()) {
			out.println(pyIt2.vertex());
			pyIt2.advance();
		}

	}
}
