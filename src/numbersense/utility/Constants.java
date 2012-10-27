package numbersense.utility;

/**
 * @author George Chen
 * @since 9/28/12 9:32 PM
 */
public class Constants {

	///////////////////////////////////////////////////////////////////////
	// Strings
	///////////////////////////////////////////////////////////////////////

	public static final String UNDERSCORES = "_____________________________________________________________" +
											 "_____________________________________________________________";

	public static final String SIGN_MULTIPLY = "x";
	public static final String SIGN_DIVIDE = "/";
	public static final String SIGN_ADD = "+";
	public static final String SIGN_SUBTRACT = "-";

	public static final String LEFT_PARENTHESIS = "(";
	public static final String RIGHT_PARENTHESIS = ")";

	public static final String SIGN_POWER = "^";

	public static final String SPACE = " ";
	public static final String SIGN_EQUAL = "=";
	public static final String EMPTY_STRING = "";


	public final class Roman {
		public static final String ONE = "I";
		public static final String FIVE = "V";
		public static final String TEN = "X";
		public static final String FIFTY = "L";
		public static final String HUNDRED = "C";
		public static final String FIVE_HUNDRED = "D";
		public static final String THOUSAND = "M";
	}



	///////////////////////////////////////////////////////////////////////
	// Numbers
	///////////////////////////////////////////////////////////////////////

	final public static double FLOAT_ERROR_EPSILON = 0.0001;
	final public static double ERROR_DEVIATION = 0.05;
	final public static int ZERO = 0;

}
