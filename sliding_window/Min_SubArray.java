//Find minimum size of sub-array with given target value.
public class Min_SubArray {
	public static int findminSub(int[] arr, int target) {
		int min = Integer.MAX_VALUE;
		int sum = 0;
		int winStart = 0;
		for (int winEnd = 0; winEnd < arr.length; winEnd++) {
			/* Now add the value at the end window index to the sum */
			sum += arr[winEnd];
			/*
			 * When we get the sub array to the size indicated by target, then we can get to
			 * work finding the min value of size of index indicated by the comparison of
			 * the current min and the size of the current window in terms of size of index.
			 * We use a while statement to indicate that once we reach the target, we want
			 * to see if we can do better by chopping values from the start of the window
			 * and still meeting the target. If we can, we can then reduce the min index
			 * size of the window and store that new value in min.
			 */
			while (sum >= target) {
				/*
				 * this is the code that is key to remember. min is the size of the sub-array
				 * the second value we are comparing is the size of the current sub-array where
				 * is the end index of the current window at minus where the start of the index
				 * of the current window plus 1, since we start at 0.
				 */
				min = Math.min(min, winEnd - winStart + 1);
				/* Begin removing the value at the start index from the sum value */
				sum -= arr[winStart];
				winStart++;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[] theArray = { 4, 2, 2, 7, 8, 1, 2, 8, 10 };
		int target = 8;
		System.out.println(findminSub(theArray, target));
	}

}
