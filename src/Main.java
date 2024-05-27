import classes.CollectionFramework;
import classes.Hashing;
import classes.Recursion;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        /**Collection Framework ------------------------------->>>>*/
      /*  CollectionFramework cf = new CollectionFramework();
        cf.printArrayList();
        System.out.println();

        cf.printLinkedList();
        System.out.println();

        cf.printHashSet();
        System.out.println();

        cf.printLinkedHashSet();
        System.out.println();

        cf.printTreeSet();
        System.out.println();

        cf.printPriorityQueue();
        System.out.println();

        cf.printDeque();
        System.out.println();

        cf.printHashMap();
        cf.printVector();
        cf.printStack();
        System.out.println();

        cf.printLinkedHashMap();
        System.out.println();

        cf.printTreeMap();
        System.out.println();

        cf.printHashTable();
        System.out.println();*/

        /**Recursion Problems------------------->>*/
/*        Recursion r = new Recursion();
        r.printNNumbers(1, 10);
        System.out.println();
        r.printNumber(10);
        System.out.println();

        System.out.println("Sum is " + r.sumOfNNumbers(5));
        System.out.println("Factorial is " + r.factorialOfN(5));

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Actual Array : " + Arrays.toString(arr));
        r.reverseArray(arr, 0, arr.length - 1);
        System.out.println("Reversed Array : " + Arrays.toString(arr));
        String s = "ABCBA";
        System.out.println("String is Palindrome " + r.isStringPalindrome(0, s));

        System.out.println("fibonacci "+ r.fibonacci(5));*/

        /**Hashing Technique---------------------->*/
        int [] arr = {10,5,10,15,5,10};
        Hashing hs = new Hashing();
        //hs.hashingTechnique();
        hs.elementFrequencyInArray(arr);
        hs.minMaxFrequencyInArray(arr);


    }


    public static void matrixProblem() {
        int[][] arr = {{1, 0, 1}, {3, 1, 3}, {5, 5, 7}};
        int rows = arr.length;
        int columns = arr.length;

        HashSet<Integer> zerosInRow = new HashSet<>();
        HashSet<Integer> zerosInColumn = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (arr[i][j] == 0) {
                    zerosInRow.add(i);
                    zerosInColumn.add(j);
                }
            }
        }
        //print Array
        System.out.println("Array after operation : ");
        setZero(arr, zerosInRow, zerosInColumn);
        for (int[] its : arr) {
            for (int j = 0; j < columns; j++) {
                System.out.print(its[j]);
            }
            System.out.println();
        }
    }

    public static void setZero(int[][] arr, HashSet<Integer> zeroInRows, HashSet<Integer> zerosInColumn) {
        int rows = arr.length;
        int columns = arr[0].length;
        //set zeros in rows
        for (Integer rowNo : zeroInRows) {
            for (int i = 0; i < columns; i++) {
                arr[rowNo][i] = 0;
            }
        }
        //set zeros in column
        for (Integer colNo : zerosInColumn) {
            for (int i = 0; i < rows; i++) {
                arr[i][colNo] = 0;
            }
        }

    }
}