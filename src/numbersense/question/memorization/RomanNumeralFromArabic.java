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
 * @author George Chen
 * @since 10/20/12 11:23 AM
 */
public class RomanNumeralFromArabic extends Question {

	public static String toRomanNumeral(int i) {
		//TODO fix this, returned String is wrong
		System.out.println("number=" + i);
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
//		assert (0 < i);
//		assert (i < 10);
		System.out.println("using " + i + " for " + one + "," + five + "," + ten);
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

		System.out.println("returned=" + s);
		return s;
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////

	private WholeNumber wholeNumber;

	@Override
	public Category getCategory() {
		return Category.ARABIC_TO_ROMAN;
	}

	@Override
	public Solution getSolution() {
		return Solution.create(toRomanNumeral(wholeNumber.getValue()));
	}

	@Override
	public QuestionDescription getDescription() {
		return new QuestionDescription(wholeNumber.getValue() + " =", "(Roman numeral)");
	}

	private void initialize(int upper) {
		//NOTE: anything higher than 4000 will require more than a text string
		int i = Randomizer.random(upper) + 1; //no roman numeral for 0
		wholeNumber = new WholeNumber(i);
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
