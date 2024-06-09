package classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hashing {
    /**
     * In order to optimize this approach, we need to use hashing.
     * If we say the definition of hashing in a naive way,
     * it is nothing but the combination of the steps, pre-storing, and fetching.
     */
    public void hashingTechnique() {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("NUmber of element of array : ");
        n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Elements of Array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //precompute:
        int[] hash = new int[13];
        for (int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }

        int q;
        System.out.println("Number of Query : ");
        q = sc.nextInt();

        while (q!=0){
            int number;
            number = sc.nextInt();
            System.out.println("Frequency of "+q+" is "+ hash[number]);
            q--;
        }
    }

    public void elementFrequencyInArray(int [] arr){
        Map<Integer,Integer> map  =  new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }

        System.out.println("Frequency of Elements "+map);
    }

    public void minMaxFrequencyInArray(int [] arr){
        Map<Integer,Integer> map  =  new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        int maxFreq = 0, minFreq = n;
        int maxEle = 0, minEle = 0;
        // Traverse through map and find the elements
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            int element = entry.getKey();

            if (count > maxFreq) {
                maxEle = element;
                maxFreq = count;
            }
            if (count < minFreq) {
                minEle = element;
                minFreq = count;
            }
        }

        System.out.println("Highest Frequency Element "+maxEle + "->"+maxFreq);
        System.out.println("Lowest Frequency Element "+minEle+"->"+minFreq);
    }

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

        // Copy data into the temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[start + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // Merge the arrays in sorted order
        int i = 0, j = 0;
        int k = start;  // Initial index of the merged subarray

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {  // Change made here: '<' to '<=' to maintain stability
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArr, if any
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArr, if any
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }


}
