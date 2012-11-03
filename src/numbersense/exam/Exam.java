package numbersense.exam;

import numbersense.exam.level.DifficultyLevel;
import numbersense.question.Question;
import numbersense.question.bases.BaseConversion;
import numbersense.question.exponential.Square;
import numbersense.question.memorization.PrimeNumber;
import numbersense.question.memorization.RomanNumeral;
import numbersense.question.memorization.RomanNumeralFromArabic;
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


	protected int countQuestions;
	protected Question[] list;

	public Exam(Composition composition) {
		this(composition.countRemainingRules());

		//Generate a series of expressions based on the composition given
		int i = 0;
		while (0 < composition.countRemainingRules()) {
			Rule rule = composition.removeNextRandomRule();
			Question newOne = createQuestion(rule.difficultyLevel, rule.category);

			this.list[i] = newOne;
			i++;
		}

		replaceDuplicates(list);

		//TODO give a proportional chance for each rule according to their proportion of problems in the composition
	}

	public Exam(int countQuestions, DifficultyLevel level, Category category) {
		this(countQuestions);
		list = new Question[countQuestions];

		for (int i = 0; i < countQuestions; i++) {
			Question q = createQuestion(level, category);
			list[i] = q;
		}

		replaceDuplicates(list);
	}

	public Exam(int countQuestions) {
		this.countQuestions = countQuestions;
		this.list = new Question[countQuestions];
	}

	public Exam() {
		this(DEFAULT_COUNT_QUESTIONS);
		//TODO make a real practice test, randomly generated with different expressions from 1-80
	}

	public static void replaceDuplicates(Question[] expressions) {

		//TODO optimize with pre-existing expressions to avoid duplicates
	}

	public static Question createQuestion(DifficultyLevel level, Category category) {
		Question question;
		switch (category) {
		case BASE_CONVERSION:
			question = new BaseConversion();
			break;
		case PRIME_NUMBER:
			question = new PrimeNumber();
			break;
		case ROMAN_NUMERAL:
			question = new RomanNumeral();
			break;
		case ARABIC_TO_ROMAN:
			question = new RomanNumeralFromArabic();
			break;
		case MULTIPLICATION_FOIL:
			question = new MultiplicationFOIL();
			break;
		case MULTIPLICATION_ALMOST_100:
			question = new MultiplicationAlmost100();
			break;
		case MULTIPLICATION_BY_11:
			question = new MultiplicationBy11();
			break;
		case MULTIPLICATION_BY_101:
			question = new MultiplicationBy101();
			break;
		case MULTIPLICATION_BY_5:
			question = new MultiplicationBy5();
			break;
		case MULTIPLICATION_BY_50:
			question = new MultiplicationBy50();
			break;
		case MULTIPLICATION_BY_25:
			question = new MultiplicationBy25();
			break;
		case MULTIPLICATION_BY_125:
			question = new MultiplicationBy125();
			break;
		case SQUARE:
			question = new Square();
			break;
		case ORDER_OF_OPERATION:
			question = new OrderOfOperation();
			break;
		//TODO add more categories

		case NOT_A_TRICK:
		default:
			question = Question.SAMPLE;
			break;
		}

		level.accept(question); // Gets the
		return question;
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
			Question q1 = list[i];
			Question q2 = list[half + i];
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
			Question q = list[i];
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
			Question q = list[i];
			String d = q.getSolution().toText();

			s += (i + 1) + ". " + d + "\n";
		}
		return s;
	}


}
