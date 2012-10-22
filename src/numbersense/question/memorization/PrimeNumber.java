package numbersense.question.memorization;

import numbersense.model.Category;
import numbersense.model.expression.number.WholeNumber;
import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.model.level.Level48;
import numbersense.question.Question;
import numbersense.question.QuestionDescription;
import numbersense.question.Solution;
import numbersense.utility.Randomizer;

/**
 * @author George Chen
 * @since 10/20/12 11:18 AM
 */
public class PrimeNumber extends Question{

	public static boolean isPrime(int number) {
		//TODO optimize: http://stackoverflow.com/questions/453793/which-is-the-fastest-algorithm-to-find-prime-numbers
		assert (number > 0);
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////

	private WholeNumber wholeNumber;

	@Override
	public Category getCategory() {
		return Category.PRIME_NUMBER;
	}

	@Override
	public Solution getSolution() {
		String answer = isPrime(wholeNumber.getValue()) ? "prime" : "not prime";
		return Solution.create(answer);
	}

	@Override
	public QuestionDescription getDescription() {
		return new QuestionDescription("Is " + wholeNumber.getValue() + " a prime number?");
	}

	private void initialize(int upper) {
		int i = Randomizer.random(upper);
		wholeNumber = new WholeNumber(i);
	}

	public void visit(Level16 level) {
		initialize(20);
	}

	public void visit(Level32 level) {
		initialize(50);
	}

	public void visit(Level48 level) {
		initialize(100);
	}

}
