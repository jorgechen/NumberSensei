package numbersense.model.question.expression;

import numbersense.utility.Constants;

/**
 * @author George Chen
 * @since 9/28/12 9:11 PM
 */
public class AdditionExpression extends Expression {
	private int left;
	private int right;

	public AdditionExpression(int left, int right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int solve() {
		return left + right;
	}

	@Override
	public Expression getLeft() {
		return Expression.NULL;
	}

	@Override
	public Expression getRight() {
		return Expression.NULL;
	}

	@Override
	public String getDescription() {
		return left + Constants.SPACE + Constants.PLUS + Constants.SPACE + right;
	}
}
