package numbersense.model.expression;


import numbersense.model.expression.number.NumberExpression;
import numbersense.utility.Constants;
import numbersense.utility.Utility;

/**
 * @author George Chen
 * @since 12/24/11 3:01 PM
 */
public class Division extends BinaryExpression {

	public Division(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public String toString() {
		return Utility.concatenateWithSpaces(new String[]{
														 left.toString(),
														 Constants.SIGN_DIVIDE,
														 right.toString()
		});
	}

	@Override
	public Expression copy() {
		return new Division(left.copy(), right.copy());
	}

	@Override
	public NumberExpression evaluate() {
		return left.evaluate().divide(right.evaluate());
	}

	@Override
	public boolean isEqualTo(Expression other) {
		boolean b = false;
		if (other instanceof Division) {
			Division q = (Division) other;
			if (q.left.isEqualTo(this.left) && q.right.isEqualTo(this.right)) {
				b = true;
			}
		}
		return b;
	}
}
