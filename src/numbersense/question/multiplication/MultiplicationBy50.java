package numbersense.question.multiplication;

import numbersense.exam.expression.number.WholeNumber;

/**
 * @author George Chen
 * @since 8/31/12 10:03 PM
 */
public class MultiplicationBy50 extends MultiplicationBy5{

	@Override
	protected void initialize(int lower, int upper) {
		super.initialize(lower, upper);
		expression.setRight(new WholeNumber(50));
	}

}
