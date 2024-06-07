package classes;

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
        reverseArray(arr,0,k-1);
        reverseArray(arr,k,n-1);
        reverseArray(arr,0,n-1);
        printArray(arr);
    }

    public void moveZeroToEnd(int [] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start<end){
            if (arr[start] == 0 && arr[end]!=0){
                swapArrayElement(arr,start,end);
                start++;
                end--;
            } else if (arr[start]!=0) {
                start++;
            } else if (arr[end]==0) {
                end--;
            }

        }

        printArray(arr);
    }


    public void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            swapArrayElement(arr, start++, end--);
        }
    }
}
