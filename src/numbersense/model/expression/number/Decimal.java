package numbersense.model.expression.number;

import numbersense.model.expression.Expression;
import numbersense.utility.Convert;

/**
 * @author George Chen
 * @since 12/20/11 12:59 PM
 */
public class Decimal extends NumberExpression {
	public float value;

	public float getValue() {
		return value;
	}

	public Decimal(float value) {
		this.value = value;
	}

	@Override
	public boolean equalsExactly(NumberExpression number) {
		if (number instanceof Decimal) {
			Decimal other = (Decimal) number;
			return this.value == other.value; //TODO check for accuracy
		}
		return false;
	}

	@Override
	public Decimal convertToDecimal() {
		return (Decimal) this.copy();
	}

	//Note: decimal is truncated!
	@Override
	public WholeNumber convertToWholeNumber() {
		return new WholeNumber((int)value);
	}

	private static int BASIC = 1000;
	@Override
	public Fraction convertToFraction() {
		//TODO optimize this
		//TODO 1. convert 1.234 to 1234/10000
		//TODO 2. use Euclid to simplify
		return new Fraction((int)(BASIC * value), BASIC);
	}

	@Override
	public MixedNumber convertToMixedNumber() {
		return new MixedNumber((int) value, (int)((value * BASIC) % BASIC), BASIC);
	}

	@Override
	public String toString() {
		return Convert.toString(value);
	}

	@Override
	public Expression copy() {
		return new Decimal(value);
	}

	public NumberExpression add(WholeNumber other) {
		return new Decimal(value + other.getValue());
	}

	public NumberExpression subtract(WholeNumber other) {
		return new Decimal(value - other.getValue());
	}

	public NumberExpression multiply(WholeNumber other) {
		return new Decimal(value * other.getValue());
	}

	public NumberExpression divide(WholeNumber other) {
		return new Decimal(value / other.getValue());
	}

	public NumberExpression add(Fraction other) {
		return new Decimal(value + other.getNumerator() / (float) other.getDenominator());
	}

	public NumberExpression subtract(Fraction other) {
		return new Decimal(value - other.getNumerator() / (float) other.getDenominator());
	}

	public NumberExpression multiply(Fraction other) {
		return new Decimal(value * other.getNumerator() / other.getDenominator());
	}

	public NumberExpression divide(Fraction other) {
		return new Decimal(value / other.getNumerator() * other.getDenominator());
	}

	public NumberExpression add(Decimal other) {
		return new Decimal(value + other.getValue());
	}

	public NumberExpression subtract(Decimal other) {
		return new Decimal(value - other.getValue());
	}

	public NumberExpression multiply(Decimal other) {
		return new Decimal(value * other.getValue());
	}

	public NumberExpression divide(Decimal other) {
		return new Decimal(value / other.getValue());
	}

	public NumberExpression add(MixedNumber other) {
		return new Decimal(value + other.getWhole() + other.getNumerator() / (float) other.getDenominator());
	}

	public NumberExpression subtract(MixedNumber other) {
		return new Decimal(value - other.getWhole() - other.getNumerator() / (float) other.getDenominator());
	}

	public NumberExpression multiply(MixedNumber other) {
		return new Decimal(value * (other.getWhole() + other.getNumerator() / (float) other.getDenominator()));
	}

	public NumberExpression divide(MixedNumber other) {
		return new Decimal(value / (other.getWhole() + other.getNumerator() / (float) other.getDenominator()));
	}
}

