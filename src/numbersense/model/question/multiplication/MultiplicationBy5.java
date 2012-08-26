package numbersense.model.question.multiplication;

import numbersense.model.Category;
import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.model.level.Level48;
import numbersense.util.Utility;

/**
 * @author George Chen
 * @since 8/23/12 9:04 PM
 */
public class MultiplicationBy5 extends Multiplication {


	@Override
	public Category getCategory() {
		return Category.MULTIPLICATION_BY_5;
	}

	public static int UPPER_BOUND_LEVEL_0 = 13;
	public static int UPPER_BOUND_LEVEL_16 = 100;
	public static int UPPER_BOUND_LEVEL_32 = 1000;
	public static int UPPER_BOUND_LEVEL_48 = 10000;

	/**
	 * @param lower inclusive
	 * @param upper exclusive
	 */
	protected void initialize(int lower, int upper) {
		b = 5;
		a = Utility.RNG.nextInt(upper - lower) + lower;
	}

	/**
	 * Filter easy multiplicands and make them harder.
	 */
	protected void filterEasies() {
		for (int i = 10; i < 10000; i *= 10) {
			if (a <= i * 10 && a % i == 0) {
				a += Utility.RNG.nextInt(i);
				break;
			}
		}
	}

	public void visit(Level16 level) {
		initialize(UPPER_BOUND_LEVEL_0, UPPER_BOUND_LEVEL_16);
	}

	public void visit(Level32 level) {
		initialize(UPPER_BOUND_LEVEL_16, UPPER_BOUND_LEVEL_32);
	}

	public void visit(Level48 level) {
		initialize(UPPER_BOUND_LEVEL_32, UPPER_BOUND_LEVEL_48);
	}
}
