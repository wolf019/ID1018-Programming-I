package EA4;

	public class Point {
			
		String name = "";
		private int x;
		private int y;
		
		public Point () {
			x = 0;
			y = 0;	
		}
		
		public Point(String name, int x, int y) {
			this.name = name;
			this.x = x;
			this.y = y;
		}
		
		public Point(Point p) {
			this.name = p.name;
			this.x = p.x;
			this.y = p.y;
		}
		
		public int getX () {
			return x;
		}
		
		public int getY () {
			return y;
		}
		
		public String getName () {
			return this.name;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		
		public void setY(int y) {
			this.y = y;
		}	
		
		public void setName(String name) {
			this.name = name;
		}
		
		public double distanceOrigo() {
			double d = 0;
			d = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
			System.out.println("Distance to origin");
			return d;
		}
		
		public double distanceToPoint(Point p) {
			double d = 0;
			d = Math.sqrt(Math.pow((p.x - this.x), 2) + Math.pow((p.y - this.y), 2));
			return d;
			
		}
		
		public boolean equals(Point q) {
			boolean equals = this.x == q.x && this.y == q.y;
			return equals;	
		}
		
		public String toString() {	
			String s = "";
			s = "(" + name + ", " + x + ", " + y + ")";
			
			return s;
		}
		
	}





















