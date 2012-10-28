package numbersense.exam.expression.number;

import numbersense.exam.expression.Expression;

/**
 * Number classes make it easier to represent mathematical amounts specific to Number Sense.
 *
 * @author George Chen
 * @since 12/23/11 12:59 PM
 */
abstract public class NumberExpression extends Expression implements NumberOperator {

	abstract public boolean equalsExactly(NumberExpression number);

	////////////////////////////////////////////////////////////////////////////
	abstract public Decimal convertToDecimal();

	abstract public WholeNumber convertToWholeNumber();

	abstract public Fraction convertToFraction();

	abstract public MixedNumber convertToMixedNumber();

	////////////////////////////////////////////////////////////////////////////

	abstract public float toFloat();

	abstract public int toInt();

	////////////////////////////////////////////////////////////////////////////

	abstract public boolean isPositive();

	abstract public boolean isNegative();

	////////////////////////////////////////////////////////////////////////////

	@Override
	public Expression getLeft() {
		return null;
	}

	@Override
	public Expression getRight() {
		return null;
	}

	@Override
	public NumberExpression evaluate() {
		return this;
	}

	public NumberExpression add(NumberExpression other) {
		NumberExpression e = null;
		if (other instanceof WholeNumber) {
			e = add((WholeNumber) other);
		} else if (other instanceof Decimal) {
			e = add((Decimal) other);
		} else if (other instanceof Fraction) {
			e = add((Fraction) other);
		} else if (other instanceof MixedNumber) {
			e = add((MixedNumber) other);
		}
		return e;
	}

	public NumberExpression subtract(NumberExpression other) {
		NumberExpression e = null;
		if (other instanceof WholeNumber) {
			e = subtract((WholeNumber) other);
		} else if (other instanceof Decimal) {
			e = subtract((Decimal) other);
		} else if (other instanceof Fraction) {
			e = subtract((Fraction) other);
		} else if (other instanceof MixedNumber) {
			e = subtract((MixedNumber) other);
		}
		return e;
	}

	public NumberExpression multiply(NumberExpression other) {
		NumberExpression e = null;
		if (other instanceof WholeNumber) {
			e = multiply((WholeNumber) other);
		} else if (other instanceof Decimal) {
			e = multiply((Decimal) other);
		} else if (other instanceof Fraction) {
			e = multiply((Fraction) other);
		} else if (other instanceof MixedNumber) {
			e = multiply((MixedNumber) other);
		}
		return e;
	}

	public NumberExpression divide(NumberExpression other) {
		NumberExpression e = null;
		if (other instanceof WholeNumber) {
			e = divide((WholeNumber) other);
		} else if (other instanceof Decimal) {
			e = divide((Decimal) other);
		} else if (other instanceof Fraction) {
			e = divide((Fraction) other);
		} else if (other instanceof MixedNumber) {
			e = divide((MixedNumber) other);
		}
		return e;
	}
}
