package numbersense.model.expression.number;

import numbersense.model.expression.Expression;
import numbersense.utility.Constants;

/**
 * @author George Chen
 * @since 12/20/11 12:57 PM
 */
public class MixedNumber extends NumberExpression {
	private int whole;
	private int numerator;
	private int denominator;

	public int getWhole() {
		return whole;
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public MixedNumber(int whole, int numerator, int denominator) {
		this.whole = whole;
		this.numerator = numerator;
		this.denominator = denominator;
		fixImproper();
	}

	private void fixImproper() {
		if (numerator >= denominator) {
			int over = numerator / denominator;
			whole += over;
			numerator -= (over * denominator);
		}
	}

	public Fraction toFraction() {
		return new Fraction(whole * denominator + numerator, denominator);
	}

	@Override
	public boolean equalsExactly(NumberExpression number) {
		if (number instanceof MixedNumber) {
			MixedNumber other = (MixedNumber) number;
			return (this.whole == other.whole &&
					this.denominator == other.denominator &&
					this.numerator == other.numerator);
		}
		return false;
	}

	@Override
	public Decimal convertToDecimal() {
		return new Decimal(whole + numerator / (float) denominator);
	}

	@Override
	public WholeNumber convertToWholeNumber() {
		return new WholeNumber(whole);
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
		return numerator + Constants.DIVIDE + denominator;
	}

	@Override
	public Expression copy() {
		return new MixedNumber(whole, numerator, denominator);
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
