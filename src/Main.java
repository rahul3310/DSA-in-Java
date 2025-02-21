import PODGfg.DoublyLinkedList;
import classes.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArraysProblems ap = new ArraysProblems();

        int [] arr = {2,4,1,7,5,0};
        System.out.print("Array : ");
        ap.printArray(arr);
        System.out.println(" ");
        System.out.print("Next permutation is : ");
        ap.nextPermutation(arr);
        ap.printArray(arr);
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