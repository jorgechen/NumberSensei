package numbersense.question.exponential;

import numbersense.model.Category;
import numbersense.model.expression.ExponentialExpression;
import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.model.level.Level48;
import numbersense.question.Question;
import numbersense.question.QuestionDescription;
import numbersense.question.Solution;
import numbersense.question.SolutionString;
import numbersense.utility.Randomizer;

/**
 * @author George Chen
 * @since 12/18/11 6:11 PM
 */
public class Square extends Question {
	private ExponentialExpression exponentialExpression;

	protected void initialize(int upperBound) {
		int base = Randomizer.random1toN(upperBound);
		int exponent = 2;
		exponentialExpression = new ExponentialExpression(base, exponent);
	}

	@Override
	public Category getCategory() {
		return Category.SQUARE;
	}

	@Override
	public Solution getSolution() {
		return SolutionString.create(exponentialExpression.evaluate());
	}

	@Override
	public QuestionDescription getDescription() {
		return new QuestionDescription(exponentialExpression.toString());
	}

	public static int UPPER_BOUND_LEVEL_16 = 15;
	public static int UPPER_BOUND_LEVEL_32 = 25;
	public static int UPPER_BOUND_LEVEL_48 = 32;

	public void visit(Level16 level) {
		initialize(UPPER_BOUND_LEVEL_16);
	}

	public void visit(Level32 level) {
		initialize(UPPER_BOUND_LEVEL_32);
	}

	public void visit(Level48 level) {
		initialize(UPPER_BOUND_LEVEL_48);
	}
}
