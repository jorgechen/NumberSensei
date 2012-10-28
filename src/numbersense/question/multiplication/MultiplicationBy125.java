package numbersense.question.multiplication;

import numbersense.exam.Category;
import numbersense.exam.expression.number.WholeNumber;

/**
 * @author George Chen
 * @since 8/25/12 6:23 PM
 */
public class MultiplicationBy125 extends MultiplicationBy5 {
	@Override
	public Category getCategory() {
		return Category.MULTIPLICATION_BY_125;
	}

	@Override
	protected void initialize(int lower, int upper) {
		super.initialize(lower, upper);
		expression.setRight(new WholeNumber(125));
	}
}
