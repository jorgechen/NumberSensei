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
 * @since 10/20/12 11:01 AM
 */
public class RomanNumeral extends Question {

	public static String toArabicNumeral(String roman) {
			//I V X  L  C   D   M
			//1 5 10 50 100 500 1000
			String s = "";
			return s;
		}

	////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////

	private WholeNumber wholeNumber;

	@Override
	public Category getCategory() {
		return Category.ROMAN_NUMERAL;
	}

	@Override
	public Solution getSolution() {
		return null; //TODO
	}

	@Override
	public QuestionDescription getDescription() {
		return null; //TODO
	}


	private void initialize(int upper) {
		int i = Randomizer.random(upper);
		wholeNumber = new WholeNumber(i);
	}

	public void visit(Level16 level) {
		initialize(100);
	}

	public void visit(Level32 level) {
		initialize(1000);
	}

	public void visit(Level48 level) {
		initialize(5000);
	}
}
