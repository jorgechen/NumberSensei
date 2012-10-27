package numbersense.model.expression.number;

import numbersense.model.expression.Expression;
import numbersense.utility.Constants;

/**
 * @author George Chen
 * @since 12/20/11 12:57 PM
 */
public class MixedNumber extends NumberExpression {

	private int sign;
	private WholeNumber wholeNumber;
	private Fraction fraction;

	public WholeNumber getWholeNumber() {
		return wholeNumber;
	}

	public Fraction getFraction() {
		return fraction;
	}

	public int getWhole() {
		return wholeNumber.getValue();
	}

	public int getNumerator() {
		return fraction.getNumerator();
	}

	public int getDenominator() {
		return fraction.getDenominator();
	}

	public MixedNumber(WholeNumber wholeNumber, Fraction fraction) {
		this.wholeNumber = wholeNumber;
		this.fraction = fraction;
		this.sign = 1;
		fixImproper();
	}

	public MixedNumber(int whole, int numerator, int denominator) {
		this(new WholeNumber(whole), new Fraction(numerator, denominator));
	}

	////////////////////////////////////////////////////////////////////////////


	private void fixImproper() {
		Fraction sum = getFraction().add(getWholeNumber()).convertToFraction();
		if (sum.isNegative()) {
			//TODO
		}

		if (sum.isImproper()) {

		}
		if ((getFraction().isPositive() && getWholeNumber().isPositive()) ||
			(getFraction().isNegative() && getWholeNumber().isNegative())) {

		}
	}

	public Fraction toFraction() {
		return new Fraction(this.getWhole() * this.getDenominator() + this.getNumerator(), this.getDenominator());
	}

	////////////////////////////////////////////////////////////////////////////


	@Override
	public boolean equalsExactly(NumberExpression number) {
		boolean isEqual = false;
		if (number instanceof MixedNumber) {
			MixedNumber other = (MixedNumber) number;
			isEqual = this.getNumerator() == other.getNumerator()
					  && this.getDenominator() == other.getDenominator()
					  && this.getWhole() == other.getWhole();
		}
		return isEqual;
	}
	////////////////////////////////////////////////////////////////////////////

	@Override
	public Decimal convertToDecimal() {
		return new Decimal(fraction.toFloat() + wholeNumber.toFloat());
	}

	@Override
	public WholeNumber convertToWholeNumber() {
		return new WholeNumber(fraction.toInt() + wholeNumber.toInt());
	}

	@Override
	public Fraction convertToFraction() {
		return fraction.add(wholeNumber).convertToFraction();
	}

	@Override
	public MixedNumber convertToMixedNumber() {
		return (MixedNumber) this.copy();
	}

	@Override
	public float toFloat() {
		return wholeNumber.toFloat() + fraction.toFloat();
	}

	@Override
	public int toInt() {
		return wholeNumber.toInt() + fraction.toInt();
	}

	////////////////////////////////////////////////////////////////////////////

	@Override
	public boolean isPositive() {
		return !isNegative();
	}

	@Override
	public boolean isNegative() {
		return getNumerator() < 0;
	}

	////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return getWhole() +
			   Constants.SPACE +
			   getNumerator() +
			   Constants.SIGN_DIVIDE +
			   getDenominator();
	}

	@Override
	public Expression copy() {
		return new MixedNumber(getWhole(), getNumerator(), getDenominator());
	}

	@Override
	public boolean isEqualTo(Expression other) {
		boolean isEqual = false;
		if (other instanceof MixedNumber) {
			MixedNumber otherM = (MixedNumber)other;
			isEqual = getFraction().isEqualTo(otherM.getFraction()) &&
					  getWholeNumber().isEqualTo(otherM.getWholeNumber());
		}
		return isEqual;
	}

	////////////////////////////////////////////////////////////////////////////

	public NumberExpression add(WholeNumber other) {
		return wholeNumber.add(other).add(fraction);
	}

	public NumberExpression subtract(WholeNumber other) {
		return wholeNumber.subtract(other).add(fraction);
	}

	public NumberExpression multiply(WholeNumber other) {
		return wholeNumber.multiply(other).add(fraction);
	}

	public NumberExpression divide(WholeNumber other) {
		return wholeNumber.divide(other).add(fraction);
	}

	public NumberExpression add(Fraction other) {
		return fraction.add(other).add(wholeNumber);
	}

	public NumberExpression subtract(Fraction other) {
		return fraction.subtract(other).add(wholeNumber);
	}

	public NumberExpression multiply(Fraction other) {
		return fraction.multiply(other).add(wholeNumber);
	}

	public NumberExpression divide(Fraction other) {
		return fraction.divide(other).add(wholeNumber);
	}

	public NumberExpression add(Decimal other) {
		return fraction.add(wholeNumber).add(other);
	}

	public NumberExpression subtract(Decimal other) {
		return fraction.add(wholeNumber).subtract(other);
	}

	public NumberExpression multiply(Decimal other) {
		return fraction.add(wholeNumber).multiply(other);
	}

	public NumberExpression divide(Decimal other) {
		return fraction.add(wholeNumber).divide(other);
	}

	public NumberExpression add(MixedNumber other) {
		return new MixedNumber((WholeNumber) wholeNumber.add(other.getWholeNumber()),
							  (Fraction) fraction.add(other.getFraction()));
	}

	public NumberExpression subtract(MixedNumber other) {
		Fraction f = wholeNumber.subtract(other.getWholeNumber()).add(fraction.subtract(other.getFraction())).convertToFraction();
		return new MixedNumber(WholeNumber.zero(), f);
	}

	public NumberExpression multiply(MixedNumber other) {
		return convertToFraction().multiply(other.convertToFraction());
	}

	public NumberExpression divide(MixedNumber other) {
		return convertToFraction().divide(other.convertToFraction());
	}
}
