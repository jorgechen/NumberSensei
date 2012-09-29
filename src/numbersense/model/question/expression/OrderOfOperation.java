package numbersense.model.question.expression;

import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.model.level.Level48;
import numbersense.model.number.ANumber;
import numbersense.model.number.WholeNumber;
import numbersense.model.question.Question;
import numbersense.model.question.QuestionDescription;

/**
 * @author George Chen
 * @since 9/14/12 8:26 PM
 */
abstract public class OrderOfOperation extends Question {
	Expression expression;

	// A binary tree representation
	@Override
	public QuestionDescription getDescription() {
		return new QuestionDescription(expression.getDescription());
	}

	@Override
	public ANumber getSolution() {
		return new WholeNumber(expression.solve());
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
