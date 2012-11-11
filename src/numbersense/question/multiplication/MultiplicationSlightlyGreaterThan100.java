package numbersense.question.multiplication;

import numbersense.exam.Category;
import numbersense.exam.expression.Multiplication;
import numbersense.exam.expression.number.WholeNumber;
import numbersense.exam.level.Level16;
import numbersense.exam.level.Level32;
import numbersense.exam.level.Level48;
import numbersense.question.Question;
import numbersense.question.QuestionDescription;
import numbersense.question.Solution;
import numbersense.utility.Randomizer;

/**
 * Multiplication of two numbers greater than by close to 100
 *
 * @author George Chen
 * @since 11/9/12 7:36 PM
 */
public class MultiplicationSlightlyGreaterThan100 extends Question{
	Multiplication expression;

	@Override
	public Category getCategory() {
		return Category.MULTIPLICATION_SLIGHTLY_GREATER_THAN_100;
	}

	@Override
	public Solution getSolution() {
		return Solution.create(expression);
	}

	@Override
	public QuestionDescription getDescription() {
		return QuestionDescription.create(expression.toString());
	}

	public void visit(Level16 level) {
		initialize(110);
	}

	public void visit(Level32 level) {
		initialize(110); //TODO
	}

	public void visit(Level48 level) {
		initialize(110); //TODO
	}

	private void initialize(int bound) {
		WholeNumber left = new WholeNumber(Randomizer.random(100, bound) + 1);
		WholeNumber right = new WholeNumber(Randomizer.random(100, bound) + 1);
		expression = new Multiplication(left, right);
	}
}
