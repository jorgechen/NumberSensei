package numbersense.question.sequence;

import numbersense.model.Category;
import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.model.level.Level48;
import numbersense.question.Question;
import numbersense.question.QuestionDescription;
import numbersense.question.Solution;

/**
 * @author George Chen
 * @since 10/27/12 10:56 AM
 */
public class Sequence extends Question {

	private int countOfElements;

	@Override
	public Category getCategory() {
		return null; //TODO
	}

	@Override
	public Solution getSolution() {
		return null; //TODO
	}

	@Override
	public QuestionDescription getDescription() {
		String s = "";
		int end = Math.min(countOfElements, 3);
		for (int i = 1; i <= end; i++) {
			s += i + " + ";
		}

		s += end;

		if (countOfElements > 4) {
			s += "...";
		}

		s += " + " + countOfElements;


		return null; //TODO
	}

	public void visit(Level16 level) {
		//TODO
	}

	public void visit(Level32 level) {
		//TODO
	}

	public void visit(Level48 level) {
		//TODO
	}
}
