package numbersense.model;

import numbersense.model.level.DifficultyLevel;
import numbersense.model.level.Level16;
import numbersense.model.question.Question;
import numbersense.model.question.exponential.Square;
import numbersense.model.question.multiplication.*;
import numbersense.util.D;

import java.nio.DoubleBuffer;

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

	public Exam(int countQuestions, DifficultyLevel level, Category category) {
		this.countQuestions = countQuestions;
		questions = new Question[countQuestions];

		for (int i = 0; i < countQuestions; i++) {
			Question q = createQuestion(level, category);
			questions[i] = q;
			for (int j = 0; j < i; j++) {
			//TODO optimize with pre-existing questions to avoid duplicates
			}
		}
	}

	public Exam(int countQuestions) {
		this(countQuestions, new Level16(), Category.MULTIPLICATION_BY_5);
	}

	public Exam() {
		this(DEFAULT_COUNT_QUESTIONS);
	}

	private Question createQuestion(DifficultyLevel level, Category category) {
		Question question = Question.SAMPLE;
		switch (category) {
		case MULTIPLICATION_ALMOST_100:
			question = new MultiplicationAlmost100();
			break;
		case MULTIPLICATION_BY_11:
			question = new MultiplicationBy11();
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

		//TODO add more categories
		}

		level.accept(question); // Gets the
		return question;
	}

	public String tag(String tagName, String content) {
		return tag(tagName, content, new String[]{});
	}

	public String tag(String tagName, String content, String[] attributes) {
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
	 * @return the entire exam in HTML format, numbered down 2 columns
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

		html = tag("table",
				  html,
				  new String[]{"width='100%'"});
		return tag("html", html);
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < countQuestions; i++) {
			Question q = questions[i];
			String d = q.getDescription().toString();

			s += (i+1) + ". " + d + "\n";
		}
		return s;
	}


	public String toSolutionString() {
		String s = "";
		for (int i = 0; i < countQuestions; i++) {
			Question q = questions[i];
			String d = q.getSolution().toString();

			s += (i+1) + ". " + d + "\n";
		}
		return s;
	}
}
