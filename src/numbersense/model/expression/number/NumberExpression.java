package numbersense.model.expression.number;

import numbersense.model.expression.Expression;

/**
 * Number classes make it easier to represent mathematical amounts specific to Number Sense.
 *
 * @author George Chen
 * @since 12/23/11 12:59 PM
 */
abstract public class NumberExpression extends Expression {

	/**
	 * Compares equality between any number wrapper objects
	 *
	 * @param number
	 * @return
	 */
	abstract public boolean equalsExactly(NumberExpression number);

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
}
