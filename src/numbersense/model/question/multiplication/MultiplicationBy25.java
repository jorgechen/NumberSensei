package numbersense.model.question.multiplication;

import numbersense.util.Utility;

/**
 * @author George Chen
 * @since 8/25/12 5:42 PM
 */
public class MultiplicationBy25 extends MultiplicationBy5 {

	@Override
	protected void initialize(int lower, int upper) {
		super.initialize(lower, upper);
		b = 25;

		if (a == 25) {
			a = 18;
		}
	}
}
