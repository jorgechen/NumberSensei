package numbersense.exam.expression;

import numbersense.exam.expression.number.NumberExpression;
import numbersense.exam.expression.number.WholeNumber;

/**
 * @author George Chen
 * @since 10/5/12 9:12 PM
 */
abstract public class BinaryExpression extends Expression {

	protected Expression left;

	protected Expression right;

	@Override
	public Expression getLeft() {
		return left;
	}

	@Override
	public Expression getRight() {
		return right;
	}

	public void setLeft(Expression left) {
		this.left = left;
	}

	public void setRight(Expression right) {
		this.right = right;
	}

	////////////////////////////////////////////////////////////////////////////

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

	////////////////////////////////////////////////////////////////////////////

	public NumberExpression add(NumberExpression other) {
		return evaluate().add(other);
	}

	public NumberExpression subtract(NumberExpression other) {
		return evaluate().subtract(other);
	}

	public NumberExpression multiply(NumberExpression other) {
		return evaluate().multiply(other);
	}

	public NumberExpression divide(NumberExpression other) {
		return evaluate().divide(other);
	}
}
