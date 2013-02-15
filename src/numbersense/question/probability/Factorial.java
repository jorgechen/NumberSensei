package numbersense.question.probability;

import numbersense.exam.Category;
import numbersense.exam.expression.number.WholeNumber;
import numbersense.exam.level.Level16;
import numbersense.exam.level.Level32;
import numbersense.exam.level.Level48;
import numbersense.question.Question;
import numbersense.question.QuestionDescription;
import numbersense.question.Solution;
import numbersense.utility.Randomizer;

/**
 * @author George Chen
 * @since 1/26/13 9:42 AM
 */
public class Factorial extends Question {
	public static int computeFactorial(int n) {
		if (n <= 1) {
			return n;
		}
		return n * computeFactorial(n - 1);
	}


	protected WholeNumber answer;
	protected WholeNumber factorial;

	public Factorial() {
		this.factorial = WholeNumber.ONE;
	}

	public Factorial(WholeNumber factorial) {
		this.factorial = factorial;
	}

	public Factorial(int factorial) {
		this.factorial = new WholeNumber(factorial);
		this.answer = new WholeNumber(computeFactorial(factorial));
	}

	@Override
	public Category getCategory() {
		return Category.FACTORIAL;
	}

	@Override
	public Solution getSolution() {
		return Solution.create(answer);
	}

	@Override
	public QuestionDescription getDescription() {
		return QuestionDescription.create(factorial.getValue() + "!");
	}

	private void initialize() {
		factorial = new WholeNumber(Randomizer.random(3, 10));
	}

	public void visit(Level16 level) {
		initialize();
	}

	public void visit(Level32 level) {
		initialize();
	}

	public void visit(Level48 level) {
		initialize();
	}
}
