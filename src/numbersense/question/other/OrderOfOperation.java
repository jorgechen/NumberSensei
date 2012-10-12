package numbersense.question.other;

import numbersense.model.Category;
import numbersense.model.expression.Expression;
import numbersense.model.expression.number.NumberExpression;
import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.model.level.Level48;
import numbersense.question.Question;
import numbersense.question.QuestionDescription;

/**
 * @author George Chen
 * @since 9/14/12 8:26 PM
 */
public class OrderOfOperation extends Question {

	Expression expression;

	@Override
	public Category getCategory() {
		return Category.ORDER_OF_OPERATION;
	}

	@Override
	public NumberExpression getSolution() {
		return null; //TODO
	}

	@Override
	public QuestionDescription getDescription() {
		return null; //TODO
	}

	private void initialize() {
		//TODO
	}

	// 2 operations with small numbers
	public void visit(Level16 level) {

		//TODO
	}

	// 3 ops with small numbers
	public void visit(Level32 level) {
		//TODO
	}

	// 3 ops with big numbers
	public void visit(Level48 level) {
		//TODO
	}
}
