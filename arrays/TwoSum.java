// Given an array of integers, return indices of the two numbers such that they add up 
// to a specific target. You may assume that each input would have exactly one solution, and
// you may not use the same element twice.

import java.util.HashMap;
import java.util.Map;

//Below is the ideal method. Below that is the brute method I wrote.
class TwoSum {
	int[] nums = { 3, 2, 4 };
	private static final int target = 6;

	private TwoSum() {
		int[] solution = twoSum(nums, target);
	}

// We solve this problem by recognizing that we can find the two numbers we need
// to add together by first finding a complement of the value we're looking for.
// The target and the value at the current index. For example, if were looking
// for two numbers that add to 6;the target, and the current number in the index
// of 1 is the value 2; than the complement is 4 (6-2). If the complement is
// already in
//	the hashmap, than we know the index its at.
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				int a = map.get(complement);
				int b = i;
				System.out.print("Solution is at index " + a + " and at index " + b + "\n");
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

// This is the brute force method O(n^2)
// Labeled block search: {}
//	public int[] twoSum(int[] nums, int target) {
//		int[] values = new int[2];
//		search: {
//			for (int i = 0; i < nums.length; i++) {
//				for (int j = 0; j < nums.length; j++) {
//					if (i != j && (nums[i] + nums[j] == target)) {
//						values[0] = i;
//						values[1] = j;
//						break search;
//					}
//				}
//			}
//		}
//		return values;
//	}

	public static void main(String[] args) {
		new TwoSum();
	}
}