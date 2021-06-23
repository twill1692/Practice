//See Notes 'Arrays' for more info.

public class ArrayBasics {

    // Old method Array Literal
    // private static int[] myArray = new int[] {1,2,3};

    // New method of Array Literal omitting the 'new int[]'
    // private static int[] myArray = {1,2,3};

    // Or Declare and instantiate and leave the assignments for later.
    // private static int[] myArray = new int[3];

    private static int[] myArray;
    private static int[][] my2DArray;
    private static int[][] myClonedArray;

    private static void arrayMethod() {
        myArray = new int[] { 1, 2, 3 };
        System.out.println("A one dimensional array");
        // Handy forEach loop.
        for (int i : myArray) {
            System.out.println(i);
        }
    }

    // 2d array stuff
    private static void matrixMethod() {
        my2DArray = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
        myClonedArray = my2DArray.clone();
        // Output my 2d array
        System.out.println("A 2D, Matrix array");
        for (int i = 0; i < 2; i++) {
            System.out.println("I'm in sub array " + i);
            for (int j = 0; j < 3; j++) {
                System.out.println(my2DArray[i][j]);
            }
        }
        // Output my 2d cloned array
        for (int i = 0; i < 2; i++) {
            System.out.println("I'm in cloned sub array " + i);
            for (int j = 0; j < 3; j++) {
                System.out.println(myClonedArray[i][j]);
            }
        }
        // Multidimensional arrays are shallow copies. So what happens to the cloned
        // array if we
        // change the original array?
        System.out.println("I changed the original array; heres what happened to the cloned array.");
        my2DArray[0][0] = 8;
        // Output the cloned array after making changes to the original array.
        System.out.println("New changed cloned array");
        for (int i = 0; i < 2; i++) {
            System.out.println("I'm in cloned sub array " + i);
            for (int j = 0; j < 3; j++) {
                System.out.println(myClonedArray[i][j]);
            }
        }
    }

    public static void main(String args[]) {
        arrayMethod();
        matrixMethod();
    }
}
