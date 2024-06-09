package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ArraysProblems extends SortingAlgorithm {

    public int largestElement(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (maxElement < arr[i]) {
                maxElement = arr[i];
            }
        }

        return maxElement;
    }

    public int secondLargestElement(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        int secondMaxElement = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > maxElement) {
                secondMaxElement = maxElement;
                maxElement = arr[i];
            } else if (arr[i] > secondMaxElement && arr[i] != maxElement) {
                secondMaxElement = arr[i];
            }
        }

        return secondMaxElement;
    }

    public boolean checkSortedArray(int[] arr) {
        boolean isSorted = true;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < arr[i - 1]) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }


    public void removeDuplicate(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int i = 0, j = 1;
        result[j - 1] = arr[i];
        while (i < n) {
            if (result[j - 1] != arr[i]) {
                result[j] = arr[i];
                j++;
            }
            i++;
        }
        printArray(result);
    }

    public void removeDuplicate2(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            set.add(j);
        }

        // System.out.println(set);
        for (Integer j : set) {
            System.out.print(j);
        }
    }

    public void removeDuplicateOptimalSolution(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = i + 1;
        while (j < n) {
            if (arr[i] != arr[j]) {
                i++;
                swapArrayElement(arr, i, j);
            }
            j++;
        }

        System.out.println("No. of Unique Elements " + (i + 1));
        printArray(arr);
    }

    public void leftRotateArray(int[] arr) {
        int n = arr.length;
        int temp = arr[0];
        int j = 1;
        while (j < n) {
            arr[j - 1] = arr[j];
            j++;
        }
        arr[j - 1] = temp;

        printArray(arr);
    }

    public void leftRotateKSteps(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int[] temp = new int[k];

        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

        for (int i = k; i < n; i++) {
            arr[i - k] = arr[i];

        }
        for (int j = n - k; j < n; j++) {
            arr[j] = temp[j - n + k];
        }

        printArray(arr);
    }

    public void leftRotateKStepsOptimal(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
        reverseArray(arr, 0, n - 1);
        printArray(arr);
    }

    public void unionOfArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr1[i]);
        }
        for (int j = 0; j < m; j++) {
            set.add(arr2[j]);
        }
        for (Integer s : set) {
            System.out.print(s + " ");
        }
    }

    public void unionOfArrayMethod(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (union.isEmpty() || union.getLast() != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else {
                if (union.isEmpty() || union.getLast() != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }

        //Add element from arr1
        while (i < n) {
            if (union.isEmpty() || union.getLast() != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }
        //add All element of arr2
        while (j < m) {
            if (union.isEmpty() || union.getLast() != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }

        // print arraylist
        for (int e : union) {
            System.out.print(e + " ");
        }
    }

    public void moveZeroToEnd(int[] arr) {
        int n = arr.length;
        int j = -1;

        //find first zero in the array--->
        for (int k = 0; k < n; k++) {
            if (arr[k] == 0) {
                j = k;
                break;
            }
        }

        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                swapArrayElement(arr, i, j);
                j++;
            }
        }
        printArray(arr);
    }

    public int linearSearch(int[] arr, int key) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (key == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumber(int[] arr) {
        int n = arr.length;
        int [] hash = new int[n+1];
        for (int i = 0; i < n-1; i++) {
            hash[arr[i]]++;
        }

        for (int j =1;j<hash.length;j++){
            if (hash[j]==0){
                return j;
            }
        }
        return -1;
    }

    public int missingNumberMethod2(int [] arr){
        int missingNumber = -1;
        int n = arr.length;

        int i=0,j=1;
        while (j<n){
            j=i+1;
            if(arr[j]==arr[i]+1){
                i++;
            }else{
               missingNumber = arr[i]+1;
               break;
            }
        }

        return missingNumber;
    }

    public int missingNumberMethod3(int [] arr){
        int N = arr.length;
        int xor1 = 0, xor2 = 0;

        for (int i = 0; i < N - 1; i++) {
            xor2 = xor2 ^ arr[i]; // XOR of array elements
            xor1 = xor1 ^ (i + 1); //XOR up to [1...N-1]
        }
        xor1 = xor1 ^ N; //XOR up to [1...N]

        return (xor1 ^ xor2);
    }

    public int maximumConsecutiveOnes(int [] arr){
        int count = 0,max =0;
        for (int j : arr) {
            if (j == 1) {
                count++;
            } else {
                count = 0;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    public void elementFrequency(int []arr){
        int ones = -1;
        int twice = -1;
        int n = arr.length;
        int [] hash = new int[n+1];

        for (int i = 0; i < n-1; i++) {
            hash[arr[i]]++;
        }

        for (int j = 0;j<hash.length;j++){
            if (hash[j]==1){
                ones = j;
            }else if (hash[j]==2){
                twice = j;
            }
        }

        System.out.println("Number present one times "+ones);
        System.out.println("Number present two times "+twice);
    }

    public void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            swapArrayElement(arr, start++, end--);
        }
    }
}
