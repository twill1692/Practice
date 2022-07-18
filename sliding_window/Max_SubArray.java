/*Given an integer array nums, find the contiguous subarray 
(containing at least one number) which has the largest sum
and return its sum.
A subarray is a contiguous part of an array.
a maximum subarray is the entire array.
*/

public class Max_SubArray {

	public static int findMaxSub(int[] arr) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (sum < 0) {
				sum = 0;
			}
			sum += arr[i];
			max = Math.max(max, sum);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { -1, -3, 4, 2 };
		System.out.println(findMaxSub(nums));
	}
}
