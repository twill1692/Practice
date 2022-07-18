/*Algorithm to find longest substring length with K distinct characters.
 *Locked leetcode problem
 */

import java.util.HashMap;
import java.util.Map;

public class MaxKDistinct {
	public static int findMaxDist(char[] arr, int k) {
		int maxLength = 0;
		int winStart = 0;
		Map<Character, Integer> kMap = new HashMap<Character, Integer>();
		for (int winEnd = 0; winEnd < arr.length; winEnd++) {
			/*
			 * Start filling up the map, getOrDefault and increment if the key is already
			 * there, if not, default 0; Check max length and assign until you reach K size.
			 */
			kMap.put(arr[winEnd], kMap.getOrDefault(arr[winEnd], 0) + 1);
			/*
			 * Now that we have reached the number of distinct elements and recorded the max
			 * length up to this point, we can start removing elements from the front until
			 * we get below the k distinct element size again. At this point we continue
			 * filling and checking max length
			 */
			while (kMap.size() > k) {
				kMap.put(arr[winStart], kMap.get(arr[winStart]) - 1);
				if (kMap.get(arr[winStart]) == 0) {
					kMap.remove(arr[winStart]);
				}
				winStart++;

			}
			/*
			 * As the for loop is running and adding and not hitting the while condition, we
			 * are updating max length with each iteration of the for loop.
			 */
			maxLength = Math.max(maxLength, winEnd - winStart + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		char[] arr = { 'A', 'A', 'A', 'H', 'H', 'I', 'B', 'C' };
		// Expected output = 5.
		System.out.println(findMaxDist(arr, 2));
	}
}
