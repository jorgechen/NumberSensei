package numbersense.model.question.exponential;

import com.mgeorgechen.numbersense.model.level.LevelVisitor;
import com.mgeorgechen.numbersense.model.number.ANumber;
import com.mgeorgechen.numbersense.model.number.WholeNumber;
import com.mgeorgechen.numbersense.model.question.QuestionDescription;
import numbersense.model.question.Question;

/**
 * @author George Chen
 * @since 12/18/11 6:11 PM
 */
public class Square extends Exponential {

	@Override
	public Question.Category getCategory() {
		return Question.Category.EXPONENTIAL;
	}

	@Override
	public QuestionDescription getDescription() {
		String question = base + "^" + exponent;
		return new QuestionDescription(question);
	}

	@Override
	public boolean solve(ANumber number) {
		return answer.equalsExactly(number);
	}

	@Override
	public void accept(LevelVisitor levelVisitor) {

		answer = new WholeNumber(Math.round(Math.pow(base, exponent)));
	}
}
