package numbersense.model.expression.number;

import numbersense.model.expression.Expression;

/**
 * Alternate implementation of numbers.
 *
 * @author George Chen
 * @since 10/8/12 9:16 PM
 */
public class Numeral extends Expression {
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

	// Choices:
	// - Whole number or fraction
	private int numerator;
	private int denominator; //if ==1, then it's a whole number
	// - Decimal
	private float decimal;

	public Numeral add(Numeral other) {
		return null; //TODO
	}

	public Numeral subtract(Numeral other) {
		return null; //TODO
	}

	public Numeral multiply(Numeral other) {
		return null; //TODO
	}

	public Numeral divide(Numeral other) {
		return null; //TODO
	}


	public enum Type {
		FRACTION,
		DECIMAL,
	}
}
