package numbersense.utility;

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

}
