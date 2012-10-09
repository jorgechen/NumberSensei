package numbersense.question;

/**
 * @author George Chen
 * @since 8/11/12 7:10 PM
 */

import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.model.level.Level48;

public interface QuestionCreatingVisitor {
	void visit(Level16 level);
	void visit(Level32 level);
	void visit(Level48 level);
}
