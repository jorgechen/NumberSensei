package numbersense.question.bases;

import numbersense.exam.Category;
import numbersense.exam.expression.number.WholeNumber;
import numbersense.exam.level.Level16;
import numbersense.exam.level.Level32;
import numbersense.exam.level.Level48;
import numbersense.question.Question;
import numbersense.question.QuestionDescription;
import numbersense.question.Solution;

import java.util.ArrayList;

/**
 * @author George Chen
 * @since 11/2/12 10:49 PM
 */
abstract public class BaseConversion extends Question {

	public static String convertFromBase10(int decimalValue, int baseTo) {
		assert (decimalValue >= 0);
		assert (baseTo > 0);

		String number = "";
		while (decimalValue > 0) {
			decimalValue /= baseTo;
			number = (decimalValue % baseTo) + number;
		}

		return number;
	}

	protected WholeNumber value;
	protected WholeNumber baseOfQuestion;
	protected WholeNumber baseOfAnswer;


	@Override
	public Solution getSolution() {
		return Solution.create(convertFromBase10(value.getValue(), baseOfAnswer.getValue()));
	}

	@Override
	public QuestionDescription getDescription() {
		return QuestionDescription.create(convertFromBase10(value.getValue(), baseOfQuestion.getValue()));
	}

}
