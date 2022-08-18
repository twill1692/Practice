
/* 
3-Longest Substring Without Repeating Characters. Medium
Given a string s, find the length of the longest substring without repeating characters.
this is similar to max K distinct, only with no repeats rather than K repeats.
https://www.youtube.com/watch?v=3IETreEybaA
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstringNoRepeat {
	// Less optimized, but easier to understand.
	// public static int someFunct(String s) {
	// int max = 0;
	// int winStart = 0;
	// HashSet<Character> set = new HashSet<Character>();
	// for (int winEnd = 0; winEnd < s.length(); winEnd++) {
	// while (set.contains(s.charAt(winEnd))) {
	// set.remove(s.charAt(winStart));
	// winStart++;
	// }
	// set.add(s.charAt(winEnd));
	// max = Math.max(max, winEnd - winStart + 1);
	// }
	// return max;
	// }
	// Leet code optimed solution.

	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		int winStart = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int winEnd = 0; winEnd < s.length(); winEnd++) {
			if (map.containsKey(s.charAt(winEnd))) {
				winStart = Math.max(map.get(s.charAt(winEnd)), winStart);
			}
			max = Math.max(max, winEnd - winStart + 1);
			map.put(s.charAt(winEnd), winEnd + 1);
		}
		return max;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		// Expected output 3
		System.out.println(lengthOfLongestSubstring(s));
	}
}
