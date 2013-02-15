package numbersense.question.exponential;

import numbersense.exam.Category;
import numbersense.exam.expression.ExponentialExpression;

/**
 * @author George Chen
 * @since 2/2/13 10:45 AM
 */
public class SquareNumberEndingIn5 extends Square {
	@Override
	public Category getCategory() {
		return Category.SQUARE_NUMBER_ENDING_IN_5;
	}

	@Override
	protected void initialize(int upperBound) {
		super.initialize(100);
		int b = exponentialExpression.getBase().evaluate().toInt();
		int exp = exponentialExpression.getExponent().evaluate().toInt();
		exponentialExpression = new ExponentialExpression(b - (b % 5), exp);
	}
}
