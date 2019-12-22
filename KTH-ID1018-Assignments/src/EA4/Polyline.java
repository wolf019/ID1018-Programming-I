package EA4;
import java.util.*;

	public interface Polyline extends java.lang.Iterable <Point> {
		
		// Abstract method of type Point.
		Point[] getVertices();

		// Abstract method of type String. 
		String getColour();

		// Abstract method of type int.
		int getWidth();

		// Abstract method of type double.
		double length();

		// Abstract method with parameter colour.
		void setColour(String colour);

		// Abstract method with parameter int width.
		void setWidth(int width);

		// Abstract method with parameter Point vertex.
		void add(Point vertex);

		// Abstract method with parameter Point vertex and String vertexName.
		void insertBefore(Point vertex, String vertexName);

		// Abstract method with parameter String vertexName.
		void remove(String vertexName);
		
		// Iterator of type Point.
		Iterator<Point> iterator();

	}


	