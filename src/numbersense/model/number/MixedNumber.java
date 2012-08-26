package numbersense.model.number;

/**
 * @author George Chen
 * @since 12/20/11 12:57 PM
 */
public class MixedNumber extends Fraction {
	public int whole;

	public MixedNumber(int numerator, int denominator) {
		this(0, numerator, denominator);
	}

	public MixedNumber(int whole, int numerator, int denominator) {
		super(numerator, denominator);
		this.whole = whole;
		fixImproper();
	}

	private void fixImproper() {
		if (numerator >= denominator) {
			int over = numerator / denominator;
			whole += over;
			numerator -= (over * denominator);
		}
	}

	@Override
	public boolean equalsExactly(ANumber number) {
		if (number instanceof MixedNumber) {
			MixedNumber other = (MixedNumber) number;
			return (this.whole == other.whole &&
					this.denominator == other.denominator &&
					this.numerator == other.numerator);
		}
		return false;
	}
}
