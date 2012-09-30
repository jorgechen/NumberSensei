package numbersense.model.question.expression;

import numbersense.utility.Constants;

/**
 * @author George Chen
 * @since 9/28/12 9:11 PM
 */
public class DivisionExpression extends Expression {
	private int left;
	private int right;

	public DivisionExpression(int left, int right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int solve() {
		int result = 0;
		if (right != 0) {
			result = left / right;
		}
		return result;
	}

	@Override
	public Expression getLeft() {
		return Expression.NONE;
	}

	@Override
	public Expression getRight() {
		return Expression.NONE;
	}

	@Override
	public String getDescription() {
		return left + Constants.SPACE + Constants.DIVIDE + Constants.SPACE + right;
	}

	@Override
	public Expression copy() {
		return new DivisionExpression(left, right);
	}
}
