package OA1;
import java.util.Scanner;
import java.util.Locale;

public class Temperature {


	/* TEMTERATURE
	 * 
	 * This program will help you store temperatures and prints the max, min and
	 * average temperature of each week that is inputed. It also prints the max, min
	 * and avg. of the whole period.
	 * 
	 * Created by -----------------------------------------------------------------
	 * Tom K. Axberg - Assignment OU1 - ID1018 - KTH - 2019 November
	 */

	
	public static void main(String[] args) {

		System.out.println("TEMPERATURES\n");

		// input tools

		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);

		// enter the number of weeks and measurements

		System.out.print("number of weeks: ");
		int nofWeeks = in.nextInt();

		System.out.print("number of measurements per week: ");
		int nofMeasurementsPerWeek = in.nextInt();

		// storage space for temperature data as a matrix

		double[][] t = new double[nofWeeks + 1][nofMeasurementsPerWeek + 1];

		// print out measurements per week

		for (int week = 1; week <= nofWeeks; week++) {
			System.out.println("temperatures - week " + week + ":");

			for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++)
				t[week][reading] = in.nextDouble();
		}

		System.out.println();

		// show the temperatures
		System.out.println("the temperatures:");

		for (int week = 1; week <= nofWeeks; week++) {
			for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++)
				System.out.print(t[week][reading] + " ");
			System.out.println();
		}
		System.out.println();

		// the least, greatest and average temperature as arrays - weekly

		double[] minT = new double[nofWeeks + 1];
		double[] maxT = new double[nofWeeks + 1];
		double[] sumT = new double[nofWeeks + 1];
		double[] avgT = new double[nofWeeks + 1];

		/*
		 * the computation and storage of the least, greatest and average temperature
		 * for each week.
		 */

		for (int week = 1; week <= nofWeeks; week++) {

			minT[week] = t[week][1];
			maxT[week] = t[week][1];
			sumT[week] = t[week][1];

			for (int reading = 2; reading <= nofMeasurementsPerWeek; reading++) {

				if (t[week][reading] < minT[week]) {
					minT[week] = t[week][reading];
				}

				if (t[week][reading] > minT[week]) {
					maxT[week] = t[week][reading];
				}

				sumT[week] += t[week][reading];

				avgT[week] = sumT[week] / reading;

			}

		}

		/*
		 * show the least, greatest and greatest and average each week
		 */

		for (int week = 1; week <= nofWeeks; week++)
			System.out.println(
					"For week " + week + " minT: " + minT[week] + " maxT: " + maxT[week] + " avgT: " + avgT[week]);

		// the least, greatest and average temperature for the whole period

		double minTemp = minT[1];
		double maxTemp = maxT[1];
		double sumTemp = sumT[1];
		double avgTemp = 0;

		/*
		 * the computation and storage of least, greatest and average temperature for
		 * the whole period
		 */

		for (int i = 2; i <= nofWeeks; i++) {

			if (minTemp > minT[i])
				minTemp = minT[i];

			if (maxTemp < maxT[i])
				maxTemp = maxT[i];

			sumTemp += sumT[i];
			avgTemp = sumTemp / (nofWeeks * nofMeasurementsPerWeek);

		}

		System.out.println();
		System.out.println("For the whole period we have minT: " + minTemp + " maxT: " + maxTemp + " avgT: " + avgTemp);

	}
}
