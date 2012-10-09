package numbersense.question.multiplication;

import numbersense.model.Category;
import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.model.level.Level48;
import numbersense.utility.Randomizer;
import numbersense.utility.Tweak;

/**
 * @author George Chen
 * @since 8/23/12 9:04 PM
 */
public class MultiplicationBy5  {

	@Override
	public Category getCategory() {
		return Category.MULTIPLICATION_BY_5;
	}

	public static int UPPER_BOUND_LEVEL_0 = 13;
	public static int UPPER_BOUND_LEVEL_16 = 100;
	public static int UPPER_BOUND_LEVEL_32 = 1000;
	public static int UPPER_BOUND_LEVEL_48 = 10000;


	public void visit(Level16 level) {
		initialize(UPPER_BOUND_LEVEL_0, UPPER_BOUND_LEVEL_16);
	}

	public void visit(Level32 level) {
		initialize(UPPER_BOUND_LEVEL_16, UPPER_BOUND_LEVEL_32);
	}

	public void visit(Level48 level) {
		initialize(UPPER_BOUND_LEVEL_32, UPPER_BOUND_LEVEL_48);
	}

	/**
	 * @param lower inclusive
	 * @param upper exclusive
	 */
	protected void initialize(int lower, int upper) {
		left = Randomizer.random(lower, upper);
		left = Tweak.filterMultiplesOf10(left);
		right = 5;
	}


}
