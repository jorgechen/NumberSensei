package numbersense.utility;

/**
 * @author George Chen
 * @since 10/6/12 9:25 AM
 */
public class Convert {

	public static String toString(int number) {
		return number + Constants.EMPTY_STRING;
	}

	public static String toString(float decimal) {
		return decimal + Constants.EMPTY_STRING;
	}

	public static int magnitude(int integer) {
		return Math.abs(integer);
	}
}
