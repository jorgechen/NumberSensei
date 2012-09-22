package numbersense.model.question.multiplication;


import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.model.level.Level48;
import numbersense.model.number.ANumber;
import numbersense.model.number.WholeNumber;
import numbersense.model.question.Question;
import numbersense.model.question.QuestionDescription;
import numbersense.util.D;
import numbersense.util.Utility;

/**
 * @author George Chen
 * @since 12/24/11 3:01 PM
 */
abstract public class Multiplication extends Question {
	public int a;
	public int b;

	@Override
	public QuestionDescription getDescription() {
		return new QuestionDescription(this.a + " x " + this.b + " =");
	}

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
		a = Utility.RNG.nextInt(upper - lower) + lower;
		filterEasies();
	}

	/**
	 * Filter easy multiplicands and make them harder.
	 */
	protected void filterEasies() {
		for (int i = 10; i < 10000; i *= 10) {
			if (a <= i * 10 && a % i == 0) {
				a += Utility.RNG.nextInt(i);
				break;
			}
		}
	}


	@Override
	public ANumber getSolution() {
		return new WholeNumber(a * b);
	}
}
