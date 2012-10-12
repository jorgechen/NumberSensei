package numbersense.model.expression;

import numbersense.model.expression.number.NumberExpression;

/**
 * @author George Chen
 * @since 9/28/12 9:11 PM
 */
public class ParentheticalExpression extends Expression {
	private Expression innerExpression;

	public ParentheticalExpression(Expression innerExpression) {
		this.innerExpression = innerExpression;
	}

	/**
	 * @return first half of the expression inside parentheses
	 */
	@Override
	public Expression getLeft() {
		return innerExpression.getLeft();
	}

	/**
	 * @return second half of the expression inside parentheses
	 */
	@Override
	public Expression getRight() {
		return innerExpression.getRight();
	}

	@Override
	public NumberExpression evaluate() {
		return innerExpression.evaluate();
	}

	@Override
	public Expression copy() {
		return new ParentheticalExpression(innerExpression.copy());
	}

	public NumberExpression add(NumberExpression other) {
		return evaluate().add(other);
	}

	public NumberExpression subtract(NumberExpression other) {
		return evaluate().subtract(other);
	}

	public NumberExpression multiply(NumberExpression other) {
		return evaluate().multiply(other);
	}

	public NumberExpression divide(NumberExpression other) {
		return evaluate().divide(other);
	}
}

