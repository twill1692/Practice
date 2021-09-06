
class BinarySearch {

	int search(int[] arr, int l, int r, int x) {

		if (l <= r) {
			// We first need to find the mid point of the array (int rounds down)
			// we add 'l' because of
			// https://www.geeksforgeeks.org/problem-binary-search-implementations/
			int mid = l + (r - l) / 2;
			// Does the middle of the array hold the searched for value?
			if (x == arr[mid]) {
				return mid;
				// If the mid value is greater than x, we then look at the left half of the
				// array, the new r
				// being the old mid -1
			} else if (arr[mid] > x) {
				return search(arr, l, mid - 1, x);
				// If the mid value was less than x, we look to the right half of the array, the
				// new l is the
				// mid +1
			} else {
				return search(arr, mid + 1, r, x);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// x is the searched for value, arr is the array, l is the floor of the array, r
		// is the max of
		// the array
		int x = 10;
		// The array must be sorted for the binary search to function
		int arr[] = { 2, 3, 4, 10, 40 };
		int l = 0;
		// arr.length gives how many elements but we need the index of that last element
		// (starts with 0)
		// so we subtract by 1
		int r = arr.length - 1;

		BinarySearch obj = new BinarySearch();
		int index = obj.search(arr, l, r, x);

		// Ternary operator
		String result = (index > -1) ? x + " is located in position " + index
				: "The value " + x + " was not found in the array";
		System.out.println(result);

	}
}