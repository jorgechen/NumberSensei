package numbersense;

import numbersense.model.Category;
import numbersense.model.Exam;
import numbersense.model.level.Level16;
import numbersense.util.D;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Compile in cmd, from the root project directory:
 *
 * javac src/numbersense/Driver.java  -sourcepath src -classpath bin -d bin
 * java -classpath bin numbersense.Driver "filename.html"
 *
 * @author George Chen
 * @since 8/13/12 6:52 PM
 */
public class Driver {

	public static void main(String[] args) {
		String fileName = "test.html";
		if (args.length > 0) {
			fileName = args[0];
		}

		//Create the exam
		Exam exam = new Exam(new Level16(), Category.MULTIPLICATION_BY_5);

		//Save exam
		String data = exam.toHTML();
		String path = System.getProperty("user.dir") + File.separator + fileName;
		D.p("Saving exam to " + path);
		saveToFile(data, path);
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
