package numbersense.model.expression.number;

import numbersense.model.expression.Expression;
import numbersense.utility.Constants;
import numbersense.utility.Tweak;

/**
 * @author George Chen
 * @since 12/20/11 12:58 PM
 */
public class Fraction extends NumberExpression {

	private int numerator;
	private int denominator;

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}


	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/**
	 * @return true if this is an improper fraction
	 */
	public boolean isImproper() {
		return numerator >= denominator;
	}

	/**
	 * Try to simplify itself
	 *
	 * @return true if changes were made
	 */
	public boolean simplify() {
		return Tweak.simplify(this);
	}

	@Override
	public boolean equalsExactly(NumberExpression number) {
		if (number instanceof Fraction) {
			Fraction other = (Fraction) number;
			return this.denominator == other.denominator &&
				   this.numerator == other.numerator;
		}
		return false;
	}

	@Override
	public Decimal convertToDecimal() {
		return new Decimal(numerator / (float) denominator);
	}

	/**
	 * @return Note: fraction is truncated!
	 */
	@Override
	public WholeNumber convertToWholeNumber() {
		return new WholeNumber(numerator / denominator);
	}

	@Override
	public Fraction convertToFraction() {
		return (Fraction) this.copy();
	}

	@Override
	public MixedNumber convertToMixedNumber() {
		return new MixedNumber(numerator / denominator, numerator % denominator, denominator);
	}

	@Override
	public String toString() {
		return numerator + Constants.DIVIDE + denominator;
	}

	@Override
	public Expression copy() {
		return new Fraction(numerator, denominator);
	}

	public NumberExpression add(WholeNumber other) {
		return new Fraction(numerator + denominator * other.getValue(),
						   denominator);
	}

	public NumberExpression subtract(WholeNumber other) {
		return new Fraction(numerator - denominator * other.getValue(),
						   denominator);
	}

	public NumberExpression multiply(WholeNumber other) {
		Fraction result = new Fraction(numerator * other.getValue(),
									  denominator);
		result.simplify();
		return result;
	}

	public NumberExpression divide(WholeNumber other) {
		Fraction result = new Fraction(numerator,
									  denominator * other.getValue());
		result.simplify();
		return result;
	}

	public NumberExpression add(Fraction other) {
		Fraction result = new Fraction(numerator * other.getDenominator() + denominator * other.getNumerator(),
									  denominator * other.getDenominator());
		result.simplify();
		return result;
	}

	public NumberExpression subtract(Fraction other) {
		Fraction result = new Fraction(numerator * other.getDenominator() - denominator * other.getNumerator(),
									  denominator * other.getDenominator());
		result.simplify();
		return result;
	}

	public NumberExpression multiply(Fraction other) {
		Fraction result = new Fraction(numerator * other.getNumerator(),
									  denominator * other.getDenominator());
		result.simplify();
		return result;
	}

	public NumberExpression divide(Fraction other) {
		Fraction result = new Fraction(numerator * other.getDenominator(),
									  denominator * other.getNumerator());
		result.simplify();
		return result;
	}

	public NumberExpression add(Decimal other) {
		return new Decimal(numerator / (float) denominator + other.getValue());
	}

	public NumberExpression subtract(Decimal other) {
		return new Decimal(numerator / (float) denominator - other.getValue());
	}

	public NumberExpression multiply(Decimal other) {
		return new Decimal(numerator / (float) denominator * other.getValue());
	}

	public NumberExpression divide(Decimal other) {
		return new Decimal(numerator / (float) denominator / other.getValue());
	}

	/**
	 * @param other
	 * @return a fraction, not mixed number, which is arbitrary
	 */
	public NumberExpression add(MixedNumber other) {
		int newDenominator = denominator * other.getDenominator();
		Fraction result = new Fraction(numerator * other.getDenominator()
									   + denominator * other.getNumerator()
									   + other.getWhole() * newDenominator,
									  newDenominator);
		result.simplify();
		return result;
	}

	public NumberExpression subtract(MixedNumber other) {
		int newDenominator = denominator * other.getDenominator();
		Fraction result = new Fraction(numerator * other.getDenominator()
									   - denominator * other.getNumerator()
									   - other.getWhole() * newDenominator,
									  newDenominator);
		result.simplify();
		return result;
	}

	public NumberExpression multiply(MixedNumber other) {
		Fraction otherFraction = other.toFraction();
		Fraction result = (Fraction) this.multiply(otherFraction);
		result.simplify();
		return result;
	}

	public NumberExpression divide(MixedNumber other) {
		Fraction otherFraction = other.toFraction();
		Fraction result = (Fraction) this.divide(otherFraction);
		result.simplify();
		return result;
	}
}
