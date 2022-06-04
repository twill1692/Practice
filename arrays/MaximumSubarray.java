//Given an integer array nums, find the contiguous subarray 
//(containing at least one number) which has the largest sum
//and return its sum.
//A subarray is a contiguous part of an array.
//a maximum subarray is the entire array.

public class MaximumSubarray {

	int[] nums = { -1, -3, 4, 2 };

//	 Brute force, O(n^2) solution. Not ideal.
//	public int findMaxSubArray(int[] array) {
//		int max = Integer.MIN_VALUE;
//		for (int i = 0; i < array.length; i++) {
//			int sum = 0;
//			for (int j = i; j < array.length; j++) {
//				sum += array[j];
//				max = Math.max(max, sum);
//			}
//		}
//		return max;
//	}

//	 Kadane's Algorithm O(n)
	public int findMaxSubArray(int[] array) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			if (sum < 0) {
				sum = 0;
			}
			sum += array[i];
			max = Math.max(max, sum);
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaximumSubarray myClass = new MaximumSubarray();
		int num = myClass.findMaxSubArray(myClass.nums);
		System.out.println(num);
	}

}
