package numbersense.model.expression;

import numbersense.model.expression.number.NumberExpression;
import numbersense.utility.Randomizer;

/**
 * @author George Chen
 * @since 12/18/11 11:41 AM
 */
abstract public class Expression implements Operator {

	abstract public Expression getLeft();

	abstract public Expression getRight();

	abstract public Expression copy();

	abstract public NumberExpression evaluate();

	private static int COUNT_OPERATIONS = 4;

	public static Expression randomQuestion() {
		int random = Randomizer.random(COUNT_OPERATIONS);
		//TODO
		return null;
	}

	public void initialize(int countOperations, int countParentheses) {
		if (countOperations == 1) {
			//Randomly pick left or right
			if (Randomizer.coinFlip()) {

				//TODO
			} else {

			}
		} else if (countOperations > 1) {
			//Generate left Expression
			Expression left = randomQuestion();

			//Generate right Expression
			Expression right = randomQuestion();

		}
	}

	abstract public boolean isEqualTo(Expression other);
}
