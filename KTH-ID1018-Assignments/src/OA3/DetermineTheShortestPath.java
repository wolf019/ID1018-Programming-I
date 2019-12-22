package OA3;
import java.util.Locale;
import java.util.Scanner;

public class DetermineTheShortestPath {

	public static void main(String[] args) {

		/*
		 * MINIMUM DISTANCE EXE
		 * 
		 * This Method is to input the number of stations in zone 2 and 3. It also
		 * executes the program.
		 * 
		 * Created by -----------------------------------------------------------------
		 * Tom K. Axberg - Assignment OU3 - ID1018 - KTH - 2019 November
		 */

		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
		
		System.out.println("From first station to the end station there is two stops to be made. \n"
				+ "The first stop is to be made at one of the U-station. The secont at a V-station.\n"
				+ "To calculate the shortest route:\n");

		System.out.println("Please type in the number of U-stations: ");
		int m = in.nextInt();
		System.out.println("Please type in the number of V-stations: ");
		int n = in.nextInt();
		System.out.println();

		double ai[] = TheShortestPath.zoneOneTooTwo(m, n);
		double bij[][] = TheShortestPath.zoneTwoTooThree(m, n);
		double cj[] = TheShortestPath.zoneThreeTooFour(m, n);

		System.out.println();

		TheShortestPath.lengthInterStat(ai, bij, cj);

		System.out.println();

		int s[] = TheShortestPath.intermediateStations(ai, bij, cj);

		System.out.println("Goes through U" + s[1] + ",  V" + s[2] + ".");

	}

}
