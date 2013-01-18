package numbersense.question.multiplication;

import numbersense.exam.Category;
import numbersense.exam.expression.number.WholeNumber;

/**
 * @author George Chen
 * @since 9/7/12 5:58 PM
 */
public class MultiplicationBy12 extends MultiplicationBy5 {

	@Override
	public Category getCategory() {
		return Category.MULTIPLICATION_BY_12;
	}

	@Override
	protected void initialize(int lower, int upper) {
		super.initialize(lower, upper);
		expression.setRight(new WholeNumber(12));
	}
}
