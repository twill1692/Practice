
/*242. Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true*/
import static java.lang.System.out;

import java.util.Arrays;

public class ValidAnagram {
	private static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		boolean anagram = false;
		int size = s1.length();
		char[] charArray1 = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();
		int[] helperArray1 = new int[26];
		int[] helperArray2 = new int[26];

		for (int i = 0; i < size; i++) {
			helperArray1[charArray1[i] - 'a']++;
			helperArray2[charArray2[i] - 'a']++;
		}
		out.println(Arrays.equals(helperArray1, helperArray2));

		return anagram;
	}

	public static void main(String[] args) {
		String s1 = "rat";
		String s2 = "car";
		out.println("Is anagram? " + isAnagram(s1, s2));
	}

}
