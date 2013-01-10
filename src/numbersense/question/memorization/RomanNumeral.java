package numbersense.question.memorization;

import numbersense.exam.Category;
import numbersense.exam.expression.number.WholeNumber;
import numbersense.exam.level.Level16;
import numbersense.exam.level.Level32;
import numbersense.exam.level.Level48;
import numbersense.question.Question;
import numbersense.question.QuestionDescription;
import numbersense.question.Solution;
import numbersense.utility.Constants;
import numbersense.utility.Randomizer;

/**
 * I  V  X  L   C   D    M
 * 1  5 10 50 100 500 1000
 *
 * @author George Chen
 * @since 10/20/12 11:01 AM
 */
public class RomanNumeral extends Question {

	public static String toRomanNumeral(int i) {
		assert (i > 0);
		String roman = "";
		int n;
		n = (i / 100) % 10;
		roman += helper(n, Constants.Roman.HUNDRED, Constants.Roman.FIVE_HUNDRED, Constants.Roman.THOUSAND);
		n = (i / 10) % 10;
		roman += helper(n, Constants.Roman.TEN, Constants.Roman.FIFTY, Constants.Roman.HUNDRED);
		n = (i / 1) % 10;
		roman += helper(n, Constants.Roman.ONE, Constants.Roman.FIVE, Constants.Roman.TEN);
		return roman;
	}

	private static String helper(int i, String one, String five, String ten) {
		assert (0 < i);
		assert (i < 10);
		String s = "";

		switch (i) {
		case 4:
			s += one + five;
			break;
		case 5:
		case 6:
		case 7:
		case 8:
			s += five;
			break;
		case 9:
			s += one + ten;
			break;
		}

		switch (i % 5) {
		case 3:
			s += one;
		case 2:
			s += one;
		case 1:
			s += one;
			break;
		}

		return s;
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////

	private WholeNumber solution;

	@Override
	public Category getCategory() {
		return Category.ROMAN_NUMERAL;
	}

	@Override
	public Solution getSolution() {
		return Solution.create(solution);
	}

	@Override
	public QuestionDescription getDescription() {
		return QuestionDescription.create(RomanNumeral.toRomanNumeral(solution.getValue()), "(Arabic numeral)");
	}


	private void initialize(int upper) {
		int i = Randomizer.random(upper);
		solution = new WholeNumber(i);
	}

	public void visit(Level16 level) {
		initialize(100);
	}

	public void visit(Level32 level) {
		initialize(1000);
	}

	public void visit(Level48 level) {
		initialize(3999);
	}
}
