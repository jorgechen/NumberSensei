package numbersense.model.level;

import numbersense.question.QuestionCreatingVisitor;

/**
 * @author George Chen
 * @since 8/11/12 2:46 PM
 */
public class Level16 implements DifficultyLevel {
	public void accept(QuestionCreatingVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Level16";
	}
}
