import java.util.Arrays;

//You are given two integer arrays nums1 and nums2, sorted in 
//non-decreasing order (it can't be called "increasing" as that 
//technically means each subsequent number would be larger and 
//that would precludes duplicate values eg; 123 is increasing, 
//1223 is non-decreasing), and two integers m and n, representing the 
//number of elements in nums1 and nums2 respectively.
//
//Merge nums1 and nums2 into a single array sorted in 
//non-decreasing order.

//The final sorted array should not be returned 
//by the function, but instead be stored inside the array nums1. 
//
//To accommodate this, nums1 has a length of m + n, where the first m
//elements denote the elements that should be merged, and the last n 
//elements are set to 0 and should be ignored. nums2 has a length of n.

public class MergeSortedArray {

	int[] theArray1 = { 1, 2, 2, 0, 0, 0 };
	int size1 = 3;
	int[] theArray2 = { 2, 4, 7 };
	int size2 = 3;

	// Optimized
	// Big O(m+n)
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int lastA = m - 1;
		int lastB = n - 1;
		int current = nums1.length - 1;
		while (lastA >= 0 && lastB >= 0) {
			if (nums1[lastA] > nums2[lastB]) {
				nums1[current] = nums1[lastA];
				lastA--;
			} else {
				nums1[current] = nums2[lastB];
				lastB--;
			}
			current--;
		}
		while (lastB >= 0) {
			nums1[current] = nums2[lastB];
			lastB--;
			current--;
		}
		while (lastA >= 0) {
			nums1[current] = nums1[lastA];
			lastA--;
			current--;
		}
	}

	// Big dumb solution
	// Arrays.sort O(n log(n)) n=size of array
	// Enhanced for loop is O(n)
	// Ditch least significant, overall time complexity is 0(n log(n))
	// public void merge(int[] nums1, int m, int[] nums2, int n) {
	// int endA = nums1.length - 1;
	// for (int i : nums2) {
	// nums1[endA] = i;
	// endA--;
	// }
	// Arrays.sort(nums1);
	// }

	public static void main(String[] args) {
		MergeSortedArray myClass = new MergeSortedArray();
		myClass.merge(myClass.theArray1, myClass.size1, myClass.theArray2, myClass.size2);
		for (int i : myClass.theArray1) {
			System.out.println(i);
		}
	}
}
