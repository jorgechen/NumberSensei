package numbersense.model.number;

/**
 * @author George Chen
 * @since 12/20/11 12:59 PM
 */
public class Decimal extends ANumber {
	public double value;

	public Decimal(double value) {
		this.value = value;
	}

	@Override
	public boolean equalsExactly(ANumber number) {
		if (number instanceof Decimal) {
			Decimal other = (Decimal) number;
			return this.value == other.value; //TODO check for accuracy
		}
		return false;
	}

	@Override
	public String toString() {
		return "" + value;
	}
}

