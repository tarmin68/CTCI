import java.util.HashMap;
import java.util.Scanner;

//CTCI 16.2 Word Frequencies: 
//Design a method to find the frequency of occurrences of any given word in a
//book. What if we were running this algorithm multiple times?

public class WordFrequencies {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String book = sc.nextLine();
		String word = sc.nextLine();
		
		int freq = getWordFreq(book, word);
		System.out.println(freq);
	}

	private static int getWordFreq(String book, String word) {
		HashMap<String, Integer> wordFreqMap = new HashMap<>();
		
		String[] words = book.split(" ");
		for(int i = 0; i < words.length; i++) {
			if(wordFreqMap.containsKey(words[i])) {
				int freq = wordFreqMap.get(words[i]);
				wordFreqMap.put(words[i], freq + 1);
			}
			else {
				wordFreqMap.put(words[i], 1);
			}
		}
		
		if(wordFreqMap.containsKey(word)) {
			return wordFreqMap.get(word);
		}
		return 0;
	}
}
