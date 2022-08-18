/*448. Find All Numbers Disappeared in an Array
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the 
integers in the range [1, n] that do not appear in nums.
Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Disappeared {

	/*
	 * public static List<Integer> findDisappearedNumbers(int[] nums) { Set<Integer>
	 * set = new HashSet<Integer>(); List<Integer> missing = new
	 * ArrayList<Integer>(); for (int i : nums) { set.add(i); } for (int i = 1; i <=
	 * nums.length; i++) { if (!set.contains(i)) { missing.add(i); } } return
	 * missing; }
	 */

	// LeetCode Optimized Solution
	// Pick this appart!
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		int[] theArray = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			theArray[nums[i] - 1]++;
		}
		List<Integer> missing = new ArrayList<Integer>();
		for (int i = 0; i < theArray.length; i++) {
			if (theArray[i] == 0)
				missing.add(i + 1);
		}

		return missing;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1 };
		List<Integer> answer = findDisappearedNumbers(nums);
		for (int i : answer) {
			System.out.println(i);
		}
	}

}
