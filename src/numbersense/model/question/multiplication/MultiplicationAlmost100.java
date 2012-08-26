package numbersense.model.question.multiplication;


import numbersense.model.Category;
import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.model.level.Level48;
import numbersense.util.Utility;

/**
Multiplying Two Numbers Less Than 100, But Close To 100

A. From algebra we learn:
	(100 – a) (100 – b) = 100((100 – a) – b) + ab

B.  Using numbers instead of variables we get the following:
	1.  Find the difference between both of the numbers and 100.
	2.  Multiply these two values together and write it down.  Make sure the answer takes up 2 place values.
	3.  Subtract the difference found in step 1 of one of the numbers with the remaining number.  Write the result.

Example:  88 x 93 =_________.
a)      100 – 88 = 12.
b)      100 – 93 = 7.
c)      12 x 7 = 84.  Write 84.
d)      93 – 12 = 81.  Write 81.  (You can also use 88 – 7 = 81)
e)      The answer is 8184.

 *
 * @author George Chen
 * @since 12/24/11 3:13 PM
 */
public class MultiplicationAlmost100 extends Multiplication {

	@Override
	public Category getCategory() {
		return Category.MULTIPLICATION_ALMOST_100;
	}

	private void initialize(int bound) {
		this.a = 99 - Utility.RNG.nextInt(100 - bound);
		this.b = 99 - Utility.RNG.nextInt(100 - bound);
		this.solution = this.a * this.b;
	}

	public static int LOWER_BOUND_LEVEL_16 = 95;
	public static int LOWER_BOUND_LEVEL_32 = 90;
	public static int LOWER_BOUND_LEVEL_48 = 85;


	public void visit(Level16 level) {
		initialize(LOWER_BOUND_LEVEL_16);
	}

	public void visit(Level32 level) {
		initialize(LOWER_BOUND_LEVEL_32);
	}

	public void visit(Level48 level) {
		initialize(LOWER_BOUND_LEVEL_48);
	}
}