package numbersense.question.memorization;

import numbersense.model.Category;
import numbersense.model.expression.number.WholeNumber;
import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.model.level.Level48;
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
		assert (i > 0);
		String roman = "";
		roman += helper((i % 10000) / 1000, Constants.Roman.HUNDRED, Constants.Roman.FIVE_HUNDRED, Constants.Roman.THOUSAND);
		roman += helper((i % 1000) / 100, Constants.Roman.TEN, Constants.Roman.FIFTY, Constants.Roman.HUNDRED);
		roman += helper((i % 100) / 10, Constants.Roman.ONE, Constants.Roman.FIVE, Constants.Roman.TEN);
		return roman;
	}

	private static String helper(int i, String one, String five, String ten) {
//		assert (0 < i);
//		assert (i < 10);

		String s = "";

		switch (i) {
		case 4:
			return one + five;
		case 5:
			return five;
		case 9:
			return one + ten;
		}

		switch (i % 5) {
		case 1:
			s += one;
		case 2:
			s += one + one;
		case 3:
			s += one + one + one;
		}

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
		return new QuestionDescription(wholeNumber.getValue() + " =", "(Roman Numeral)");
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
