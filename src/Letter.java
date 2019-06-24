public class Letter {

	private int[] letterCounters = new int[26];
	private int size;


	public Letter(String data) {
		char[] charArray = data.trim().toCharArray();
		int indexNum;
		for (char ch : charArray) {
			indexNum = countIndexNum(ch);
			if (indexNum >= 0 && indexNum <= 25) {
				letterCounters[indexNum]++;
				size++;
			}
		}
	}

	private int countIndexNum(char c) {
		c = Character.toLowerCase(c);
		int indexNum = c - 'a';
		return indexNum;
	}

	public int get(char letter) {
		if (!(Character.isAlphabetic(letter))) {
			throw new IllegalArgumentException();
		} else {
			int index = countIndexNum(letter);
			return letterCounters[index];
		}
	}

	public void set(char letter, int value) {
		if ((!(Character.isAlphabetic(letter))) || value < 0) {
			throw new IllegalArgumentException();
		} else {
			int index = countIndexNum(letter);
			size = size - letterCounters[index] + value;
			letterCounters[index] = value;
		}

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String toString() {

		String str = "[";
		char charLetter = 'a'; 
		for (int i : letterCounters) {
			for (int j = 0; j < i; j++) {
				str = str + charLetter;
			}
			charLetter = (char) (charLetter + 1);
		}
		str = str + "]"; 
		return str;
	}

	public Letter add(Letter other) {
		Letter result = new Letter("");
		int[] countFirst = this.letterCounters;
		int[] countSecond = other.letterCounters;
		for (int i = 0; i < result.letterCounters.length; i++) {
			result.letterCounters[i] = countFirst[i] + countSecond[i];
		}
		result.size = this.size + other.size;
		return result;
	}

	public Letter subtract(Letter other) {
		Letter result = new Letter("");
		int[] first = this.letterCounters;
		int[] second = other.letterCounters;
		for (int i = 0; i < result.letterCounters.length; i++) {
			result.letterCounters[i] = first[i] - second[i];
			if (result.letterCounters[i] < 0) {
				return null;
			}
		}
		result.size = this.size - other.size;
		return result;
	}

	public boolean equals(Object o) {
		if (!(o instanceof Letter)) {
			return false;
		} else {
			Letter that = (Letter) o;
			return this.toString().equals(that.toString());
		}
	}
}