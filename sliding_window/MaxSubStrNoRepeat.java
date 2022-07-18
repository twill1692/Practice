import java.util.HashMap;
import java.util.Map;

/*Given a string s, find the length of the longest substring without repeating characters.*/
public class MaxSubStrNoRepeat {
	
	public static int findMaxSubstring(String str) {
		int max = 0;
		int wStart = 0;
		int duplicate = 2;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int wEnd = 0; wEnd < str.length(); wEnd++) {
			map.put(str.charAt(wEnd), map.getOrDefault(str.charAt(wEnd), 0) + 1);
			while (map.containsValue(duplicate)) {
				map.replace(str.charAt(wStart), map.get(str.charAt(wStart)) - 1);
				if (map.get(str.charAt(wStart)) == 0) {
					map.remove(str.charAt(wStart));
				}
				wStart++;
			}
			max = Math.max(max, wEnd - wStart + 1);
		}
		return max;
	}

	public static void main(String[] args) {
		String str = "pwwkew";
		System.out.println(findMaxSubstring(str));
	}
}
