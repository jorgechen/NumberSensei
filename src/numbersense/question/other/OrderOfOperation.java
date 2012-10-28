package numbersense.question.other;

import numbersense.exam.Category;
import numbersense.exam.expression.*;
import numbersense.exam.expression.number.WholeNumber;
import numbersense.exam.level.Level16;
import numbersense.exam.level.Level32;
import numbersense.exam.level.Level48;
import numbersense.question.Question;
import numbersense.question.QuestionDescription;
import numbersense.question.Solution;
import numbersense.question.SolutionString;
import numbersense.utility.Constants;
import numbersense.utility.Randomizer;

/**
 * @author George Chen
 * @since 9/14/12 8:26 PM
 */
public class OrderOfOperation extends Question {
	Expression expression;

	@Override
	public Category getCategory() {
		return Category.ORDER_OF_OPERATION;
	}

	@Override
	public Solution getSolution() {
		return SolutionString.create(expression.evaluate());
	}

	@Override
	public QuestionDescription getDescription() {
		return new QuestionDescription(expression.toString() + Constants.SIGN_EQUAL);
	}

	private void initialize() {
		//TODO
	}

	public void randomizeExpression(BinaryExpression be, int count, ExpressionFactory factory) {
		if (count == 1) {

			// Generate one last expression
			BinaryExpression last = factory.generateRandomBinaryExpression();

			Expression used = factory.enclosePossibleParenthesis(last, 2);

			if (Randomizer.coinFlip()) {
				be.setLeft(used);
			} else {
				be.setRight(used);
			}
		} else if (count > 1) {
			if (Randomizer.coinFlip()) {
				// Generate one child ONLY
				BinaryExpression binaryExpression = factory.generateRandomBinaryExpression();

				Expression child = factory.enclosePossibleParenthesis(binaryExpression, count - 1);

				if (Randomizer.coinFlip()) {
					be.setLeft(child);
				} else {
					be.setRight(child);
				}

				randomizeExpression(binaryExpression, count - 1, factory);

			} else {
				//Generate both left and right
				BinaryExpression a = factory.generateRandomBinaryExpression();
				BinaryExpression b = factory.generateRandomBinaryExpression();

				int leftCount = Randomizer.random(count);
				int rightCount = count - leftCount;

				be.setLeft(factory.enclosePossibleParenthesis(a, leftCount));
				be.setRight(factory.enclosePossibleParenthesis(b, rightCount));

				randomizeExpression(a, leftCount, factory);
				randomizeExpression(b, rightCount, factory);
			}
		}
	}

	// 2 operations with small numbers
	public void visit(Level16 level) {
		ExpressionFactory factory = new ExpressionFactory(1, 30, 2, 10);
		this.expression = factory.generateRandomBinaryExpression();
		randomizeExpression((BinaryExpression)expression, 2, factory);
	}

	// 3 ops with small numbers
	public void visit(Level32 level) {

		//TODO
	}

	// 3 ops with big numbers
	public void visit(Level48 level) {
		//TODO
	}


	private class ExpressionFactory {

		protected int term_lower_bound;
		protected int term_upper_bound;
		protected int factor_lower_bound;
		protected int factor_upper_bound;

		public ExpressionFactory(int term_lower_bound,
								 int term_upper_bound,
								 int factor_lower_bound,
								 int factor_upper_bound) {
			this.term_lower_bound = term_lower_bound;
			this.term_upper_bound = term_upper_bound;
			this.factor_lower_bound = factor_lower_bound;
			this.factor_upper_bound = factor_upper_bound;
		}

		public BinaryExpression generateRandomBinaryExpression() {
			BinaryExpression e;

			switch (Randomizer.random(4)) {
			case 0:
				e = createAddition();
				break;
			case 1:
				e = createSubtraction();
				break;
			case 2:
				e = createMultiplication();
				break;
			default:
				e = createDivision();
				break;
			}

			return e;
		}

		private Addition createAddition() {
			return new Addition(new WholeNumber(Randomizer.random(term_lower_bound, term_upper_bound)),
							   new WholeNumber(Randomizer.random(term_lower_bound, term_upper_bound)));
		}

		private Subtraction createSubtraction() {
			Addition origin = createAddition();
			return new Subtraction(origin.evaluate(), origin.getLeft());
		}

		private Multiplication createMultiplication() {
			return new Multiplication(new WholeNumber(Randomizer.random(factor_lower_bound, factor_upper_bound)),
									 new WholeNumber(Randomizer.random(factor_lower_bound, factor_upper_bound)));
		}

		private Division createDivision() {
			Multiplication origin = createMultiplication();
			return new Division(origin.evaluate(), origin.getLeft());
		}

		public Expression enclosePossibleParenthesis(BinaryExpression binaryExpression, int count) {
			//TODO optimize how parenthesis is inserted, whether iteratively or later on after entire expression is generated
			boolean yes = false;
			if (binaryExpression instanceof Addition || binaryExpression instanceof Subtraction) {
				if (count == 3) {
					yes = Randomizer.coinFlip() && Randomizer.coinFlip(); // 25%
				} else if (count == 2) {
					yes = Randomizer.coinFlip() || Randomizer.coinFlip(); // 75%
				}
			}

			if (yes) {
				return new ParentheticalExpression(binaryExpression);
			}
			return binaryExpression;
		}
	}
}
