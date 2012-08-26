package numbersense.model.number;

/**
 * @author George Chen
 * @since 12/20/11 12:58 PM
 */
public class Fraction extends ANumber {
	public int numerator;
	public int denominator;

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	@Override
	public boolean equalsExactly(ANumber number) {
		if (number instanceof Fraction) {
			Fraction other = (Fraction) number;
			return this.denominator == other.denominator &&
				   this.numerator == other.numerator;
		}
		return false;
	}
}
