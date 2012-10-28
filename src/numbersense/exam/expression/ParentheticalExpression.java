package numbersense.exam.expression;

import numbersense.exam.expression.number.NumberExpression;

/**
 * @author George Chen
 * @since 9/28/12 9:11 PM
 */
public class ParentheticalExpression extends Expression {
	private Expression innerExpression;

	public ParentheticalExpression(Expression innerExpression) {
		this.innerExpression = innerExpression;
	}

	@Override
	public Expression getLeft() {
		return innerExpression.getLeft();
	}

	@Override
	public Expression getRight() {
		return innerExpression.getRight();
	}

	@Override
	public NumberExpression evaluate() {
		return innerExpression.evaluate();
	}

	@Override
	public String toString() {
		return "(" + innerExpression.toString() + ")";
	}

	@Override
	public boolean isEqualTo(Expression other) {
		boolean b = false;
		if (other instanceof ParentheticalExpression) {
			ParentheticalExpression q = (ParentheticalExpression) other;
			if (innerExpression.isEqualTo(q.innerExpression)) {
				b = true;
			}
		}
		return b;
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

