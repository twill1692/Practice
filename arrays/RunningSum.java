import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RunningSum {

    private static final int[] nums = { 1, 2, 3, 4 };
    private static int[] sum;

    // First try
    // public static int[] getSumArray(int[] nums) {
    // int total = 0;
    // sum = new int[nums.length];
    // for (int i = 0; i < nums.length; i++) {
    // total += nums[i];
    // sum[i] = total;
    // }
    // return sum;
    // }

    // Better implementation;
    // we eliminate a variable'total'
    // private static int[] getSumArray(int[] nums) {
    // sum = new int[nums.length];
    // sum[0] = nums[0];
    // for (int i = 1; i < nums.length; i++) {
    // sum[i] = sum[i - 1] + nums[i];
    // }
    // return sum;
    // }

    // Can I do it with a map() function?
    // Map functions act on streams. Only collections are streamable.
    // For object types can declare a list and use the asList() method
    // Of the Arrays class to convert the array to a list (collection type).
    // Now you could steam and map.
    // private int[] getSumArray(int[] nums) {
    // String[] myStringArray = new String[] { "Bob", "Linda", "Luis" };
    // List<String> myList = Arrays.asList(myStringArray);
    // Iterator<String> stringIterator = myList.iterator();
    // while (stringIterator.hasNext()) {
    // System.out.print(stringIterator.next() + " ");
    // }
    // return nums;
    // }

    // Now with a primitive array converted to a list.
    private int[] getSumArray(int[] nums) {
        List<Integer> myList = IntStream.of(nums).boxed().collect(Collectors.toList());
        Iterator<Integer> itr = myList.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        return nums;
    }

    public static void main(String[] args) {
        // getSumArray(nums);
        RunningSum rs = new RunningSum();
        rs.getSumArray(nums);
        // for (int i : sum) {
        // System.out.println(i);
        // }
    }
}