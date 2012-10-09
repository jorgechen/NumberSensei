package numbersense.model.expression.number;

import numbersense.model.expression.Expression;
import numbersense.utility.Convert;

/**
 * @author George Chen
 * @since 12/20/11 12:59 PM
 */
public class Decimal extends NumberExpression {
	public double value;

	public double getValue() {
		return value;
	}

	public Decimal(double value) {
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
	public String toString() {
		return Convert.toString(value);
	}

	@Override
	public Expression copy() {
		return new Decimal(value);
	}

	public NumberExpression add(NumberExpression other) {
		NumberExpression e = null;
		if (other instanceof WholeNumber) {
			e = new Decimal(value + ((WholeNumber) other).getValue());
		} else if (other instanceof Decimal) {

		} else if (other instanceof Fraction) {

		} else if (other instanceof Fraction) {
			//TODO
		}

		return e;
	}

	public NumberExpression subtract(NumberExpression other) {
		return null; //TODO
	}

	public NumberExpression multiply(NumberExpression other) {
		return null; //TODO
	}

	public NumberExpression divide(NumberExpression other) {
		return null; //TODO
	}
}

