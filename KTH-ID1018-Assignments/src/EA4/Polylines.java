package EA4;

public class Polylines {

	public static Polyline FindSmalestYelPol(Polyline[] Polyline) {

		Polyline shortestYellow = null;
		double shortestYellowl = 0;

		for (Polyline x : Polyline) {
			if (x.getColour().equals("Yellow") && shortestYellow == null) {
				shortestYellowl = x.length();
				shortestYellow = x;
			} else if (x.getColour().equals("Yellow") && x.length() < shortestYellowl) {
				shortestYellowl = x.length();
				shortestYellow = x;
			}
		}
		return shortestYellow;

	}
}
