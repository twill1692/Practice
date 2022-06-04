//Find minimum sub-array with given target value.
public class RandomStuff {
	private static int findSmallSub(int[] arr, int target) {
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int winStart = 0;
		for (int winEnd = 0; winEnd < arr.length; winEnd++) {
			sum += arr[winEnd];
			while (sum >= target) {
				min = Math.min(min, winEnd - winStart + 1);
				sum -= arr[winStart];
				winStart++;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[] theArray = { 4, 2, 2, 7, 8, 1, 2, 8, 10 };
		int target = 8;
		System.out.println(findSmallSub(theArray, target));
	}
}