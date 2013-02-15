package numbersense;

import numbersense.exam.Category;
import numbersense.exam.Exam;
import numbersense.exam.Composition;
import numbersense.exam.Rule;
import numbersense.exam.level.DifficultyLevel;
import numbersense.exam.level.Level16;
import numbersense.exam.level.Level32;
import numbersense.exam.level.Level48;
import numbersense.utility.Debugger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
																  new Rule(Category.MULTIPLICATION_SLIGHTLY_GREATER_THAN_100, dl16, 8),
																  new Rule(Category.MULTIPLICATION_SLIGHTLY_LESS_THAN_100, dl16, 8),
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

			Composition c1 = new Composition(new Rule[]{
													   new Rule(Category.MULTIPLICATION_BY_NUMBER_BETWEEN_12_AND_19, dl16, 8),
			});
			Composition c2 = new Composition(new Rule[]{
													   new Rule(Category.MULTIPLICATION_BY_NUMBER_BETWEEN_12_AND_19, dl16, 20),
													   new Rule(Category.GCD, dl48, 8),
													   new Rule(Category.SQUARE_NUMBER_ENDING_IN_5, dl48, 8),
//																new Rule(Category.FACTORIAL, dl48, 8),
			});
			Composition c3 = new Composition(new Rule[]{
													   new Rule(Category.SQUARE_NUMBER_ENDING_IN_5, dl16, 8),
			});

//			Composition c11 = Composition.create(new Rule(Category.MULTIPLICATION_BY_5, dl16, 8));

			Exam[] exams = {
//						   new Exam(Composition.create(new Rule(Category.GCD, dl16, 20))),
//						   new Exam(Composition.create(new Rule(Category.MULTIPLICATION_BY_5, dl16, 8))),
//						   new Exam(Composition.create(new Rule(Category.MULTIPLICATION_BY_25, dl16, 8))),
//						   new Exam(Composition.create(new Rule(Category.MULTIPLICATION_BY_11, dl16, 8))),
//						   new Exam(Composition.create(new Rule(Category.MULTIPLICATION_BY_11, dl32, 8))),
//						   new Exam(Composition.create(new Rule(Category.MULTIPLICATION_BY_11, dl48, 8))),
//						   new Exam(Composition.create(new Rule(Category.MULTIPLICATION_BY_12, dl16, 8))),
//						   new Exam(Composition.create(new Rule(Category.MULTIPLICATION_BY_12, dl32, 8))),
//						   new Exam(Composition.create(new Rule(Category.MULTIPLICATION_BY_12, dl48, 8))),
//						   new Exam(Composition.create(new Rule(Category.MULTIPLICATION_BY_101, dl32, 8))),
//						   new Exam(Composition.create(new Rule(Category.MULTIPLICATION_SLIGHTLY_GREATER_THAN_100, dl16, 8))),
//						   new Exam(Composition.create(new Rule(Category.MULTIPLICATION_SLIGHTLY_LESS_THAN_100, dl16, 8))),
//						   new Exam(Composition.create(new Rule(Category.ARABIC_TO_ROMAN, dl32, 8))),
//						   new Exam(Composition.create(new Rule(Category.SQUARE, dl32, 8))),
//						   new Exam(Composition.create(new Rule(Category.MULTIPLICATION_FOIL, dl16, COUNT * 3))),
//						   new Exam(Composition.create(new Rule(Category.MULTIPLICATION_FOIL, dl32, COUNT * 3))),
//						   new Exam(Composition.create(new Rule(Category.MULTIPLICATION_FOIL, dl48, COUNT * 3))),

//						   new Exam(COUNT, new Level16(), Category.ARABIC_TO_ROMAN),
//						   new Exam(COUNT, new Level48(), Category.PRIME_NUMBER),

//						   new Exam(COUNT, new Level16(), Category.MULTIPLICATION_BY_5),
//						   new Exam(COUNT, new Level16(), Category.MULTIPLICATION_BY_50),
//						   new Exam(COUNT, new Level16(), Category.MULTIPLICATION_BY_25),
//						   new Exam(COUNT, new Level32(), Category.MULTIPLICATION_BY_25),
//						   new Exam(COUNT, new Level16(), Category.MULTIPLICATION_BY_125),
//						   new Exam(COUNT, new Level32(), Category.MULTIPLICATION_BY_125),
//						   new Exam(COUNT, new Level48(), Category.MULTIPLICATION_BY_125),

//						   new Exam(COUNT, new Level16(), Category.MULTIPLICATION_BY_11),
//						   new Exam(COUNT, new Level16(), Category.MULTIPLICATION_BY_101),
//						   new Exam(COUNT, new Level32(), Category.MULTIPLICATION_BY_101),

//						   new Exam(COUNT, new Level32(), Category.MULTIPLICATION_SLIGHTLY_GREATER_THAN_100),
//						   new Exam(COUNT, new Level32(), Category.SQUARE),
//						   new Exam(COUNT, new Level16(), Category.CUBE),

//						   new Exam(COUNT, new Level16(), Category.MULTIPLICATION_FOIL),
//						   new Exam(COUNT, new Level32(), Category.MULTIPLICATION_FOIL),
//						   new Exam(COUNT, new Level48(), Category.MULTIPLICATION_FOIL),


//						   new Exam(composition16),
//						   new Exam(composition32),
//						   new Exam(composition48),
						   new Exam(c1),
						   new Exam(c1),
						   new Exam(c1),
						   new Exam(c3),
						   new Exam(c3),
						   new Exam(c3),
						   new Exam(c2)
			};


			String filePrefix = "practice_and_solution_";
			String fileExtension = ".txt";

			saveInOneFile(exams, filePrefix, fileExtension);
//			saveMultipleFiles(exams, filePrefix, fileExtension);
		}
	}

	public static void saveInOneFile(Exam[] exams, String filePrefix, String fileExtension) {
		String all = "";
		for (int i = 0; i < exams.length; i++) {
			Exam exam = exams[i];

			// Get questions
			String data = exam.toString();

			// Get solutions
			String solution = exam.toSolutionString();

			all += data + "\n" + solution + "\n";
		}

		saveToFile(all, filePrefix + fileExtension);
	}

	public static void saveMultipleFiles(Exam[] exams, String filePrefix, String fileExtension) {
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
