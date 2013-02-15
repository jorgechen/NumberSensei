package numbersense.question.factors;

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
 * @since 1/26/13 10:53 AM
 */
public class GCD extends Question {

	public static int findGCD(int a, int b) {
		//TODO optimize this, need a findListOfFactors()
		int min = Math.min(a, b);

		int gcd = 1;
		for (int i = gcd; i < min; i++) {
			if (a % i == 0 && b % i == 0) {
				gcd = i;
			}
		}

		return gcd;
	}

	protected WholeNumber a;
	protected WholeNumber b;
	protected WholeNumber gcd;

	@Override
	public Category getCategory() {
		return Category.GCD;
	}

	@Override
	public Solution getSolution() {
		return Solution.create(gcd);
	}

	@Override
	public QuestionDescription getDescription() {
		return QuestionDescription.create("Find the GCD of " + a.getValue() + " and " + b.getValue());
	}

	private void initialize() {
		int lower = 6;
		int upper = 100;
		a = new WholeNumber(Randomizer.random(lower, upper));
		b = new WholeNumber(Randomizer.random(lower, upper));
		gcd = new WholeNumber(findGCD(a.getValue(), b.getValue()));
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
