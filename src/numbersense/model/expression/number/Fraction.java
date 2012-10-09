package numbersense.model.expression.number;

import numbersense.model.expression.Expression;
import numbersense.utility.Constants;

/**
 * @author George Chen
 * @since 12/20/11 12:58 PM
 */
public class Fraction extends NumberExpression {
	public int numerator;
	public int denominator;

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
	public String toString() {
		return numerator + Constants.DIVIDE + denominator;
	}

	@Override
	public Expression copy() {
		return new Fraction(numerator, denominator);
	}
}
