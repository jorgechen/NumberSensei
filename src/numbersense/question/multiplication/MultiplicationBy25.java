package numbersense.question.multiplication;

import numbersense.model.Category;

/**
 * @author George Chen
 * @since 8/25/12 5:42 PM
 */
public class MultiplicationBy25 extends MultiplicationBy5 {

	@Override
	public Category getCategory() {
		return Category.MULTIPLICATION_BY_25;
	}

	@Override
	protected void initialize(int lower, int upper) {
		super.initialize(lower, upper);
		right = 25;

		if (left == 25) {
			left = 18;
		}
	}
}
