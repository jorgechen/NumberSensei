package numbersense.question;

import numbersense.model.Category;
import numbersense.model.expression.number.NumberExpression;

/**
 * @author George Chen
 * @since 10/7/12 11:12 AM
 */
abstract public class Question implements QuestionCreatingVisitor {

	abstract public Category getCategory();
	abstract public NumberExpression getSolution();
	abstract public QuestionDescription getDescription();

}
