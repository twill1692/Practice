import java.util.Arrays;

/*
LeetCode #567 Medium. Given two strings s1 and s2, return true if s2 contains a permutation of s1,
or false otherwise.In other words, return true if one of s1's permutations is the substring of s2.
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
https://www.youtube.com/watch?v=6gRj_FH3MsA
*/
public class PermutationsInAString {
	/*
	 * We use two arrays two measure the elements, if they end up being equal, then
	 * s1 is a substring of s2. In this example, the window exist on the string
	 * itself, not the arrays. We are just using the arrays to determining
	 * equivalence.
	 */
	public static boolean checkInclusion1(String s1, String s2) {
		int[] arr1 = new int[26];
		int[] arr2 = new int[26];
		if (s1.length() > s2.length() || s2.length() == 0)
			return false;
		if (s1.length() == 0)
			return true;
		// fill the arrays
		for (int i = 0; i < s1.length(); i++) {
			/*
			 * An explanation: s1.charAt(i) gives you a char at the index. subtracting 'a'
			 * from it gives you its numerical postion from 0 - 26. 'a' = 97 'b' = 98, 'b' -
			 * 'a' = 1 position. We then ++ to keep track of the number of times that
			 * character appears.
			 */
			arr1[s1.charAt(i) - 'a']++;
			arr2[s2.charAt(i) - 'a']++;
		}
		for (int j = s1.length(); j < s2.length(); j++) {
			if (Arrays.equals(arr1, arr2))
				return true;
			// Pop the character from the array as we slide the window on the string.
			arr2[s2.charAt(j - s1.length()) - 'a']--;
			// Add the character to the array as we slide the window on the string.
			arr2[s2.charAt(j) - 'a']++;
		}
		if (Arrays.equals(arr1, arr2)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "eidbaooo";
		System.out.println(checkInclusion1(s1, s2));
	}

	// LeetCode optimized method.
	// public static boolean checkInclusion2(String s1, String s2) {
	// if (s1.length() > s2.length())
	// return false;
	// int[] s1map = new int[26];
	// int[] s2map = new int[26];
	// for (int i = 0; i < s1.length(); i++) {
	// s1map[s1.charAt(i) - 'a']++;
	// s2map[s2.charAt(i) - 'a']++;
	// }
	//
	// for (int i = 0; i < s2.length() - s1.length(); i++) {
	// if (matches(s1map, s2map))
	// return true;
	// s2map[s2.charAt(i + s1.length()) - 'a']++;
	// s2map[s2.charAt(i) - 'a']--;
	// }
	// return matches(s1map, s2map);
	// }
	//
	// public static boolean matches(int[] s1map, int[] s2map) {
	// for (int i = 0; i < 26; i++) {
	// if (s1map[i] != s2map[i])
	// return false;
	// }
	// return true;
	// }

}
