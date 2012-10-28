package numbersense.exam.level;


import numbersense.question.QuestionCreatingVisitor;

/**
 * @author George Chen
 * @since 12/19/11 4:44 PM
 */
public interface DifficultyLevel {
	void accept(QuestionCreatingVisitor visitor);
}
