package numbersense.model.question.multiplication;

import numbersense.model.Category;
import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.model.level.Level48;
import numbersense.utility.Randomizer;

/**
 * @author George Chen
 * @since 9/21/12 8:16 PM
 */
public class MultiplicationFOIL extends Multiplication {

	@Override
	public Category getCategory() {
		return Category.MULTIPLICATION_FOIL;
	}

	public static int MARKER_A = 13;
	public static int MARKER_B = 50;
	public static int MARKER_C = 75;
	public static int MARKER_D = 100;

	protected void initialize(int lower, int upper) {
		a = Randomizer.random(lower, upper);
		b = Randomizer.random(lower, upper);
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
