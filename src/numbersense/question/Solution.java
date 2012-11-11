package numbersense.question;

import numbersense.exam.expression.Expression;
import numbersense.exam.expression.number.NumberExpression;

/**
 * @author George Chen
 * @since 10/20/12 4:53 PM
 */
abstract public class Solution {
	abstract public String toText();

	public static Solution create(Expression number) {
		return new SolutionString(number.evaluate().toString());
	}

	public static Solution create(String answer) {
		return new SolutionString(answer);
	}
}