package numbersense.exam;

import numbersense.exam.Category;
import numbersense.exam.level.DifficultyLevel;

/**
 * Used to define the contents of an exam.
 *
 * @author George Chen
 * @since 9/28/12 7:34 PM
 */
public class Rule {
	public Category category;
	public DifficultyLevel difficultyLevel;
	public int count; // number of questions of this type in the exam

	public Rule(Category category, DifficultyLevel difficultyLevel, int count) {
		this.category = category;
		this.difficultyLevel = difficultyLevel;
		this.count = count;
	}

	@Override
	public String toString() {
		return "[" + category.toString() + "," + difficultyLevel.toString() + "," + count + "]";
	}
}
