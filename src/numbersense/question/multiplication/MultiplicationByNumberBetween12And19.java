package numbersense.question.multiplication;

import numbersense.exam.Category;
import numbersense.exam.expression.number.WholeNumber;
import numbersense.utility.Randomizer;

/**
 * @author George Chen
 * @since 2/2/13 11:01 AM
 */
public class MultiplicationByNumberBetween12And19 extends MultiplicationBy12 {

	@Override
	public Category getCategory() {
		return Category.MULTIPLICATION_BY_NUMBER_BETWEEN_12_AND_19;
	}

	@Override
	protected void initialize(int lower, int upper) {
		super.initialize(lower, upper);
		expression.setRight(new WholeNumber(Randomizer.random(12, 20)));
	}

}