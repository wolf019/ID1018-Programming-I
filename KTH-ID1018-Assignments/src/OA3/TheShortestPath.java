package OA3;
import java.util.Locale;
import java.util.Scanner;

class TheShortestPath {

	/**
	 * THE SHORTEST PATH
	 * 
	 * This class has one method that calculates all the distances between all zones
	 * and returns the the minimum distance. Then it stores the stations in a array.
	 * 
	 * The second method calculates the minimum distance by calling the
	 * intermediateStations method and then uses the stations to get the minimum
	 * distances.
	 * 
	 * And the rest creates arrays and tells the user type in distances in km.
	 * 
	 * Created by -----------------------------------------------------------------
	 * Tom K. Axberg - Assignment OU3 - ID1018 - KTH - 2019 November
	 */

	public static int[] intermediateStations(double[] ai, double[][] bij, double[] cj) {

		int[] s = { 0, 1, 1 };
		double mindist = ai[1] + bij[1][1] + cj[1];

		for (int i = 1; i < ai.length; i++) {
			for (int j = 1; j < cj.length; j++) {

				double actuellmind = ai[i] + bij[i][j] + cj[j];

				if (mindist > actuellmind) {
					mindist = actuellmind;
					s[1] = i;
					s[2] = j;

				}

			}

		}

		return s;
	}

	public static double lengthInterStat(double[] ai, double[][] bij, double[] cj) {
		int[] s = intermediateStations(ai, bij, cj);
		double length = ai[s[1]] + bij[s[1]][s[2]] + cj[s[2]];
		System.out.println("Minimum distance is " + length + "km");
		return length;

	}

	public static double[] zoneOneTooTwo(int m, int n) {

		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);

		double[] ai = new double[m + 1];

		for (int i = 1; i <= m; i++) {
			System.out.println("Distance betwen the first station and U" + i + " in km: ");
			ai[i] = in.nextDouble();
			if (ai[i] >= 0) {
				continue;
			} else {
				throw new IllegalArgumentException("Invalid input. Please restart program.");
			}

		}
		return ai;
		
	}

	// New arrays for storing distance
	public static double[][] zoneTwoTooThree(int m, int n) {

		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);

		double[][] bij = new double[m + 1][n + 1];

		// input distance between z2 - z3
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.println("Distance betwen U" + i + " and V" + j + " in km: ");
				bij[i][j] = in.nextDouble();
				if (bij[i][j] >= 0) {
					continue;
				} else {
					throw new IllegalArgumentException("Invalid input. Please restart program.");
				}
			}
		}
		return bij;
	}

	// input distance between z3 - z4
	public static double[] zoneThreeTooFour(int m, int n) {

		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
		double[] cj = new double[n + 1];

		for (int j = 1; j <= n; j++) {
			System.out.println("Distance betwen V" + j + " and the end station in km: ");
			cj[j] = in.nextDouble();
			if (cj[j] >= 0) {
				continue;
			} else {
				throw new IllegalArgumentException("Invalid input. Please restart program.");
			}

		}
		return cj;
	}
}