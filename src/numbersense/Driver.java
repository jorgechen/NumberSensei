package numbersense;

import numbersense.model.Category;
import numbersense.model.Exam;
import numbersense.model.exam.Composition;
import numbersense.model.exam.Rule;
import numbersense.model.level.DifficultyLevel;
import numbersense.model.level.Level16;
import numbersense.model.level.Level32;
import numbersense.model.level.Level48;
import numbersense.utility.Debugger;

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
		if (args.length > 0) {
			initialize(args);
		} else {
			/////////////////////////
			// Hard code
			/////////////////////////

			DifficultyLevel dl16 = new Level16();
			DifficultyLevel dl32 = new Level32();
			DifficultyLevel dl48 = new Level48();

			Composition composition16 = new Composition(new Rule[]{
																  new Rule(Category.MULTIPLICATION_BY_5, dl16, 8),
																  new Rule(Category.MULTIPLICATION_BY_25, dl16, 8),
																  new Rule(Category.MULTIPLICATION_BY_11, dl16, 8),
																  new Rule(Category.MULTIPLICATION_BY_101, dl16, 8),
																  new Rule(Category.MULTIPLICATION_FOIL, dl16, 8)
			});

			Composition composition32 = new Composition(new Rule[]{
																  new Rule(Category.MULTIPLICATION_BY_5, dl32, 8),
																  new Rule(Category.MULTIPLICATION_BY_25, dl32, 8),
																  new Rule(Category.MULTIPLICATION_BY_11, dl32, 8),
																  new Rule(Category.MULTIPLICATION_BY_101, dl32, 8),
																  new Rule(Category.MULTIPLICATION_FOIL, dl32, 8)
			});

			Composition composition48 = new Composition(new Rule[]{
																  new Rule(Category.MULTIPLICATION_BY_5, dl48, 8),
																  new Rule(Category.MULTIPLICATION_BY_25, dl48, 8),
																  new Rule(Category.MULTIPLICATION_BY_11, dl48, 8),
																  new Rule(Category.MULTIPLICATION_BY_101, dl48, 8),
																  new Rule(Category.MULTIPLICATION_FOIL, dl48, 8)
			});


			Exam[] exams = {
						   new Exam(20, new Level16(), Category.MULTIPLICATION_BY_5),

						   new Exam(20, new Level16(), Category.MULTIPLICATION_BY_50),

						   new Exam(20, new Level16(), Category.MULTIPLICATION_BY_25),
//						   new Exam(20, new Level32(), Category.MULTIPLICATION_BY_25),

//						   new Exam(20, new Level16(), Category.MULTIPLICATION_BY_125),
//						   new Exam(20, new Level32(), Category.MULTIPLICATION_BY_125),

						   new Exam(20, new Level16(), Category.MULTIPLICATION_FOIL),
						   new Exam(20, new Level16(), Category.SQUARE),
//						   new Exam(20, new Level32(), Category.MULTIPLICATION_FOIL),
//						   new Exam(20, new Level48(), Category.MULTIPLICATION_FOIL),



						   new Exam(composition16),
						   new Exam(composition32),
						   new Exam(composition48)
			};


			String filePrefix = "practice_and_solution_";
			String fileExtension = ".txt";

			for (int i = 0; i < exams.length; i++) {
				Exam exam = exams[i];

				// Get questions
				String data = exam.toString();

				// Get solutions
				String solution = exam.toSolutionString();

				// Make save path
				String path = System.getProperty("user.dir") + File.separator + filePrefix + i + fileExtension;

				// Save
				Debugger.p("Saving exam to " + path);

				String saveContent = data + "\n\n" + "Solutions\n" + solution;
				saveToFile(saveContent, path);

//				String pathSolution = path.replaceFirst("practice", "solution");
//				Debugger.p("Saving answers to " + pathSolution);
//				saveToFile(solution, pathSolution);

			}

		}
	}

	public static void initialize(String[] args) {
		String fileName = "test.html";

		fileName = args[0];

		for (int i = 0; i < args.length; i++) {

		}


		//TODO parse command line arguments
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
