package OA4;
import java.util.*; // Scanner 
import static java.lang.System.out;
import java.lang.Integer;

/* OPERATIONS
* 
* In this program you will be asked to input two strings of natural integers.
* The program will then add and subtract them. The result will be printed in a
* satisfied form.
* 
* Created by -----------------------------------------------------------------
* Tom K. Axberg - Assignment OU4 - ID1018 - KTH - 2019 November
*/

class OperationsWithNaturalNumbersGivenAsStrings {

	public static void main(String[] args) {

		out.println("OPERATIONS ON NATURAL NUMBERS " + "IN CHARACTER STRINGS");

		// enter two natural numbers
		Scanner in = new Scanner(System.in);
		out.println("two natural numbers:");

		String tal1 = in.next();
		String tal2 = in.next();

		out.println();

		// add the numbers and show the result
		String sum = add(tal1, tal2);
		show(tal1, tal2, sum, '+');
		// subtract the numbers and show the result

		String subsum = subtract(tal1, tal2);
		show(tal1, tal2, subsum, '-');
	}

	// The add method accepts two natural numbers represented // as character
	// strings and returns their sum as a
	// character string.
	public static String add(String num1, String num2) {

		StringBuilder tal = new StringBuilder("");
		int a = num1.length() - 1;
		int b = num2.length() - 1;
		int aktuell1 = 0;
		int aktuell2 = 0;
		int taltillstb = 0;
		int minnessiffra = 0;
		int sum = 0;

		while (a >= 0 && b >= 0) {
			aktuell1 = num1.charAt(a) - 48;
			aktuell2 = num2.charAt(b) - 48;
			sum = minnessiffra + aktuell1 + aktuell2;
			minnessiffra = sum / 10;
			taltillstb = sum % 10;
			tal.insert(0, taltillstb);
			a--;
			b--;
		}
		while (a >= 0) {
			aktuell1 = num1.charAt(a) - 48;
			sum = minnessiffra + aktuell1;
			minnessiffra = sum / 10;
			taltillstb = sum % 10;
			tal.insert(0, taltillstb);
			a--;
		}

		while (b >= 0) {
			aktuell2 = num2.charAt(b) - 48;
			sum = minnessiffra + aktuell2;
			minnessiffra = sum / 10;
			taltillstb = sum % 10;
			tal.insert(0, taltillstb);
			b--;
		}

		if (minnessiffra > 0)
			tal.insert(0, minnessiffra);

		return tal.toString();

	}

	// The subtract method accepts two natural numbers
	// represented as character strings and returns their
	// difference as a character string.
	// The first number is not smaller than the second
	public static String subtract(String num1, String num2) {

		StringBuilder tall = new StringBuilder("");
		int tal1 = Integer.parseInt(num1);
		int tal2 = Integer.parseInt(num2);
		int a = num1.length() - 1;
		int b = num2.length() - 1;
		int aktuell1 = 0;
		int aktuell2 = 0;
		int minnessiffra = 0;
		int diff = 0;

		if (tal1 >= tal2) {
			while (a >= 0 && b >= 0) {
				aktuell1 = num1.charAt(a) - 48 - minnessiffra;
				aktuell2 = num2.charAt(b) - 48;
				if (aktuell1 >= aktuell2) {
					diff = aktuell1 - aktuell2;
					minnessiffra = 0;
					
				} else {
					
					diff = (aktuell1 + 10) - aktuell2;
					minnessiffra = 1;

				}
				a--;
				b--;
				tall.append(diff);
			}
			while (a >= 0) {
				aktuell1 = num1.charAt(a) - 48 - minnessiffra;
				if (aktuell1 >= 0) {
					minnessiffra = 0;
					diff = aktuell1;
					
				} else {
					
					diff = (aktuell1 + 10);
					minnessiffra = 1;
				}
				tall.append(diff);
				a--;
			
			}
			tall.reverse();
			return tall.toString();

		} else {

			while (a >= 0 && b >= 0) {
				aktuell1 = num2.charAt(b) - 48 - minnessiffra;
				aktuell2 = num1.charAt(a) - 48;
				if (aktuell1 >= aktuell2) {
					diff = aktuell1 - aktuell2;
					minnessiffra = 0;
				} else {
					diff = (aktuell1 + 10) - aktuell2;
					minnessiffra = 1;

				}
				a--;
				b--;
				tall.append(diff);

			}

			while (b >= 0) {
				aktuell1 = num2.charAt(b) - 48 - minnessiffra;
				tall.append(aktuell1);
				b--;
			}

			tall.reverse();
			tall.insert(0, '-');
			return tall.toString();

		}
	}

	// The show method presents two natural numbers, an
	// operator and the result string.

	public static void show(String num1, String num2, String result, char operator) {

		// Set an appropriate length on numbers and result
		int len1 = num1.length();
		int len2 = num2.length();
		int len = result.length();
		int maxLen = Math.max(Math.max(len1, len2), len);
		num1 = setLen(num1, maxLen - len1);
		num2 = setLen(num2, maxLen - len2);
		result = setLen(result, maxLen - len);

		// show the expression
		out.println("  " + num1);
		out.println("" + operator + " " + num2);
		for (int i = 0; i < maxLen + 2; i++)
			out.print("-");
		out.println();
		out.println("  " + result + "\n");
	}

	// The setLen method prepends the supplied number of
	// spaces ato the beginning of a string
	public static String setLen(String s, int nofSpaces) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < nofSpaces; i++)
			sb.insert(0, " ");
		return sb.toString();

	}

}
