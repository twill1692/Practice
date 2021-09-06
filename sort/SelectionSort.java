
class SelectionSort {

	private void sort(int[] arr) {
		int length = arr.length;

		for (int i = 0; i < length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

	private void printArray(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort();
		int[] arr = { 156, 92, 75, 3, 12, 19, 1 };
		selectionSort.sort(arr);
		selectionSort.printArray(arr);
	}
}