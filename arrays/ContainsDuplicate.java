/* 217. Contains Duplicate Easy
 * Given an integer array nums, return true if any value appears at 
 * least twice in the array,and return false if every element is 
 * distinct.*/

import java.util.HashSet;

public class ContainsDuplicate {

	// Bruce force O(n^2)
	// public boolean hasDuplicate(int[] nums) {
	// for(int i = 0; i < nums.length; i++) {
	// for(int j = i+1; j < nums.length; j++) {
	// System.out.println(nums[i] + " " + nums[j]);
	// if(nums[i] == nums[j]) {
	// return true;
	// }
	// }
	// }
	// return false;
	// }

// LeetCode says it's slow. Analyze. O(n^2)
// Answer:For each value in the array, map.containsValue has to search
//	the entire HashMap giving us an exponential time complexity.
//	public boolean containsDuplicate(int[] nums) {
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//O(n)		for (int i = 0; i < nums.length; i++) {
//O(n)			if (map.containsValue(nums[i])) {
//				System.out.println("theres a duplicate at " + i);
//				return true;
//			} else {
//				map.put(i, nums[i]);
//			}
//		}
//		return false;
//	}

//	HashSet was accepted. But why is this faster?
//  Answer: Its only O(n)
	public static boolean hasDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}

	public static void main(String[] args) {
		int nums[] = { 9, 4, 5, 8, 42, 999, 42 };
		System.out.println(hasDuplicate(nums));
	}
}