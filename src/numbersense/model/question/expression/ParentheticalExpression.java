package numbersense.model.question.expression;

import numbersense.utility.Constants;

/**
 * @author George Chen
 * @since 9/28/12 9:11 PM
 */
public class ParentheticalExpression extends Expression {
	private Expression only;

	public ParentheticalExpression(Expression onlyExpression) {
		this.only = onlyExpression;
	}

	@Override
	public int solve() {
		return only.solve();
	}

	@Override
	public Expression getLeft() {
		return only;
	}

	@Override
	public Expression getRight() {
		return Expression.NULL;
	}

	@Override
	public String getDescription() {
		return Constants.LEFT_PARENTHESIS + only.getDescription() + Constants.RIGHT_PARENTHESIS;
	}
}
