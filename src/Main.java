import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static Scanner console = new Scanner(System.in);

	public static PrintStream out = System.out;

	public static void main(String[] args) throws FileNotFoundException {
		out.println("Welcome to the dampety solver.");
		out.println();

		out.print("What is the name of the dictionary file? ");
		Scanner input = new Scanner(new File(console.nextLine()));

		List<String> dictionary = new ArrayList<String>();
		while (input.hasNextLine()) {
			dictionary.add(input.nextLine());
		}

		List<String> dictionary2 = Collections.unmodifiableList(dictionary);
		Solver solver = new Solver(dictionary2);
		String phrase;
		do {
			out.println();
			out.print("phrase to scramble (return to quit)? ");
			phrase = console.nextLine();
			if (phrase.length() != 0) {
				out.print("Max words to include (0 for no max)? ");
				int max = console.nextInt();
				console.nextLine(); 
				solver.print(phrase, max);
			}
		} while (phrase.length() > 0);

		input.close();

	}
}