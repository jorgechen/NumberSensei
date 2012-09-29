package numbersense.utility;

/**
 *
 * @author George Chen
 * @since 12/19/11 3:29 PM
 */
public final class TypeCheck {
	public static boolean isDecimal(String s) {
		try {
			Double.parseDouble(s);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}

}
