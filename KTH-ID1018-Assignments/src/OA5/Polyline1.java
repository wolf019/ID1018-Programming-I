package OA5;

public class Polyline1 {
	private Point[] vertices;
	private String colour = "black";
	private int width = 1;
	
	// Assigns origin to the first element of the vertices array.
	public Polyline1() {
		this.vertices = new Point[0];
	} 
	// Method takes an array Point of type point and assigns the
	// private arrays "vertices" elements to "Point"'s elements.
	public Polyline1(Point[] vertices) {
		this.vertices = vertices;
	}

	// Returns relevant information about the vertices array and it's properties.
	public String toString() {
		StringBuilder points = new StringBuilder();
		for (int i = 0; i < vertices.length; i++)
			points.append(vertices[i]);

		return "{[" + points + "], " + colour + ", " + width;
	}

	// Returns vertices reference.
	public Point[] getVertices() {
		return vertices;
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
		
		for (int i = 0; i < vertices.length;) {
			length += vertices[i].distance(vertices[i + 1]);
			i += 2;
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

	// Adds the @param given vertex in front of the specified vertex @param vertexName in the
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
		h[cur] = vertex;

		// Adding the rest of the vertices to the new h array.
		int j = cur - 1;
		for (j = cur - 1; j >= 0; j--) {
			h[j] = this.vertices[j];
		}

		this.vertices = h;
	}

	// Romoves the the vertex @param vertexName from the polyline.
	public void remove(String vertexName) {

	}
}
