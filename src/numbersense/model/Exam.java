package numbersense.model;

import numbersense.model.exam.Composition;
import numbersense.model.exam.Rule;
import numbersense.model.expression.Expression;
import numbersense.model.expression.number.WholeNumber;
import numbersense.model.level.DifficultyLevel;
import numbersense.question.exponential.Square;
import numbersense.question.multiplication.*;
import numbersense.question.other.OrderOfOperation;

/**
 * Each exam comprises a set of problems.
 * <p/>
 * Variable parameters:
 * - difficulty level
 * - number of expressions
 * - categories of expressions
 * <p/>
 * The exam should be flexible.
 *
 * @author George Chen
 * @since 12/19/11 2:40 PM
 */
public class Exam {
	public static final int DEFAULT_COUNT_QUESTIONS = 20;


	private int countQuestions;
	private Expression[] expressions;

	public Exam(Composition composition) {
		this(composition.countRemainingRules());

		//Generate a series of expressions based on the composition given
		int i = 0;
		while (0 < composition.countRemainingRules()) {
			Rule rule = composition.removeNextRandomRule();
			Expression newExpression = createQuestion(rule.difficultyLevel, rule.category);

			this.expressions[i] = newExpression;
			i++;
		}

		replaceDuplicates(expressions);

		//TODO give a proportional chance for each rule according to their proportion of problems in the composition
	}

	public Exam(int countQuestions, DifficultyLevel level, Category category) {
		this(countQuestions);
		expressions = new Expression[countQuestions];

		for (int i = 0; i < countQuestions; i++) {
			Expression q = createQuestion(level, category);
			expressions[i] = q;
		}

		replaceDuplicates(expressions);
	}

	public Exam(int countQuestions) {
		this.countQuestions = countQuestions;
		this.expressions = new Expression[countQuestions];
	}

	public Exam() {
		this(DEFAULT_COUNT_QUESTIONS);
		//TODO make a real practice test, randomly generated with different expressions from 1-80
	}

	public static void replaceDuplicates(Expression[] expressions) {

		//TODO optimize with pre-existing expressions to avoid duplicates
	}

	public static Expression createQuestion(DifficultyLevel level, Category category) {
		Expression expression;
		switch (category) {
		case MULTIPLICATION_FOIL:
			expression = new MultiplicationFOIL();
			break;
		case MULTIPLICATION_ALMOST_100:
			expression = new MultiplicationAlmost100();
			break;
		case MULTIPLICATION_BY_11:
			expression = new MultiplicationBy11();
			break;
		case MULTIPLICATION_BY_101:
			expression = new MultiplicationBy101();
			break;
		case MULTIPLICATION_BY_5:
			expression = new MultiplicationBy5();
			break;
		case MULTIPLICATION_BY_50:
			expression = new MultiplicationBy50();
			break;
		case MULTIPLICATION_BY_25:
			expression = new MultiplicationBy25();
			break;
		case MULTIPLICATION_BY_125:
			expression = new MultiplicationBy125();
			break;
		case SQUARE:
			expression = new Square();
			break;
		case ORDER_OF_OPERATION:
			expression = new OrderOfOperation();
			break;
		case NOT_A_TRICK:
		default:
			expression = WholeNumber.ZERO;
			break;
		//TODO add more categories
		}

		level.accept(expression); // Gets the
		return expression;
	}

	/**
	 * Takes a name and a tag, and returns <tag>name</tag>
	 *
	 * @param tagName
	 * @param content
	 * @return
	 */
	public static String tag(String tagName, String content) {
		return tag(tagName, content, new String[]{});
	}

	/**
	 * Takes a name, tag, and array of attributes, and returns <tag attributes>name</tag>
	 * Assumes attributes is a list such as { width='100%', border='1'}
	 *
	 * @param tagName
	 * @param content
	 * @param attributes
	 * @return
	 */
	public static String tag(String tagName, String content, String[] attributes) {
		String s = "";
		for (String attr : attributes) {
			s += " " + attr;
		}
		return "<" + tagName + s + ">\n"
			   + content
			   + "\n</" + tagName + ">\n";
	}

	/**
	 * @param maxStringLengthPerQuestion
	 * @return in HTML format, a numbered list of all expressions, numbered down in 2 columns
	 */
	public String toHTML(int maxStringLengthPerQuestion) {
		String html = "";

		int half = countQuestions / 2;
		for (int i = 0; i < half; i++) {
			Expression q1 = expressions[i];
			Expression q2 = expressions[half + i];
			String d1 = q1.getDescription().toStringWithLength(maxStringLengthPerQuestion);
			String d2 = q2.getDescription().toStringWithLength(maxStringLengthPerQuestion);

			int n = i + 1;
			html += tag("tr", tag("td", n + ". ")
							  + tag("td", d1)
							  + tag("td", (n + half) + ". ")
							  + tag("td", d2));
		}

		html = tag(
				  "table",
				  html,
				  new String[]{"width='100%'"});
		return tag("html", html);
	}

	/**
	 * @return Text of a numbered list of all expressions, one per line
	 */
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < countQuestions; i++) {
			Expression q = expressions[i];
			String d = q.getDescription().toString();

			s += (i + 1) + ". " + d + "\n";
		}
		return s;
	}

	/**
	 * @return Text of a numbered list of all solutions, one per line
	 */
	public String toSolutionString() {
		String s = "";
		for (int i = 0; i < countQuestions; i++) {
			Expression q = expressions[i];
			String d = q.evaluate().toString();

			s += (i + 1) + ". " + d + "\n";
		}
		return s;
	}


}
