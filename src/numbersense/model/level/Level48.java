package numbersense.model.level;

import numbersense.model.question.QuestionVisitor;

/**
 * @author George Chen
 * @since 8/11/12 2:46 PM
 */
public class Level48 implements DifficultyLevel {
	public void accept(QuestionVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Level48";
	}
}
