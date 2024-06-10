import classes.*;

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
       /*Recursion r = new Recursion();
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
       /* Hashing hs = new Hashing();
        hs.hashingTechnique();
        hs.elementFrequencyInArray(arr);
        hs.minMaxFrequencyInArray(arr);*/

        // SortingAlgorithm s = new SortingAlgorithm();
        //s.selectionSort(arr);
        //s.bubbleSort(arr);
        //s.insertionSort(arr);
        //s.mergeSort(arr,0, arr.length-1);
        // s.bubbleSortRecursive(arr, arr.length);
        //s.insertionSortRecursive(arr,0, arr.length);
        // s.quickSort(arr,0, arr.length-1);
        // s.printArray(arr);

        /** Array Elements ------>>>*/
    /*    int[] arr = {64, 25, 12, 22, 11};
        int[] rotate = {1, 2, 3, 4, 5};*/
        ArraysProblems ap = new ArraysProblems();
        // System.out.println("Largest element " + ap.largestElement(arr));
        // System.out.println("Second Largest element " + ap.secondLargestElement(arr));
        // System.out.println("Array is sorted " + ap.checkSortedArray(arr));
        //ap.removeDuplicate2(duplicate);
        //ap.removeDuplicateOptimalSolution(duplicate);
        // ap.leftRotateArray(rotate);
        //ap.leftRotateKSteps(rotate,2);
        // ap.leftRotateKStepsOptimal(rotate,12);
       /* int[] moveZero = {1, 0, 2, 3, 0, 4, 0, 1};
        ap.moveZeroToEnd(moveZero);
        System.out.println("Key is at index " + ap.linearSearch(arr, 12));*/

       /* int [] arr1 = {1,2,3,4,5};
        int [] arr2 = {2,3,4,4,5};
        //ap.unionOfArrays(arr1,arr2);
        ap.unionOfArrayMethod(arr1,arr2);*/

        /*int [] arr = {1,2,4,5};

        System.out.println("Missing number "+ap.missingNumber(arr));
        System.out.println("Missing number method2 "+ap.missingNumberMethod2(arr));*/

       /* int [] ones = {1, 1, 0, 2, 2, 1};
        System.out.println("Maximum number of consecutive ones "+ ap.maximumConsecutiveOnes(ones));
        ap.elementFrequency(ones);*/

      /*  int [] array = {2,3,5};
        System.out.println("Longest SubArray : "+ ap.longestSubArrayMethod2(array,5));*/

        int [] twoSum  = {2, 6, 5, 8, 11};
        ap.TwoSum(twoSum,14);


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