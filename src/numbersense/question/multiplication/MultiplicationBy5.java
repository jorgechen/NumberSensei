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
import numbersense.question.SolutionString;
import numbersense.utility.Constants;
import numbersense.utility.Randomizer;
import numbersense.utility.Tweak;

/**
 * @author George Chen
 * @since 8/23/12 9:04 PM
 */
public class MultiplicationBy5 extends Question {
	protected Multiplication expression;

	@Override
	public Category getCategory() {
		return Category.MULTIPLICATION_BY_5;
	}

	@Override
	public Solution getSolution() {
		return new SolutionString(expression.evaluate().toString());
	}

	@Override
	public QuestionDescription getDescription() {
		return QuestionDescription.create(expression.toString());
	}

	////////////////////////////////////////////////////////////////////////////

	public static int UPPER_BOUND_LEVEL_0 = 13;
	public static int UPPER_BOUND_LEVEL_16 = 100;
	public static int UPPER_BOUND_LEVEL_32 = 1000;
	public static int UPPER_BOUND_LEVEL_48 = 10000;

	public void visit(Level16 level) {
		initialize(UPPER_BOUND_LEVEL_0, UPPER_BOUND_LEVEL_16);
	}

	public void visit(Level32 level) {
		initialize(UPPER_BOUND_LEVEL_16, UPPER_BOUND_LEVEL_32);
	}

	public void visit(Level48 level) {
		initialize(UPPER_BOUND_LEVEL_32, UPPER_BOUND_LEVEL_48);
	}

	/**
	 * @param lower inclusive
	 * @param upper exclusive
	 */
	protected void initialize(int lower, int upper) {
		int a = Randomizer.random(lower, upper);
		a = Tweak.filterMultiplesOf10(a);
		WholeNumber left = new WholeNumber(a);
		WholeNumber right = new WholeNumber(5);
		expression = new Multiplication(left, right);
	}


}
