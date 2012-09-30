package numbersense.utility;

import java.util.Random;

/**
 * @author George Chen
 * @since 8/11/12 1:39 PM
 */
public class Randomizer {
	private static final Random INSTANCE = new Random();

	/**
	 * @param lower inclusive
	 * @param upper exclusive
	 * @return random number between lower bound, inclusive, and upper bound, exclusive
	 */
	public static int random(int lower, int upper) {
		return Randomizer.INSTANCE.nextInt(upper - lower) + lower;
	}

	/**
	 * @param upper exclusive
	 * @return random number between 0, inclusive, and upper, exclusive
	 */
	public static int random(int upper) {
		return INSTANCE.nextInt(upper);
	}

	/**
	 * @param n inclusive
	 * @return random number between 1, inclusive, and n, inclusive
	 */
	public static int random1toN(int n) {
		return INSTANCE.nextInt(n) + 1;
	}

	/**
	 * @return true for heads, false for tails, or vice versa
	 */
	public static boolean coinFlip() {
		return INSTANCE.nextInt(1) == 0;
	}
}
