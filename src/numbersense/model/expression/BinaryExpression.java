package numbersense.model.expression;

import numbersense.model.expression.number.WholeNumber;

/**
 * @author George Chen
 * @since 10/5/12 9:12 PM
 */
abstract public class BinaryExpression extends Expression {

	protected Expression left;
	protected Expression right;

	public BinaryExpression() {
	}

	public BinaryExpression(int left, int right) {
		this.left = new WholeNumber(left);
		this.right = new WholeNumber(right);
	}

	public BinaryExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public Expression getLeft() {
		return left;
	}

	@Override
	public Expression getRight() {
		return right;
	}

}
