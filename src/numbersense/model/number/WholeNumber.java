package numbersense.model.number;

/**
 * Whole value values
 *
 * @author George Chen
 * @since 12/20/11 12:56 AM
 */
public class WholeNumber extends ANumber {
	public int value;

	public WholeNumber(int value) {
		this.value = value;
	}

	@Override
	public boolean equalsExactly(ANumber number) {
		if (number instanceof WholeNumber) {
			WholeNumber other = (WholeNumber) number;
			return this.value == other.value;
		}
		return false;
	}

	@Override
	public String toString() {
		return "" + value;
	}
}
