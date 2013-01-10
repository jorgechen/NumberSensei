package numbersense.question;

import numbersense.exam.Category;
import numbersense.exam.expression.Multiplication;
import numbersense.exam.expression.number.WholeNumber;
import numbersense.exam.level.Level16;
import numbersense.exam.level.Level32;
import numbersense.exam.level.Level48;

/**
 * @author George Chen
 * @since 10/7/12 11:12 AM
 */
abstract public class Question implements QuestionCreatingVisitor {

	public static final Question SAMPLE = new Question() {

		private Multiplication multiplication = new Multiplication(new WholeNumber(2), new WholeNumber(2));

		@Override
		public Category getCategory() {
			return Category.NOT_A_TRICK;
		}

		@Override
		public Solution getSolution() {
			return new SolutionString(multiplication.evaluate().toString());
		}

		@Override
		public QuestionDescription getDescription() {
			return  QuestionDescription.create(multiplication.toString());
		}

		public void visit(Level16 level) {
		}

		public void visit(Level32 level) {
		}

		public void visit(Level48 level) {
		}
	};

	abstract public Category getCategory();
	abstract public Solution getSolution();
	abstract public QuestionDescription getDescription();

}
