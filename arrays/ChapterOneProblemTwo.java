//Given two strings, determine if one is a permutation of the other.

public class ChapterOneProblemTwo {
    private static String strOne;
    private static String strTwo;

    private ChapterOneProblemTwo() {
        strOne = "bolg";
        strTwo = "glob";
    }

    // If a set of strings are permutations of the other, it makes sense to sort the
    // strings and determine if they are the same using a String util equals()
    // method after using a Array util sort() method.

    private String sort(String str) {
        char[] charArray = str.toCharArray();
        java.util.Arrays.sort(charArray);
        return new String(charArray);
    }

    // Actual code for permutations (both strings of the same size), that
    // can be solved with some array sorts.
    private boolean isSubstring(String strOne, String strTwo) {
        if (strOne.length() != strTwo.length()) {
            return false;
        }
        return sort(strOne).equals(sort(strTwo));
    }

    // Misunederstood problem and started looking at subsets rather than
    // permutations.
    // However this code works and with some refactoring can answer whether the two
    // strings are permutations or subsets of the other.
    // Also theres plenty of room for optimizing the code.
    // public boolean isSubstring(String str1, String str2) {
    // Map<Character, Integer> map = new HashMap<Character, Integer>();
    // int stringOneLength = str1.length();
    // int stringTwoLength = str2.length();
    // String longString;
    // String shortString;
    // if (stringOneLength > stringTwoLength) {
    // longString = str1;
    // shortString = str2;
    // } else {
    // longString = str2;
    // shortString = str1;
    // }
    // System.out.println(longString + " " + shortString + "\n");
    // for (int i = 0; i < longString.length(); i++) {
    // map.put(longString.charAt(i), i);
    // }
    // for (int i = 0; i < shortString.length(); i++) {
    // if (!(map.containsKey(shortString.charAt(i)))) {
    // return false;
    // }
    // }
    // return true;
    // }

    public static void main(String[] args) {
        ChapterOneProblemTwo oneTwo = new ChapterOneProblemTwo();
        boolean subString = oneTwo.isSubstring(strOne, strTwo);
        System.out.println("Is " + strOne + " and " + strTwo + " a permutation of each other? " + subString);
    }
}