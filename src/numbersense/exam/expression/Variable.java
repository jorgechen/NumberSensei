package numbersense.exam.expression;

import numbersense.exam.expression.number.NumberExpression;

/**
 * @author George Chen
 * @since 10/27/12 11:15 AM
 */
public class Variable extends Expression {

	@Override
	public Expression getLeft() {
		return null; //TODO
	}

	@Override
	public Expression getRight() {
		return null; //TODO
	}

	@Override
	public Expression copy() {
		return null; //TODO
	}

	@Override
	public NumberExpression evaluate() {
		return null; //TODO
	}

	@Override
	public boolean isEqualTo(Expression other) {
		return false; //TODO
	}

	public NumberExpression add(NumberExpression other) {
		return null; //TODO
	}

	public NumberExpression subtract(NumberExpression other) {
		return null; //TODO
	}

	public NumberExpression multiply(NumberExpression other) {
		return null; //TODO
	}

	public NumberExpression divide(NumberExpression other) {
		return null; //TODO
	}
}
