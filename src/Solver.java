import java.util.ArrayList;
import java.util.List;

public class Solver {

	private List<String> dictionary;
	private Inventory inputPhrase;
	private List<String> sortedInventory;
	private List<String> anagramSolution = new ArrayList<String>();

	public Solver(List<String> list) {
		dictionary = list;
	}

	public void print(String s, int max) {
		if (max < 0) {
			throw new IllegalArgumentException();
		} else {
			inputPhrase = new Inventory(s);
			sortInventory();
			if (inputPhrase.isEmpty()) {
				printOut();
			}

	
			if (max == 1) {
				for (String w1 : sortedInventory) {
					Inventory word1 = new Inventory(w1);
					if (word1.equals(inputPhrase)) {
						anagramSolution.add(w1);
						printOut();
						anagramSolution.remove(w1);
					}
				}
			} else { 
				String inputPhrase1;
				Inventory anagram;
				for (String w2 : sortedInventory) {
					Inventory word2 = new Inventory(w2);
					if (inputPhrase.subtract(word2) != null) {
						anagramSolution.add(w2);
						anagram = inputPhrase.subtract(word2);
						inputPhrase1 = anagram.toString();

						// When there is no maximum
						if (max == 0) {
							max = sortedInventory.size();
						}

						print(inputPhrase1, max - 1);
						anagramSolution.remove(w2);
						inputPhrase = new Inventory(s);
					}
				}
			}
		}
	}

	private void printOut() {
		if (anagramSolution.size() > 0) {
			String str = "["; 
			for (String word : anagramSolution) {
				str = str + word + ", ";
			}

			str = str.substring(0, str.length() - 2) + "]";
			Main.out.println(str); 
		}
	}

	private void sortInventory() {
		sortedInventory = new ArrayList<String>();
		for (String w : dictionary) {
			Inventory sort = new Inventory(w);
			if (inputPhrase.subtract(sort) != null) {
				sortedInventory.add(w);
			}
		}
	}
}