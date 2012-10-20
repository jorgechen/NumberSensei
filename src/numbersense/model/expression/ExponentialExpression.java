package numbersense.model.expression;

import numbersense.model.expression.number.NumberExpression;
import numbersense.model.expression.number.WholeNumber;

/**
 * @author George Chen
 * @since 12/18/11 6:11 PM
 */
public class ExponentialExpression extends BinaryExpression {

	public Expression getBase() {
		return left;
	}

	public Expression getExponent() {
		return right;
	}

	public ExponentialExpression(int base, int exponent) {
		super(base, exponent);
	}

	public ExponentialExpression(Expression base, Expression exponent) {
		super(base, exponent);
	}


	@Override
	public Expression copy() {
		return new ExponentialExpression(left.copy(), right.copy());
	}

	@Override
	public NumberExpression evaluate() {
		//TODO optimize

		NumberExpression base = getBase().evaluate();
		NumberExpression exponent = getExponent().evaluate();

		NumberExpression answer = WholeNumber.ONE;
		for (int i = 0; i < exponent.getValue(); i++) {
			answer = answer.multiply(base);
		}
		return answer;
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
