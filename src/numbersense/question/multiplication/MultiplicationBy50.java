package numbersense.question.multiplication;

/**
 * @author George Chen
 * @since 8/31/12 10:03 PM
 */
public class MultiplicationBy50 extends MultiplicationBy5{

	@Override
	protected void initialize(int lower, int upper) {
		super.initialize(lower, upper);
		right = 50;
	}

}
