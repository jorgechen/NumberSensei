package numbersense.question.multiplication;

import numbersense.model.Category;
import numbersense.model.expression.number.WholeNumber;

/**
 * @author George Chen
 * @since 9/7/12 5:58 PM
 */
public class MultiplicationBy11 extends MultiplicationBy5 {

	@Override
	public Category getCategory() {
		return Category.MULTIPLICATION_BY_11;
	}

	@Override
	protected void initialize(int lower, int upper) {
		super.initialize(lower, upper);
		expression.setRight(new WholeNumber(11));
	}
}
