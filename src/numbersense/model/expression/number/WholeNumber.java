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
	public Decimal convertToDecimal() {
		return null; //TODO
	}

	@Override
	public WholeNumber convertToWholeNumber() {
		return null; //TODO
	}

	@Override
	public Fraction convertToFraction() {
		return null; //TODO
	}

	@Override
	public MixedNumber convertToMixedNumber() {
		return null; //TODO
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

	public NumberExpression subtract(NumberExpression other) {
		return null; //TODO
	}

	public NumberExpression multiply(NumberExpression other) {
		return null; //TODO
	}

	public NumberExpression divide(NumberExpression other) {
		return null; //TODO
	}

	@Override
	public Expression copy() {
		return new WholeNumber(value);
	}

	public NumberExpression add(WholeNumber other) {
		return null; //TODO
	}

	public NumberExpression subtract(WholeNumber other) {
		return null; //TODO
	}

	public NumberExpression multiply(WholeNumber other) {
		return null; //TODO
	}

	public NumberExpression divide(WholeNumber other) {
		return null; //TODO
	}

	public NumberExpression add(Fraction other) {
		return null; //TODO
	}

	public NumberExpression subtract(Fraction other) {
		return null; //TODO
	}

	public NumberExpression multiply(Fraction other) {
		return null; //TODO
	}

	public NumberExpression divide(Fraction other) {
		return null; //TODO
	}

	public NumberExpression add(Decimal other) {
		return null; //TODO
	}

	public NumberExpression subtract(Decimal other) {
		return null; //TODO
	}

	public NumberExpression multiply(Decimal other) {
		return null; //TODO
	}

	public NumberExpression divide(Decimal other) {
		return null; //TODO
	}

	public NumberExpression add(MixedNumber other) {
		return null; //TODO
	}

	public NumberExpression subtract(MixedNumber other) {
		return null; //TODO
	}

	public NumberExpression multiply(MixedNumber other) {
		return null; //TODO
	}

	public NumberExpression divide(MixedNumber other) {
		return null; //TODO
	}
}
