package OA5;


import java.io.*; // PrintWriter
	
	class PointTest {
		public static void main (String[] args) {
			
		
			PrintWriter out = new PrintWriter (System.out, true);
			
			// testing constructor and a transformer 
			Point p1 = new Point ("A", 3, 4); 
			Point p2 = new Point ("B", -2, -1);
			Point p3 = new Point ("C", 4, 7);
			Point p4 = new Point ("D", -5, 3);
			Point p5 = new Point ("E", 3, -1);
			
			out.println (p1 + "  " + p2);
			
			// testing inspectors
			String n = p1.getName();
			int x = p1.getX();
			int y = p1.getY();
			out.println (n + " " + x + " " + y);
			
			// testing combiner and comparator 
			double d1 = p1.distance(p2); 
			double d2 = p2.distance(p3); 
			double d3 = p3.distance(p4); 
			double d4 = p4.distance(p5);  
			out.println (d1 + d2 + d3 + d4);
			boolean b = p1.equals(p2); 
			out.println (b);
			// testing mutators 
			p2.setX (1); 
			p2.setY (2); 
			out.println(p2);
			// testing another constructor 
			Point p = new Point (p1); 
			out.println (p); 
			
			
			
			
			
			
			

			
	}
}