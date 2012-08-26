package numbersense.model;

import numbersense.model.level.DifficultyLevel;
import numbersense.model.question.Question;
import numbersense.model.question.multiplication.MultiplicationAlmost100;
import numbersense.model.question.multiplication.MultiplicationBy125;
import numbersense.model.question.multiplication.MultiplicationBy25;
import numbersense.model.question.multiplication.MultiplicationBy5;
import numbersense.util.D;

import java.nio.DoubleBuffer;

/**
 * Each exam comprises a set of problems.
 *
 * Variable parameters:
 * - difficulty level
 * - number of questions
 * - categories of questions
 *
 * The exam should be flexible.
 * @author George Chen
 * @since 12/19/11 2:40 PM
 */
public class Exam {
	public static final int DEFAULT_COUNT_QUESTIONS = 20;
	public static final int MAX_LENGTH_OF_QUESTION = 30;

	private int countQuestions;
	private Question[] questions;


	public Exam(int countQuestions) {
		D.p("Instantiated Exam(countQuestions=" + countQuestions + ")");
		this.countQuestions = countQuestions;
		questions = new Question[countQuestions];
	}

	public Exam() {
		this(DEFAULT_COUNT_QUESTIONS);
	}

	public Exam(DifficultyLevel level, Category category) {
		this();

		for (int i = 0; i < countQuestions; i++) {
			Question q = createQuestion(level, category);
			D.p(i + ". " + q.getDescription());
			questions[i] = q;
			//TODO optimize with pre-existing questions to avoid duplicates
		}
	}

	private Question createQuestion(DifficultyLevel level, Category category) {
		Question question = Question.SAMPLE;
		switch (category) {
		case MULTIPLICATION_ALMOST_100:
			question = new MultiplicationAlmost100();
			break;
		case MULTIPLICATION_BY_5:
			question = new MultiplicationBy5();
			break;
		case MULTIPLICATION_BY_25:
			question = new MultiplicationBy25();
			break;
		case MULTIPLICATION_BY_125:
			question = new MultiplicationBy125();
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

	public String toHTML() {
		String html = "";

		int half = countQuestions / 2;
		for (int i = 0; i < half; i++) {
			Question q1 = questions[i];
			Question q2 = questions[half + i];
			String d1 = q1.getDescription().toStringWithLength(MAX_LENGTH_OF_QUESTION);
			String d2 = q2.getDescription().toStringWithLength(MAX_LENGTH_OF_QUESTION);
			html += tag("tr", tag("td", d1) + tag("td", d2));
		}

		html = tag("table", html, new String[]{"width='100%'"});
		return tag("html", html);
	}
}
