package numbersense.model.level;


import numbersense.model.question.QuestionVisitor;

/**
 * @author George Chen
 * @since 12/19/11 4:44 PM
 */
public interface DifficultyLevel {
	void accept(QuestionVisitor visitor);
}
