package OA5;
public class Polyline {

	private Point[] vertices;
	private String colour = "black";
	private int width = 1;
	public double length;

	// Assigns origin to the first element of the vertices array.
	public Polyline() {
		this.vertices = new Point[0];
	} // Method takes an array Point of type point and assigns the
		// private arrays "vertices" elements to "Point"'s elements.

	public Polyline(Point[] vertices) {

		this.vertices = new Point[vertices.length];
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i] = new Point(vertices[i]);
	}

	// Returns relevant information about the vertices array and it's properties.
	public String toString() {
		StringBuilder points = new StringBuilder();
		for (int i = 0; i < vertices.length; i++)
			points.append(vertices[i]);

		return "{[" + points + "], " + colour + ", " + width + "}";
	}

	// Returns the vertices array.
	public Point[] getVertices() {
		Point[] h = new Point[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			h[i] = new Point(vertices[i]);
		}
		return h;
	}

	// Returns the color of the vertices array.
	public String getColour() {
		return colour;
	}

	// Returns the width
	public int getWidth() {
		return width;
	}

	// Sets the color on polyline
	public void setColour(String colour) {
		this.colour = colour;
	}

	// Sets the width on polyline
	public void setWidth(int width) {
		this.width = width;
	}

	// Gives the length on polyline
	public double length() {

		double length = 0;

		for (int i = 0; i < vertices.length - 1;) {
			length += vertices[i].distance(vertices[i + 1]);
			i++;
		}
		return length;
	}

	// Adds the given @param vertex to the end of the polyline
	public void addLast(Point vertex) {

		Point[] h = new Point[this.vertices.length + 1];

		int i = 0;
		for (i = 0; i < this.vertices.length; i++)
			h[i] = this.vertices[i];
		h[i] = new Point(vertex);

		this.vertices = h;
	}

	// Adds the @param given vertex in front of the specified vertex @param
	// vertexName in the
	// polyline.
	public void addBefore(Point vertex, String vertexName) {

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

	// Romoves the the vertex @param vertexName from the polyline.
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

	public class PolylineIterator {

		private int current = -1;

		public PolylineIterator() {
			if (Polyline.this.vertices.length > 0)
				current = 0;
		}

		public boolean hasVertex() {
			return current != -1;
		}

		public Point vertex() throws java.util.NoSuchElementException {

			if (!this.hasVertex())
				throw new java.util.NoSuchElementException();

			Point vertex = Polyline.this.vertices[current];

			return vertex;
		}

		public void advance() {
			if (current >= 0 && current < Polyline.this.vertices.length - 1) {
				current++;
				}
			else
				current = -1;
		}
	}

}