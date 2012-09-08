package numbersense.model.question.exponential;

import numbersense.model.Category;
import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.model.level.Level48;
import numbersense.util.Utility;

/**
 * @author George Chen
 * @since 12/18/11 6:11 PM
 */
public class Square extends Exponential {

	protected void initialize(int upperBound) {
		base = Utility.RNG.nextInt(upperBound) + 1;
		exponent = 2;
		solution = base * base;
	}

	@Override
	public Category getCategory() {
		return Category.SQUARE;
	}

	public static int UPPER_BOUND_LEVEL_16 = 15;
	public static int UPPER_BOUND_LEVEL_32 = 25;
	public static int UPPER_BOUND_LEVEL_48 = 32;

	public void visit(Level16 level) {
		initialize(UPPER_BOUND_LEVEL_16);
	}

	public void visit(Level32 level) {
		initialize(UPPER_BOUND_LEVEL_32);
	}

	public void visit(Level48 level) {
		initialize(UPPER_BOUND_LEVEL_48);
	}
}
