package numbersense.question.multiplication;

import numbersense.model.Category;
import numbersense.model.expression.Multiplication;
import numbersense.model.expression.number.WholeNumber;
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
 * @since 9/21/12 8:16 PM
 */
public class MultiplicationFOIL extends Question {

	private Multiplication expression;

	@Override
	public Category getCategory() {
		return Category.MULTIPLICATION_FOIL;
	}

	@Override
	public Solution getSolution() {
		return SolutionString.create(expression.evaluate());
	}

	@Override
	public QuestionDescription getDescription() {
		return new QuestionDescription(expression.toString());
	}

	////////////////////////////////////////////////////////////////////////////

	public static int MARKER_A = 13;
	public static int MARKER_B = 50;
	public static int MARKER_C = 75;
	public static int MARKER_D = 100;

	protected void initialize(int lower, int upper) {
		WholeNumber left = new WholeNumber(Randomizer.random(lower, upper));
		WholeNumber right = new WholeNumber(Randomizer.random(lower, upper));
		expression = new Multiplication(left, right);
	}

	public void visit(Level16 level) {
		initialize(MARKER_A, MARKER_B);
	}

	public void visit(Level32 level) {
		initialize(MARKER_A, MARKER_C);
	}

	public void visit(Level48 level) {
		initialize(MARKER_B, MARKER_D);
	}
}
