package numbersense.model.question.expression;

import numbersense.utility.Constants;
import numbersense.utility.Randomizer;

/**
 * Represents anything that results in a number: integer, operation, parenthetical operation
 *
 * @author George Chen
 * @since 9/28/12 8:07 PM
 */
abstract public class Expression {

	public static Expression NONE = new Expression() {
		@Override
		public int solve() {
			return 0;
		}

		@Override
		public Expression getLeft() {
			return null;
		}

		@Override
		public Expression getRight() {
			return null;
		}

		@Override
		public String getDescription() {
			return "";
		}

		@Override
		public Expression copy() {
			return this;
		}

	};

	abstract public int solve();

	abstract public Expression getLeft();

	abstract public Expression getRight();

	abstract public String getDescription();

	abstract public Expression copy();

	private static final int X = Constants.ZERO;
	public static final Expression[] POOL = new Expression[]{
															new AdditionExpression(X, X),
															new SubtractionExpression(X, X),
															new MultiplicationExpression(X, X),
															new DivisionExpression(X, X)
	};


	public static Expression randomExpression() {
		int random = Randomizer.random(POOL.length);
		Expression expression = POOL[random].copy();
		return expression;
	}

	public void initialize(int countOperations, int countParentheses) {
		if (countOperations == 1) {
			//Randomly pick left or right
			if (Randomizer.coinFlip()) {

				//TODO
			} else {

			}
		} else if (countOperations > 1) {
			//Generate left expression
			Expression left = randomExpression();

			//Generate right expression
			Expression right = randomExpression();

		}
	}
}
