package numbersense.model.question.multiplication;

import numbersense.model.Category;

/**
 * @author George Chen
 * @since 9/7/12 5:58 PM
 */
public class MultiplicationBy11 extends Multiplication {

	@Override
	public Category getCategory() {
		return Category.MULTIPLICATION_BY_11;
	}

	@Override
	protected void initialize(int lower, int upper) {
		super.initialize(lower, upper);
		b = 11;
	}
}
