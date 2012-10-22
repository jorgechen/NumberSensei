package numbersense.question;

import numbersense.model.expression.number.NumberExpression;

/**
 * @author George Chen
 * @since 10/20/12 4:53 PM
 */
abstract public class Solution {
	abstract public String toText();

	public static Solution create(NumberExpression number) {
		return new SolutionString(number.evaluate().toString());
	}

	public static Solution create(String answer) {
		return new SolutionString(answer);
	}
}