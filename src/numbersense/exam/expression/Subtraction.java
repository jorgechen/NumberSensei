package numbersense.exam.expression;


import numbersense.exam.expression.number.NumberExpression;
import numbersense.utility.Constants;
import numbersense.utility.Utility;

/**
 * @author George Chen
 * @since 12/24/11 3:01 PM
 */
public class Subtraction extends BinaryExpression {

	public Subtraction(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public String toString() {
		return Utility.concatenateWithSpaces(new String[]{
														 left.toString(),
														 Constants.SIGN_SUBTRACT,
														 right.toString()
		});
	}
	@Override
	public Expression copy() {
		return new Subtraction(left.copy(), right.copy());
	}

	@Override
	public NumberExpression evaluate() {
		return left.evaluate().subtract(right.evaluate());
	}

	@Override
	public boolean isEqualTo(Expression other) {
		boolean b = false;
		if (other instanceof Subtraction) {
			Subtraction q = (Subtraction) other;
			if (q.left.isEqualTo(this.left) && q.right.isEqualTo(this.right)) {
				b = true;
			}
		}
		return b;
	}
}
