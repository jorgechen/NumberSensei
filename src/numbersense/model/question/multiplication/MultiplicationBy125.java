package numbersense.model.question.multiplication;

/**
 * @author George Chen
 * @since 8/25/12 6:23 PM
 */
public class MultiplicationBy125 extends MultiplicationBy5 {

	@Override
	protected void initialize(int lower, int upper) {
		super.initialize(lower, upper);
		b = 125;
	}
}
