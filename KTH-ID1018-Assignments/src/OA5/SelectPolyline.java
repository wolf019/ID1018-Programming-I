package OA5;
import java.util.Random;

class SelectPolyline {

	public static final Random rand = new Random();
	public static final int NOF_POLYLINES = 10;

	public static void main(String[] args) {
		int i = 0;
		// Create a random number of polylines
		Polyline[] polylines = new Polyline[NOF_POLYLINES];
		for (i = 0; i < NOF_POLYLINES; i++)
			polylines[i] = randomPolyline();

		// Show the polylines
		for (i = 0; i < NOF_POLYLINES; i++)
			System.out.println(polylines[i]);

		// Determine the shortest yellow polyline
		Polyline shortestYellow = new Polyline();
		i = 0;
		// System.out.println(i);
		while (i < NOF_POLYLINES) {
			// System.out.println(i);
			// System.out.println(shortestYellow);
			if ("yellow" == polylines[i].getColour()) {
				shortestYellow = polylines[i];
				System.out.println(shortestYellow);
				break;
			} else {
				i++;
			}
			if (i == NOF_POLYLINES)
				System.out.println("No yellow polylines found.");
		}
		// System.out.println(i);
		while (i < NOF_POLYLINES) {
			if ("yellow" == polylines[i].getColour() && polylines[i].length() < shortestYellow.length()) {
				// System.out.println(shortestYellow);
				// System.out.println(shortestYellow.length());
				shortestYellow = polylines[i];
				// System.out.println(shortestYellow);
				// System.out.println(shortestYellow.length());
			}
			i++;
		}
		// Show the selected polyline }
		if (i == NOF_POLYLINES && shortestYellow.getColour() != "black") {
			System.out.println();
			System.out.println("Shortest yellow pollyline is: " + shortestYellow + ".");
			System.out.println("It's length: " + shortestYellow.length() + ".");
		} else {
			System.exit(0);
		}

	}

	// The randomPoint method returns a new Point with a name
	// randomly chosen from the single letters A--Z. Coordinates
	// are random.
	public static Point randomPoint() {

		String n = "" + (char) (65 + rand.nextInt(26));
		int x = rand.nextInt(11);
		int y = rand.nextInt(11);

		return new Point(n, x, y);
	}

	// The method randomPolyline returns a random polyline,
	// with a colour either blue, red, or yellow. The names
	// of the vertices are single letters from the set A--Z.
	// Two vertices can not have the same name.
	public static Polyline randomPolyline() {
		// Create an empty polyline and add vertices
		Polyline polyline = new Polyline();
		int nofVertices = 2 + rand.nextInt(7);
		int nofSelectedVertices = 0;
		boolean[] selectedNames = new boolean[26];

		// Two vertices can not have the same name
		Point chosenPoint = null;
		char chosenChar = 0;

		while (nofSelectedVertices < nofVertices) {
			chosenPoint = randomPoint();
			chosenChar = chosenPoint.name.charAt(0);
			if (selectedNames[chosenChar - 65] != true) {
				selectedNames[chosenChar - 65] = true;
				polyline.addLast(chosenPoint);
				nofSelectedVertices++;
			} else {
				continue;
			}
		}
		// Assign a colour }
		polyline.setColour(randomColor());

		return polyline;
	}

	public static String randomColor() {
		int randomInt = rand.nextInt(3);
		String color = "";

		if (randomInt == 0) {
			color = "red";
		} else if (randomInt == 1) {
			color = "blue";
		} else
			color = "yellow";

		return color;
	}

}
