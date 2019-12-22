package EA4;
import java.util.Iterator;

public class Npolyline implements Polyline {

	private static class Node {
		public Point vertex;
		public Node nextNode;

		public Node(Point vertex) {
			this.vertex = vertex;
			nextNode = null;
		}
	}

	private Node vertices; // <---------------------- Denna pekar på den första noden i serien
	private String colour = "black";
	private int width = 1; // pixels

	public Npolyline() {
		this.vertices = null;
	}

	/**
	 * Constructor to Npolyline
	 * 
	 * @param vertices
	 */
	public Npolyline(Point[] vertices) {
		if (vertices.length > 0) { // Because this four lines only
			Node node = new Node(new Point(vertices[0])); // executes one time when the
			this.vertices = node; // <---------------------------------- Här
			int pos = 1; // compiler run.
			while (pos < vertices.length) { // Here's where the
				node.nextNode = new Node(new Point(vertices[pos++])); // rest of the nodes
				node = node.nextNode; // is added to the LL.
			}
		}
	}

	/**
	 * Here I want to implement a toString method. - Check!
	 */
	public String toString() {
		StringBuilder points = new StringBuilder();
		Node Noden = this.vertices;
		while (Noden != null) {
			points.append(Noden.vertex);
			Noden = Noden.nextNode;
		}

		return "{[" + points + "], " + colour + ", " + width + "}";
	}

	@Override
	public Point[] getVertices() {
		Node Noden = this.vertices;
		Point[] verticeses = null;
		int curr = 0;
		while (Noden != null) {
			verticeses = new Point[curr + 1];
			verticeses[curr] = Noden.vertex;
			curr++;
			Noden = Noden.nextNode;
		}

		Noden = this.vertices;

		for (int j = 0; j < curr; j++) {
			while (Noden.nextNode != null) {
				verticeses[j] = Noden.vertex;
				Noden = Noden.nextNode;
				j++;
			}
		}
		return verticeses;
	}

	@Override
	public String getColour() {
		return this.colour;
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public double length() {

		double length = 0;
		Node nextNoden = this.vertices.nextNode;

		if (this.vertices.vertex != null) {
			length = this.vertices.vertex.distanceToPoint(nextNoden.vertex);

		}
		while (nextNoden.nextNode != null) {
			length += (nextNoden.vertex).distanceToPoint(nextNoden.nextNode.vertex);
			nextNoden = nextNoden.nextNode;
		}

		return length;
	}

	@Override
	public void setColour(String colour) {
		this.colour = colour;

	}

	@Override
	public void setWidth(int width) {
		this.width = width;

	}

	@Override
	public void add(Point vertex) {
		Node newNode = new Node(vertex);
		Node curNode = vertices;

		if (vertices == null)
			vertices = newNode;
		else {
			while (curNode.nextNode != null) {
				// System.out.println(curNode.vertex);
				// System.out.println(nIterator.hasNext());
				curNode = curNode.nextNode;
			}
			curNode.nextNode = newNode;
		}
	}

	@Override
	public void insertBefore(Point vertex, String vertexName) {
		
		Node newNoden = new Node(vertex);

		if (vertices == null)
			vertices = newNoden;

		else {
			Node curNoden = vertices;

			while (curNoden != null) {
				if (curNoden.nextNode.vertex.getName().equals(vertexName)) {
					newNoden.nextNode = curNoden.nextNode;
					curNoden.nextNode = newNoden;
					break;
				} else
					curNoden = curNoden.nextNode;
			}
		}
	}

	@Override
	public void remove(String vertexName) {
		Node current = vertices;

		while (current != null) {
			if (current.nextNode.vertex.getName() == vertexName) {
				current.nextNode = current.nextNode.nextNode;
				break;

			} else
				current = current.nextNode;
		}
	}

	public class NPolylineIterator implements Iterator<Point> {

		private Node current;

		public NPolylineIterator() {
			current = vertices;
		}

		public boolean hasNext() {
			return current != null;
		}

		public Point next() {
			Point point = current.vertex;
			if (current != null)
				current = current.nextNode;
			return point;

		}

	}

	@Override
	public Iterator<Point> iterator() {
		return new NPolylineIterator();
	}

}