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

	public static WholeNumber one() {
		return ONE;
	}

	public static WholeNumber zero() {
		return ZERO;
	}

	////////////////////////////////////////////////////////////////////////////

	private int value;

	public int getValue() {
		return value;
	}

	public WholeNumber(int value) {
		this.value = value;
	}

	////////////////////////////////////////////////////////////////////////////

	@Override
	public boolean equalsExactly(NumberExpression number) {
		if (number instanceof WholeNumber) {
			WholeNumber other = (WholeNumber) number;
			return this.value == other.value;
		}
		return false;
	}

	////////////////////////////////////////////////////////////////////////////

	@Override
	public Decimal convertToDecimal() {
		return new Decimal(getValue());
	}

	@Override
	public WholeNumber convertToWholeNumber() {
		return (WholeNumber)this.copy();
	}

	@Override
	public Fraction convertToFraction() {
		return new Fraction(getValue(), 1);
	}

	@Override
	public MixedNumber convertToMixedNumber() {
		return new MixedNumber(getValue(), 0, 1);
	}

	@Override
	public float toFloat() {
		return value;
	}

	@Override
	public int toInt() {
		return value;
	}

	////////////////////////////////////////////////////////////////////////////

	@Override
	public boolean isPositive() {
		return !isNegative();
	}

	@Override
	public boolean isNegative() {
		return getValue() < 0;
	}

	////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return Convert.toString(value);
	}

	@Override
	public Expression copy() {
		return new WholeNumber(value);
	}

	@Override
	public boolean isEqualTo(Expression other) {
		boolean isEqual = false;
		if (other instanceof WholeNumber) {
			isEqual = getValue() == ((WholeNumber)other).getValue();
		}
		return isEqual;
	}

	////////////////////////////////////////////////////////////////////////////

	public NumberExpression add(WholeNumber other) {
		return new WholeNumber(getValue() + other.getValue());
	}

	public NumberExpression subtract(WholeNumber other) {
		return new WholeNumber(getValue() - other.getValue());
	}

	public NumberExpression multiply(WholeNumber other) {
		return new WholeNumber(getValue() * other.getValue());
	}

	public NumberExpression divide(WholeNumber other) {
		return new WholeNumber(getValue() / other.getValue());
	}

	public NumberExpression add(Fraction other) {
		return new Fraction(getValue() * other.getDenominator() + other.getNumerator(), other.getDenominator());
	}

	public NumberExpression subtract(Fraction other) {
		return new Fraction(getValue() * other.getDenominator() - other.getNumerator(), other.getDenominator());
	}

	public NumberExpression multiply(Fraction other) {
		return new Fraction(getValue() * other.getNumerator(), other.getDenominator());
	}

	public NumberExpression divide(Fraction other) {
		return new Fraction(getValue() * other.getDenominator(), other.getNumerator());
	}

	public NumberExpression add(Decimal other) {
		return new Decimal(getValue() + other.getValue());
	}

	public NumberExpression subtract(Decimal other) {
		return new Decimal(getValue() - other.getValue());
	}

	public NumberExpression multiply(Decimal other) {
		return new Decimal(getValue() * other.getValue());
	}

	public NumberExpression divide(Decimal other) {
		return new Decimal(getValue() / other.getValue());
	}

	public NumberExpression add(MixedNumber other) {
		return new MixedNumber(getValue() + other.getWhole(), other.getNumerator(), other.getDenominator());
	}

	public NumberExpression subtract(MixedNumber other) {
		return new MixedNumber(getValue() - other.getWhole(), other.getNumerator(), other.getDenominator());
	}

	public NumberExpression multiply(MixedNumber other) {
		return new MixedNumber(getValue() * other.getWhole(), getValue() * other.getNumerator(), other.getDenominator());
	}

	public NumberExpression divide(MixedNumber other) {
		return divide(other.toFraction());
	}

}
