import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Solutions {

	List<WordRank> vowelsSubStringRank = new ArrayList<>();
	List<WordRank> consonentsSubStringRank = new ArrayList<>();

	List<WordRank> vowelsPreStringRank = new ArrayList<>();
	List<WordRank> consonentsPreStringRank = new ArrayList<>();

	List<WordRank> vowelsSuffStringRank = new ArrayList<>();
	List<WordRank> consonentsSuffStringRank = new ArrayList<>();

	public List<String> prefixOfVowles(List<String> wordString) {

		for (String checkStr : wordString) {

			checkStr = checkStr.replace(".", "");
			checkStr = checkStr.replace(",", "");

			WordRank wr = new WordRank();

			wr.setWord(checkStr);
			wr.setRank(longestVowel(checkStr));
			vowelsSubStringRank.add(wr);

			WordRank wr1 = new WordRank();
			wr1.setWord(checkStr);
			wr1.setRank(longestConsonent(checkStr));
			consonentsSubStringRank.add(wr1);

			WordRank wr2 = new WordRank();
			wr2.setWord(checkStr);
			wr2.setRank(longestPreVowel(checkStr));
			vowelsPreStringRank.add(wr2);

			WordRank wr3 = new WordRank();
			wr3.setWord(checkStr);
			wr3.setRank(longestPreConsonent(checkStr));
			consonentsPreStringRank.add(wr3);

			String revcheckStr = new StringBuilder(checkStr).reverse().toString(); // Inverting the string so that we
																					// can check for prefix word and get
																					// suffix
			WordRank wr4 = new WordRank();
			wr4.setWord(checkStr);
			wr4.setRank(longestPreVowel(revcheckStr));
			vowelsSuffStringRank.add(wr4);

			WordRank wr5 = new WordRank();
			wr5.setWord(checkStr);
			wr5.setRank(longestPreConsonent(revcheckStr));
			consonentsSuffStringRank.add(wr5);
		}

		System.out.println("Vowel Substring : " + printSolution(vowelsSubStringRank));
		System.out.println("consonent Substring : " + printSolution(consonentsSubStringRank));
		System.out.println("Vowel Prefix : " + printSolution(vowelsPreStringRank));
		System.out.println("Consonent Prefix : " + printSolution(consonentsPreStringRank));
		System.out.println("Vowel Suffix : " + printSolution(vowelsSuffStringRank));
		System.out.println("Consonent Suffix : " + printSolution(consonentsSuffStringRank));

		return null;
	}

	public String printSolution(List<WordRank> words) {
		words.sort(Comparator.comparing(WordRank::getRank).reversed());
		int ik = words.get(0).getRank();
		String strb = "";
		for (WordRank wrd : words) {
			if (ik <= wrd.getRank()) {
				strb = strb + wrd.getWord() + ", ";
			}
		}

		return strb.toString();

	}

	public boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}

	public boolean isConsonant(char c) {
		return (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u');
	}

	public int longestVowel(String str) {
		int count = 0, res = 0;
		char[] s = str.toCharArray();
		for (int i = 0; i < s.length; i++) {
			if (isVowel(s[i])) {
				count++;
			} else {
				res = Math.max(res, count);
				count = 0;
			}
		}
		return Math.max(res, count);
	}

	public int longestPreVowel(String str) {
		int count = 0, res = 0;
		char[] s = str.toCharArray();
		for (int i = 0; i < s.length; i++) {
			if (isVowel(s[i])) {
				count++;
			} else {
				break;
			}
		}
		return Math.max(res, count);
	}

	public int longestConsonent(String str) {
		int count = 0, res = 0;
		char[] s = str.toCharArray();
		for (int i = 0; i < s.length; i++) {
			if (isConsonant(s[i])) {
				count++;
			} else {
				res = Math.max(res, count);
				count = 0;
			}
		}
		return Math.max(res, count);
	}

	public int longestPreConsonent(String str) {
		int count = 0, res = 0;
		char[] s = str.toCharArray();
		for (int i = 0; i < s.length; i++) {
			if (isConsonant(s[i])) {
				count++;
			} else {
				break;
			}
		}
		return Math.max(res, count);
	}

}
