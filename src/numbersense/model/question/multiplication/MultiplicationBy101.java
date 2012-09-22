package numbersense.model.question.multiplication;

import numbersense.model.Category;

/**
 * @author George Chen
 * @since 9/14/12 8:32 PM
 */
public class MultiplicationBy101 extends Multiplication {
	@Override
	public Category getCategory() {
		return Category.MULTIPLICATION_BY_101;
	}

	@Override
	protected void initialize(int lower, int upper) {
		super.initialize(lower, upper);
		b = 101;
	}
}