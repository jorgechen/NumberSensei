package numbersense.model.expression;


import numbersense.model.expression.number.NumberExpression;
import numbersense.utility.Constants;

/**
 * @author George Chen
 * @since 12/24/11 3:01 PM
 */
public class Multiplication extends BinaryExpression {

	public Multiplication(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public String toString() {
		return left +
			   Constants.SPACE +
			   Constants.MULTIPLY +
			   Constants.SPACE +
			   right +
			   Constants.SPACE +
			   Constants.EQUAL;
	}

	@Override
	public Expression copy() {
		return new Multiplication(left.copy(), right.copy());
	}

	@Override
	public NumberExpression evaluate() {
		return left.evaluate().multiply(right.evaluate());
	}

	public boolean isEqual(Expression otherExpression) {
		boolean b = false;
		if (otherExpression instanceof Multiplication) {
			Multiplication q = (Multiplication) otherExpression;
			if (q.left == this.left && q.right == this.right) {
				b = true;
			}
		}
		return b;
	}

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
