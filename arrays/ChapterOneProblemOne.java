// An alghorithm to determine if a string has all unique characters.
// Consider characters. There can be only so many unique strings of 
// characters depending on the character encoding being used ie. ASCII,
// extended ASCII or Unicode. Remember characters dont just mean letters.


import java.util.HashMap;
import java.util.Map;

public class ChapterOneProblemOne {

    private static String myString;

    private ChapterOneProblemOne() {
        myString = "abc";
    }

    // My first implementation.
    private boolean isUnique(String string) {
        String theString = string;
        int stringLength = theString.length();
        Map<Character, Integer> myMap = new HashMap<Character, Integer>();
        for (int i = 0; i < stringLength; i++) {
            if (myMap.containsKey(theString.charAt(i))) {
                return false;
            }
            myMap.put(theString.charAt(i), i);
        }
        return true;
    }

    // Book solution pg.192 Using 128 char standard ASCII and casting the char to an
    // int.
    // The index of the array corresponding to the char than gets filled at that
    // point.
    // If that point in the array has been set to 'true', the string is not unique.
    // private boolean isUnique(String str) {
    // if (str.length() > 128) {
    // return false;
    // }
    // boolean[] charSet = new boolean[128];
    // for (int i = 0; i < str.length(); i++) {
    // int val = str.charAt(i);
    // System.out.println("The value of the char is " + str.charAt(i));
    // System.out.println("The value is " + val + "\n");
    // if (charSet[val]) {
    // return false;
    // }
    // charSet[val] = true;
    // }
    // return true;
    // }

    // Solution on pg.193, I've got no idea (The trick is working out the
    // operands)
    // Checker, a primitive type int is a 32 bit array initialized to 0.
    // The checker var holds a 0, or 1 depending if the corrosponding letter is in
    // the string.
    // The position of var is regulated by subtracting the int value of the char
    // 'a'.
    // so checker, which starts empty as all 0's gets the AND operator against the
    // val left
    // shifted by 1. If theres a char in that spot the AND operator will yeild 1,
    // meaning its
    // not unique and return false.
    // If there was no occurence of that character in checker, the | OR assignment
    // operation
    // will change the checker so that the character is held in that position. This
    // is an ideal
    // method in terms of time and space, but not readable at all.
    // private boolean isUnique(String str) {
    // int checker = 0;
    // for (int i = 0; i < str.length(); i++) {
    // int val = str.charAt(i) - 'a';
    // if ((checker & (1 << val)) > 0) {
    // return false;
    // }
    // checker |= (1 << val);
    // }
    // return true;
    // }

    public static void main(String[] args) {
        ChapterOneProblemOne myClass = new ChapterOneProblemOne();
        boolean unique = myClass.isUnique(myString);
        System.out.println(unique);
    }
}