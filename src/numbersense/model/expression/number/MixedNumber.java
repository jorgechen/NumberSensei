package numbersense.model.expression.number;

import numbersense.model.expression.Expression;
import numbersense.question.QuestionDescription;
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
	public String toString() {
		return numerator + Constants.DIVIDE + denominator;
	}

	@Override
	public QuestionDescription getDescription() {
		return new QuestionDescription(this.toString());
	}

	@Override
	public Expression copy() {
		return new MixedNumber(whole, numerator, denominator);
	}

}
