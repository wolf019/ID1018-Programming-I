package EA4;
import java.util.*;

public class VPolyline implements Polyline {

	private Point[] vertices;
	private String color = "black";
	private int width = 1;
	public double length;

	@Override
	public Iterator<Point> iterator() {
		VPolylineIterator VPI = new VPolylineIterator();
		return VPI;
	}

	public class VPolylineIterator implements Iterator<Point> {

		public int current = -1;

		public VPolylineIterator() {
			if (vertices.length > 0)
				current = 0;
		}

		public Point next() {

			Point vertex = vertices[current];
			if (!hasNext())
				throw new java.util.NoSuchElementException();
			else
				current++;

			return vertex;

		}

		public boolean hasNext() {
			boolean hasNext;
			if (current != vertices.length)
				hasNext = true;
			else
				hasNext = false;
			
			//System.out.println(hasNext);
			return hasNext;
		}

	}

	/**
	 * Constructor
	 */
	public VPolyline() {
		this.vertices = new Point[0];
	}

	/**
	 * Constructor
	 * 
	 * @param vertices of type Point are given in an array.
	 */
	public VPolyline(Point[] vertices) {

		this.vertices = new Point[vertices.length];
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i] = new Point(vertices[i]);
	}

	/**
	 * ToString method that creates a StringBuilder and appens verseces to it.
	 */
	public String toString() {
		StringBuilder points = new StringBuilder();
		for (int i = 0; i < vertices.length; i++)
			points.append(vertices[i]);

		return "{[" + points + "], " + color + ", " + width + "}";
	}

	/**
	 * Returns a Point array with the points in the polyline.
	 */
	public Point[] getVertices() {
		Point[] h = new Point[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			h[i] = new Point(vertices[i]);
		}
		return h;
	}

	// Returns the color of the vertices array.
	public String getColour() {
		return color;
	}

	// Returns the width
	public int getWidth() {
		return width;
	}

	// Sets the color on polyline
	public void setColour(String colour) {
		this.color = colour;
	}

	// Sets the width on polyline
	public void setWidth(int width) {
		this.width = width;
	}

	// Gives the length on polyline
	public double length() {

		double length = 0;

		for (int i = 0; i < vertices.length - 1;) {
			length += vertices[i].distanceToPoint(vertices[i + 1]);
			i++;
		}
		return length;
	}

	@Override
	public void add(Point vertex) {
		Point[] h = new Point[this.vertices.length + 1];

		int i = 0;
		for (i = 0; i < this.vertices.length; i++)
			h[i] = this.vertices[i];
		h[i] = new Point(vertex);

		this.vertices = h;

	}

	@Override
	public void insertBefore(Point vertex, String vertexName) {
		if (vertexName == "")
			throw new IllegalArgumentException("vertexName gives no information.");

		Point[] h = new Point[this.vertices.length + 1];

		int first = 0;
		int last = h.length - 1;
		int cur = first;

		// Searching for vertexName and sets cur to the matching element index.
		while (cur <= last && vertexName != vertices[cur].name) {
			cur++;
			if (cur == last)
				throw new IllegalArgumentException(
						"vertexName does not exist in given polyline. Hint: Use addLast method.");
		}
		// Adding vertices from the vertices array to new Point array h from the back.
		for (int i = h.length - 1; i > cur; i--) {
			h[i] = this.vertices[i - 1];
		}
		// Adding the vertex input in the matching index place in h.
		h[cur] = new Point(vertex);

		// Adding the rest of the vertices to the new h array.
		for (int j = cur - 1; j >= 0; j--) {
			h[j] = this.vertices[j];
		}

		this.vertices = h;

	}

	@Override
	public void remove(String vertexName) {
		if (vertexName == "")
			throw new IllegalArgumentException("vertexName gives no information.");

		Point[] h = new Point[this.vertices.length - 1];

		int first = 0;
		int last = h.length - 1;
		int cur = first;

		// Searching for vertexName and sets cur to the matching element index.
		while (cur <= last && vertexName != vertices[cur].name) {
			cur++;
		}
		// Adding vertices from the vertices array to new Point array h from the back.
		for (int i = h.length - 1; i >= cur; i--) {
			h[i] = this.vertices[i + 1];
		}
		// Adding the rest of the vertices to the new h array after jumping over the cur
		// element.
		for (int j = cur - 1; j >= 0; j--) {
			h[j] = this.vertices[j];
		}

		this.vertices = h;

	}

}