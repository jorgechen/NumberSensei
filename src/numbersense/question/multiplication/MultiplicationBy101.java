package numbersense.question.multiplication;

import numbersense.exam.Category;
import numbersense.exam.expression.number.WholeNumber;

/**
 * @author George Chen
 * @since 9/14/12 8:32 PM
 */
public class MultiplicationBy101 extends MultiplicationBy5 {
	@Override
	public Category getCategory() {
		return Category.MULTIPLICATION_BY_101;
	}

	@Override
	protected void initialize(int lower, int upper) {
		super.initialize(lower, upper);
		expression.setRight(new WholeNumber(101));
	}
}
