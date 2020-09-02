// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Iterator;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

//URLify. A method two replace all the white space in a string with '%20'.
//Use a character array. The solution on pg 195 feels convoluted. See if I
//can do it better.
//Theres a way to do this with REGEX expressions and replacements as well.
//%20 is an escape character in a URL. A URL cant have whitespace, if it has
//whitespace the %20 is the hex code placeholder signifying whitespace in the
//URL.
//My method will not utilize any of the java utils.

package problems.arrays;

public class ChapterOneProblemThree {
    String inputString;
    // String REGEX;
    char target;
    static String ogString;

    private ChapterOneProblemThree() {
        // The metacharacter \s is the character for whitespace.
        // REGEX = "\s";
        inputString = "%20";
        target = ' ';
        ogString = "Dont bogart me stash mon "; // 25 size, 24 if starting at 0 W/5 white spaces.
    }

    // This is where we do the replacing. We start by calling 'countTarget' since
    // we need to know how many white spaces will be needing to be filled in.
    // There will be an alternate method in here that can do a replacement with
    // iterators and string methods 'replaceAll'. Theres also some neat stuff with
    // StringBuilder class
    public String URLIfy(String str) {
        // String modifiedString = str.replaceAll(REGEX, inputString); The easy way
        int whiteSpaces = countTarget(str);
        int index = 0;
        char[] oldCharArray = str.toCharArray();
        // the size of the string were replacing the white spaces with is two extra
        // spaces as long as a single white spaces so whiteSpaces*2
        char[] newCharArray = new char[str.length() + whiteSpaces * 2];
        for (int i = 0; i < oldCharArray.length; i++) {
            if (oldCharArray[i] == target) {
                newCharArray[index] = inputString.charAt(0);
                newCharArray[index + 1] = inputString.charAt(1);
                newCharArray[index + 2] = inputString.charAt(2);
                index += 3;
            } else {
                newCharArray[index] = oldCharArray[i];
                index++;
            }
        }
        return new String(newCharArray);
    }

    // Lets find the number of whitespaces that occur in our given string.
    // Two ways to do this; REGEX or a for loop. I'll do both.
    private int countTarget(String str) {
        int whiteSpaces = 0;
        // Pattern pat = Pattern.compile(REGEX);
        // Matcher m = pat.matcher(str);
        // while (m.find()) {
        // whiteSpaces++;
        // System.out.println(whiteSpaces);
        // }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                whiteSpaces++;
            }
        }
        return whiteSpaces;
    }

    public static void main(String[] args) {
        ChapterOneProblemThree myClass = new ChapterOneProblemThree();
        String myNewString = myClass.URLIfy(ogString);
        System.out.println(ogString);
        System.out.println(myNewString);
    }
}