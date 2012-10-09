package numbersense.model.expression.number;

import numbersense.model.expression.Expression;
import numbersense.utility.Convert;

/**
 * Whole value values
 *
 * @author George Chen
 * @since 12/20/11 12:56 AM
 */
public class WholeNumber extends NumberExpression {

	public static final WholeNumber ZERO = new WholeNumber(0); // Singleton
	public static final WholeNumber ONE = new WholeNumber(1); // Singleton

	private int value;

	public int getValue() {
		return value;
	}

	public WholeNumber(int value) {
		this.value = value;
	}

	@Override
	public boolean equalsExactly(NumberExpression number) {
		if (number instanceof WholeNumber) {
			WholeNumber other = (WholeNumber) number;
			return this.value == other.value;
		}
		return false;
	}

	@Override
	public String toString() {
		return Convert.toString(value);
	}

	public NumberExpression add(NumberExpression other) {
		NumberExpression result = null;
		if (other instanceof Decimal) {

		} else if (other instanceof Fraction) {

		} else if (other instanceof MixedNumber) {
			MixedNumber casted = (MixedNumber) other;
			result = new MixedNumber(casted.getWhole() + value, casted.getNumerator(), casted.getDenominator());
		} else if (other instanceof WholeNumber) {
			result = new WholeNumber(value + ((WholeNumber) other).getValue());
		}
		return null; //TODO
	}

	@Override
	public Expression copy() {
		return new WholeNumber(value);
	}
}
