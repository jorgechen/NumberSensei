package numbersense.exam;

/**
 * @author George Chen
 * @since 8/5/12 8:25 PM
 */

public enum Category {
	NOT_A_TRICK,
	BASE_CONVERSION,
	DIVISIBILITY,
	PRIME_NUMBER,
	ROMAN_NUMERAL,
	ARABIC_TO_ROMAN,
	ORDER_OF_OPERATION,
	EXPONENTIAL,
	SQUARE,
	CUBE,
	MULTIPLICATION,
	MULTIPLICATION_FOIL,
	MULTIPLICATION_ALMOST_100,
	MULTIPLICATION_BY_11,
	MULTIPLICATION_BY_101,
	MULTIPLICATION_BY_5,
	MULTIPLICATION_BY_50,
	MULTIPLICATION_BY_25,
	MULTIPLICATION_BY_125;

	public Category convertFrom(String s) {
		Category e = NOT_A_TRICK;
		if (s == null || s.length() == 0) {

		} else if (s.equalsIgnoreCase("MultiplicationBy5")) {
			e = MULTIPLICATION_BY_5;
		} else if (s.equalsIgnoreCase("MultiplicationBy50")) {
			e = MULTIPLICATION_BY_50;
		} else if (s.equalsIgnoreCase("MultiplicationBy25")) {
			e = MULTIPLICATION_BY_25;
		} else if (s.equalsIgnoreCase("MultiplicationBy125")) {
			e = MULTIPLICATION_BY_125;
		} else if (s.equalsIgnoreCase("Square")) {
			e = SQUARE;
		} else if (s.equalsIgnoreCase("Cube")) {
			e = CUBE;
		}

		return e;
	}
}
