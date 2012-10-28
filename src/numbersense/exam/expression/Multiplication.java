package numbersense.exam.expression;


import numbersense.exam.expression.number.NumberExpression;
import numbersense.utility.Constants;
import numbersense.utility.Utility;

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
		return Utility.concatenateWithSpaces(new String[]{
														 left.toString(),
														 Constants.SIGN_MULTIPLY,
														 right.toString()
		});
	}

	@Override
	public Expression copy() {
		return new Multiplication(left.copy(), right.copy());
	}

	@Override
	public NumberExpression evaluate() {
		return left.evaluate().multiply(right.evaluate());
	}

	@Override
	public boolean isEqualTo(Expression otherExpression) {
		boolean b = false;
		if (otherExpression instanceof Multiplication) {
			Multiplication q = (Multiplication) otherExpression;
			if (q.left.isEqualTo(this.left) && q.right.isEqualTo(this.right)) {
				b = true;
			}
		}
		return b;
	}

}
