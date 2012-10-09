package numbersense.model.expression;

import numbersense.model.expression.number.NumberExpression;
import numbersense.model.expression.number.WholeNumber;
import numbersense.question.QuestionDescription;

/**
 * @author George Chen
 * @since 12/18/11 6:11 PM
 */
abstract public class Exponential extends BinaryExpression {
	public WholeNumber base;
	public WholeNumber exponent;

	@Override
	public QuestionDescription getDescription() {
		return new QuestionDescription(base + "^" + exponent + " =");
	}

	@Override
	public NumberExpression evaluate() {
		//TODO optimize

		NumberExpression answer = WholeNumber.ONE;
		for (int i = 0; i < exponent.getValue(); i++) {
			answer = answer.multiply(base);
		}
		return answer;
	}
}
