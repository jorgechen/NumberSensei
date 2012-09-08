package numbersense;

import numbersense.model.Category;
import numbersense.model.Exam;
import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.util.D;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Compile in cmd, from the root project directory:
 * <p/>
 * javac src/numbersense/Driver.java  -sourcepath src -classpath bin -d bin
 * java -classpath bin numbersense.Driver "filename.html"
 *
 * @author George Chen
 * @since 8/13/12 6:52 PM
 */
public class Driver {
	public static int MAX_LENGTH = 20;

	public static void main(String[] args) {
		if (args.length != 0) {
			initialize(args);
		} else {
			/////////////////////////
			// Hard code
			/////////////////////////

			Exam[] exams = {
//						   new Exam(20, new Level16(), Category.MULTIPLICATION_BY_5),

//						   new Exam(20, new Level16(), Category.MULTIPLICATION_BY_50),

//						   new Exam(20, new Level16(), Category.MULTIPLICATION_BY_25),
//						   new Exam(20, new Level32(), Category.MULTIPLICATION_BY_25),

//						   new Exam(20, new Level16(), Category.MULTIPLICATION_BY_125),
//						   new Exam(20, new Level32(), Category.MULTIPLICATION_BY_125),

						   new Exam(20, new Level16(), Category.MULTIPLICATION_BY_11),
						   new Exam(20, new Level32(), Category.MULTIPLICATION_BY_11),

						   new Exam(20, new Level16(), Category.SQUARE)
			};

			String filePrefix = "practice";
			String fileExtension = ".txt";

			for (int i = 0; i < exams.length; i++) {
				Exam exam = exams[i];

				String data = exam.toString();
				String path = System.getProperty("user.dir") + File.separator + filePrefix + i + fileExtension;
				D.p("Saving exam to " + path);
				saveToFile(data, path);

				String solution = exam.toSolutionString();
				String pathSolution = path.replaceFirst("practice", "solution");
				D.p("Saving answers to " + pathSolution);
				saveToFile(solution, pathSolution);

			}

		}
	}

	public static void initialize(String[] args) {
		String fileName = "test.html";
		if (args.length > 0) {
			fileName = args[0];

			for (int i = 0; i < args.length; i++) {

			}
		}


		//TODO
	}


	public static void saveToFile(String data, String path) {
		try {
			PrintWriter writer = new PrintWriter(path);
			writer.print(data);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
