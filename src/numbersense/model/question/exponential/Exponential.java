package numbersense.model.question.exponential;

import numbersense.model.number.ANumber;
import numbersense.model.number.WholeNumber;
import numbersense.model.question.Question;
import numbersense.model.question.QuestionDescription;

/**
 * @author George Chen
 * @since 12/18/11 6:11 PM
 */
abstract public class Exponential extends Question {
	public int base;
	public int exponent;
	public int solution;

	@Override
	public QuestionDescription getDescription() {
		return new QuestionDescription(base + "^" + exponent + " =");
	}

	@Override
	public boolean solve(ANumber number) {
		return (new WholeNumber(solution)).equalsExactly(number);
	}
}
