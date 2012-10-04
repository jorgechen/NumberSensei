package numbersense.model.question;


import numbersense.model.Category;
import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.model.level.Level48;
import numbersense.model.number.ANumber;
import numbersense.model.number.WholeNumber;

/**
 * @author George Chen
 * @since 12/18/11 11:41 AM
 */
abstract public class Question implements QuestionVisitor {
	/////////////
	// Singleton
	/////////////
	public static final Question SAMPLE = new Question() {
		@Override
		public Category getCategory() {
			return Category.SAMPLE;
		}

		@Override
		public QuestionDescription getDescription() {
			return new QuestionDescription("2 x 2");
		}

		@Override
		public boolean solve(ANumber number) {
			return number.equalsExactly(new WholeNumber(4));
		}

		@Override
		public ANumber getSolution() {
			return new WholeNumber(4);
		}

		public void visit(Level16 level) {
			//nothing
		}

		public void visit(Level32 level) {
			//nothing
		}

		public void visit(Level48 level) {
			//nothing
		}
	};

	////////////
	// Members
	////////////

	abstract public Category getCategory();

	abstract public QuestionDescription getDescription();

	public boolean solve(ANumber number) {
		return number.equalsExactly(getSolution());
	}

	abstract public ANumber getSolution();

	//TODO
//	abstract public boolean isEqual(Question otherQuestion);
}
