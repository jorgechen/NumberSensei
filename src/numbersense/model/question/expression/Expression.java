package numbersense.model.question.expression;

/**
 * Represents anything that results in a number: integer, operation, parenthetical operation
 *
 * @author George Chen
 * @since 9/28/12 8:07 PM
 */
abstract public class Expression {

	public static Expression NULL = new Expression() {
		@Override
		public int solve() {
			return 0;
		}

		@Override
		public Expression getLeft() {
			return null;
		}

		@Override
		public Expression getRight() {
			return null;
		}

		@Override
		public String getDescription() {
			return "";
		}

	};

	abstract public int solve();

	abstract public Expression getLeft();

	abstract public Expression getRight();

	abstract public String getDescription();
}
