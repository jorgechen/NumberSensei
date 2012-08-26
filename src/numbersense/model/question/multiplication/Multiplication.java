package numbersense.model.question.multiplication;


import numbersense.model.number.ANumber;
import numbersense.model.number.WholeNumber;
import numbersense.model.question.Question;
import numbersense.model.question.QuestionDescription;

/**
 * @author George Chen
 * @since 12/24/11 3:01 PM
 */
abstract public class Multiplication extends Question {
	public int a;
	public int b;
	public int solution;

	@Override
	public QuestionDescription getDescription() {
		return new QuestionDescription(this.a + " x " + this.b + " =");
	}

	@Override
	public boolean solve(ANumber number) {
		return (new WholeNumber(solution)).equalsExactly(number);
	}
}
