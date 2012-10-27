package numbersense.utility;

/**
 * @author George Chen
 * @since 10/26/12 10:28 PM
 */
public class Utility {
	public static String concatenateWithSpaces(String[] args) {
		StringBuilder builder = new StringBuilder();
		String out;

		if (args.length < 2) {
			for (String a : args) {
				builder.append(a);
			}
		} else {
			for (int i = 0; i < args.length - 1; i++) {
				builder.append(args[i]);
				builder.append(' ');
			}

			builder.append(args[args.length - 1]);
		}

		out = builder.toString();
		return out;
	}

	public static boolean compareFloats(float a, float b) {
		return Math.abs(a - b) < Constants.FLOAT_ERROR_EPSILON;
	}
}
