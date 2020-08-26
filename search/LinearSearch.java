package search;

import java.util.Scanner;

//A linear search with user inputs, just for fun.
class LinearSearch {

    static int arr[] = { 4, 7, 8, 32 };

    private int search(int[] arr, int x) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Boolean inputError = false;
        int x = 0;
        do {
            try {
                System.out.println("Enter a number to search for ");
                Scanner in = new Scanner(System.in);
                x = in.nextInt();
                in.close();
                inputError = false;
            } catch (Exception e) {
                System.out.println("Please enter a number ");
                inputError = true;
            }
        } while (inputError == true);
        LinearSearch linSearch = new LinearSearch();
        int index = linSearch.search(arr, x);
        String result = (index > -1)
        ? x + " was found in position " + index 
        : x + " was not found";
        System.out.println(result);
    }
}