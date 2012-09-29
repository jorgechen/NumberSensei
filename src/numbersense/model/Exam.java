package numbersense.model;

import numbersense.model.exam.Composition;
import numbersense.model.exam.Rule;
import numbersense.model.level.DifficultyLevel;
import numbersense.model.level.Level16;
import numbersense.model.question.Question;
import numbersense.model.question.exponential.Square;
import numbersense.model.question.multiplication.*;

/**
 * Each exam comprises a set of problems.
 * <p/>
 * Variable parameters:
 * - difficulty level
 * - number of questions
 * - categories of questions
 * <p/>
 * The exam should be flexible.
 *
 * @author George Chen
 * @since 12/19/11 2:40 PM
 */
public class Exam {
	public static final int DEFAULT_COUNT_QUESTIONS = 20;


	private int countQuestions;
	private Question[] questions;

	public Exam(Composition composition) {
		this(composition.countRemainingRules());

		//Generate a series of questions based on the composition given
		int i = 0;
		while (0 < composition.countRemainingRules()) {
			Rule rule = composition.removeNextRandomRule();
			Question newQuestion = createQuestion(rule.difficultyLevel, rule.category);

			this.questions[i] = newQuestion;
			i++;
		}

		replaceDuplicates(questions);

		//TODO give a proportional chance for each rule according to their proportion of problems in the composition
	}

	public Exam(int countQuestions, DifficultyLevel level, Category category) {
		this(countQuestions);
		questions = new Question[countQuestions];

		for (int i = 0; i < countQuestions; i++) {
			Question q = createQuestion(level, category);
			questions[i] = q;
		}

		replaceDuplicates(questions);
	}

	public Exam(int countQuestions) {
		this.countQuestions = countQuestions;
		this.questions = new Question[countQuestions];
	}

	public Exam() {
		this(DEFAULT_COUNT_QUESTIONS);
		//TODO make a real practice test, randomly generated with different questions from 1-80
	}

	public static void replaceDuplicates(Question[] questions) {

		//TODO optimize with pre-existing questions to avoid duplicates
	}

	public static Question createQuestion(DifficultyLevel level, Category category) {
		Question question = Question.SAMPLE;
		switch (category) {
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
			//TODO
			break;

		//TODO add more categories
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
	 * @return in HTML format, a numbered list of all questions, numbered down in 2 columns
	 */
	public String toHTML(int maxStringLengthPerQuestion) {
		String html = "";

		int half = countQuestions / 2;
		for (int i = 0; i < half; i++) {
			Question q1 = questions[i];
			Question q2 = questions[half + i];
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
	 * @return Text of a numbered list of all questions, one per line
	 */
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < countQuestions; i++) {
			Question q = questions[i];
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
			Question q = questions[i];
			String d = q.getSolution().toString();

			s += (i + 1) + ". " + d + "\n";
		}
		return s;
	}


}
