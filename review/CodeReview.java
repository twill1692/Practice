import java.util.HashMap;
import java.util.Map;

//Length of longest substring without repetitions.
public class CodeReview {

	public static int someFunct(String s) {
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
		System.out.println(someFunct(s));
	}
}