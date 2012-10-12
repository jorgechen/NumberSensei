package numbersense.utility;


import numbersense.model.expression.number.Fraction;

/**
 * @author George Chen
 * @since 9/28/12 9:36 PM
 */
public class Tweak {
	/**
	 * Filter easy multiplicands and make them harder.
	 */
	public static int filterMultiplesOf10(int number) {
		for (int i = 10; i < 10000; i *= 10) {
			if (number <= i * 10 && number % i == 0) {
				number += Randomizer.random(i);
				break;
			}
		}

		return number;
	}


	public static boolean simplify(Fraction f) {
		int limit = Math.min(f.getNumerator(), f.getDenominator()) / 2;

		int greatestCommonDenominator = euclid(f.getNumerator(), f.getDenominator());

		for (int i = 2; i < limit; i++) {

		}

		//TODO
		return false;
	}

	public static int euclid(int a, int b) {
		int max = a, min = b;
		if (a < b) {
			max = b;
			min = a;
		}
		if (max % min == 0) {
			return max;
		} else {
			return euclid(max, min);
		}
	}

}
