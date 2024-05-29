package classes;

public class SortingAlgorithm {


    /**
     * First assume the first element of the array is sorted
     * then find index of minimum element in unsorted Array
     * and if it is smaller than element in sorted array swap it.
     */
    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swapArrayElement(arr, i, minIndex);
            }
        }
        printArray(arr);
    }

    /**
     * traverse from left and compare adjacent elements and the higher one is placed at right side.
     * In this way, the largest element is moved to the rightmost end at first.
     * This process is then continued to find the second largest and place it and so on until the data is sorted.
     */

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapArrayElement(arr, j, j + 1);
                }
            }
        }

        printArray(arr);
    }


    /**
     * In insertion sort we assume fist element as sorted and then set index 1 as key
     * compare key with the sorted element and if small swap.
     */
    public void insertionSort(int[] arr) {

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        printArray(arr);
    }

    /**
     * Divide: Divide the list or array recursively into two halves until it can no more be divided.
     * Conquer: Each sub-array is sorted individually using the merge sort algorithm.
     * Merge: The sorted sub-arrays are merged back together in sorted order.
     * The process continues until all elements from both sub-arrays have been merged.
     */

    public void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        //copy data in left array--->>
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[start + i];
        }
        //copy data in right array

        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid+1+j];
        }

        //merge left sub-array and right sub-array in our array in sorted order
        int i = 0, j = 0;
        int k = start; //for our array
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        //copy remaining of left array
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        //copy remaining of right array
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

    }


    private void swapArrayElement(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
