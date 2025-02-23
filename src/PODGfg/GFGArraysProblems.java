package PODGfg;

import classes.ArraysUtils;

import java.util.*;

public class GFGArraysProblems extends ArraysUtils {

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

    public void nextPermutation(int[] arr) {

        int n = arr.length;
        int pivot = -1;
        //First find the Pivot that is  element from where all the next elements are greater than it.
        //Start iterating from the end of the array

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        //If pivot is -1 then no next permutation possible So just
        //reverse the Array and return

        if (pivot == -1) {
            reverseArray(arr, 0, n - 1);
        }

        //If we found the pivot
        //Now find just greater number from the pivot and swap with pivot

        for (int j = n - 1; j > pivot; j--) {
            if (arr[pivot] < arr[j]) {
                swapArrayElement(arr, pivot, j);
                break;
            }
        }

        //Now arrange the element after the pivot in ascending order
        //as form analysing all the element after pivot are sorted in descending so just reverse the array
        //no need to sort
        reverseArray(arr, pivot + 1, n - 1);


    }


    //Find element occurs more than n/2 times in Array
    public void majorityElement(int[] arr) {
        int majorityElement = -1;
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j : arr) {
            int value = map.getOrDefault(j, 0);
            map.put(j, value + 1);
        }

        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() > n / 2) {
                majorityElement = it.getKey();
            }
        }
        System.out.println("Majority element is " + majorityElement);
    }


    /**
     * @Moore's Voting Algorithm
     * Initialize 2 variables:
     * Count –  for tracking the count of element for which element we are counting
     * Traverse through the given array.
     * If Count is 0 then store the current element of the array as Element.
     * If the current element and Element are the same increase the Count by 1.
     * If they are different decrease the Count by 1.
     * The integer present in Element should be the result we are expecting
     * for n/2 condition there exist only one majority element in case of
     * n/3 there exist 3 and so on
     */

    public void mooresVotingAlgorithm(int[] arr) {
        int majorityEle = -1;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                count = 1;
                majorityEle = arr[i];
            } else if (majorityEle == arr[i]) {
                count++;
            } else {
                count--;
            }
        }

        int count1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (majorityEle == arr[i]) count1++;
        }

        if (count1 > arr.length / 2) {
            System.out.println("Majority Element " + majorityEle);
        } else {
            System.out.println("Majority Element is -1");
        }

    }

    //Majority element - II
    //Return the candidates that have votes greater than one-third of the total votes,

    /**
     * Note: The answer should be returned in an increasing format.
     */
    public List<Integer> majorityElements(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();

        int n = arr.length;

        for (int ele : arr) {
            int value = hashMap.getOrDefault(ele, 0);
            hashMap.put(ele, value + 1);
        }

        for (Map.Entry<Integer, Integer> m : hashMap.entrySet()) {
            if (m.getValue() > n / 3) {
                result.add(m.getKey());
            }
        }
        Collections.sort(result); //For increase order
        return result;
    }

    /**
     * Stock Buy and Sell – Multiple Transaction Allowed  means we can buy or sell multiple times
     */
    //find totals max profit
    public void buySellStockTotalMaxProfit(int[] price) {
        int i = 0, n = price.length, totalMaxProfit = 0;
        // here i represent the selling price and i-1 is buying price
        for (i = 1; i < n; i++) {
            if (price[i] > price[i - 1]) {
                totalMaxProfit += price[i] - price[i - 1];
            }
        }
    }

    /**
     * Stock Buy and Sell – Max one Transaction Allowed
     */
    public void buySellStock(int[] arr) {
        int min = arr[0];
        int maxProfit = 0;
        for (int j : arr) {
            int cost = j - min;
            maxProfit = Math.max(cost, maxProfit);
            min = Math.min(min, j);
        }

        System.out.println("Maximum profit is " + maxProfit);
    }


    /**
     * Minimize the Heights II
     */
    public int minimizeHeightDiff(int[] arr, int k) {
        int n = arr.length;
        //sort the array
        Arrays.sort(arr);
        int diff = arr[n - 1] - arr[0];  //maximum possible difference
        int minH = arr[0] + k;
        int maxH = arr[n - 1] - k;
        
        for (int j : arr) {
            minH = Math.min(minH, j - k);

            //here we consider @arr[i-1] + K because it is possible when adding K this may be the tallest tower
            maxH = Math.max(j + k, maxH);
            if (minH < 0) continue; //Skip the negative height
            diff = Math.min(diff, maxH - minH);
        }

        return diff;
    }


    /**
     * @Kadden's Algorithm to find maximum sum of sub-array and range of sub-array */

    public int kadaneAlgo(int [] arr){
        int sum = 0,maxSum = arr[0];
        for (int j : arr) {
            sum = Math.max(sum + j, j);
            maxSum = Math.max(maxSum, sum);
        }

        return  maxSum;
    }
    public void maximumSumSubArray(int[] arr) {
        int sum = 0, maxSum = arr[0];
        int start = 0;
        int ansStart = -1, ansEnd = -1;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];
            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
                start = i;
            }

        }

        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Maximum sum " + maxSum);
    }

    /** @Maximum Product Sub-array*/
    public int maxProduct(int [] arr){
        int maxProduct = Integer.MIN_VALUE;

        int prefix = 1,suffix = 1;

        int n = arr.length;


        for (int i = 0;i<n;i++){

            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= arr[i];

            suffix *= arr[n-i-1];


           maxProduct = Math.max(maxProduct,Math.max(prefix,suffix));
        }

        return maxProduct;
    }


}
