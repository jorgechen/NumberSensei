package numbersense.model.expression;


import numbersense.model.expression.number.NumberExpression;
import numbersense.utility.Constants;
import numbersense.utility.Utility;

/**
 * @author George Chen
 * @since 12/24/11 3:01 PM
 */
public class Addition extends BinaryExpression {

	public Addition(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public String toString() {
		return Utility.concatenateWithSpaces(new String[]{
														 left.toString(),
														 Constants.SIGN_ADD,
														 right.toString()
		});
	}
	@Override
	public Expression copy() {
		return new Addition(left.copy(), right.copy());
	}

	@Override
	public NumberExpression evaluate() {
		return left.evaluate().add(right.evaluate());
	}

	@Override
	public boolean isEqualTo(Expression other) {
		boolean b = false;
		if (other instanceof Addition) {
			Addition q = (Addition) other;
			if (q.left.isEqualTo(this.left) && q.right.isEqualTo(this.right)) {
				b = true;
			}
		}
		return b;
	}
}
