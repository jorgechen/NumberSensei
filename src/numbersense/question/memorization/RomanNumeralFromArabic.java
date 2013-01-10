package numbersense.question.memorization;

import numbersense.exam.Category;
import numbersense.exam.expression.number.WholeNumber;
import numbersense.exam.level.Level16;
import numbersense.exam.level.Level32;
import numbersense.exam.level.Level48;
import numbersense.question.Question;
import numbersense.question.QuestionDescription;
import numbersense.question.Solution;
import numbersense.utility.Randomizer;

/**
 * @author George Chen
 * @since 10/20/12 11:23 AM
 */
public class RomanNumeralFromArabic extends Question {

	private WholeNumber problem;

	@Override
	public Category getCategory() {
		return Category.ARABIC_TO_ROMAN;
	}

	@Override
	public Solution getSolution() {
		return Solution.create(RomanNumeral.toRomanNumeral(problem.getValue()));
	}

	@Override
	public QuestionDescription getDescription() {
		return QuestionDescription.create(problem.toString(), "(Roman numeral)");
	}

	private void initialize(int upper) {
		//NOTE: anything higher than 4000 will require more than a text string
		int i = Randomizer.random(upper) + 1; //no roman numeral for 0
		problem = new WholeNumber(i);
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
