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

	@Override
	protected void initialize(int lower, int upper) {
		super.initialize(lower, upper);
		b = 5;
	}


}
