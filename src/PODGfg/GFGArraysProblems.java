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
     * @Kadden's Algorithm to find maximum sum of sub-array and range of sub-array
     */

    public int kadaneAlgo(int[] arr) {
        int sum = 0, maxSum = arr[0];
        for (int j : arr) {
            sum = Math.max(sum + j, j);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
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

    /**
     * @Maximum Product Sub-array
     */
    public int maxProduct(int[] arr) {
        int maxProduct = Integer.MIN_VALUE;

        int prefix = 1, suffix = 1;

        int n = arr.length;


        for (int i = 0; i < n; i++) {

            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= arr[i];

            suffix *= arr[n - i - 1];


            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }

        return maxProduct;
    }

    public int maxProduct2(int[] arr) {
        // code here
        int maxP = arr[0];
        int minP = arr[0];
        int res = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {  //when the number is negative the swap the max and min value
                int temp = maxP;
                maxP = minP;
                minP = temp;
            }

            maxP = Math.max(arr[i], arr[i] * maxP);
            minP = Math.min(arr[i], arr[i] * minP);

            res = Math.max(res, maxP);
        }
        return res;

    }

    /**
     * Max Circular Sub-array Sum
     */

    public int maxCircularSum(int[] arr) {
        int index = -1, result = 0, n = arr.length;

        for (int i = 0; i < n; i++) {
            int currSum = 0;
            for (int j = 0; j < n; j++) {

                index = (i + j) % n;
                currSum += arr[index];

                result = Math.max(result, currSum);
            }
        }

        return result;
    }

    public int maxCircularSum2(int[] arr) {
        int n = arr.length;
        int[] suffixArr = new int[n];
        int suffixSum = arr[n - 1];

        suffixArr[n - 1] = suffixSum;

        // size n-2 is for tha we already fill n-1th position in the array, and we should also include the circular starting indexes
        for (int i = n - 2; i >= 0; i--) {
            suffixSum += arr[i];
            suffixArr[i] = Math.max(suffixArr[i + 1], suffixSum); //here we traverse from the end of the Array
        }

        int circularSum = arr[0];
        int normalSum = arr[0];

        int currentSum = 0, prefix = 0;

        for (int i = 0; i < n - 1; i++) {
            //Calculate the normal sum using Kadane algorithm
            currentSum = Math.max(currentSum + arr[i], arr[i]);
            normalSum = Math.max(normalSum, currentSum);


            //Now calculate the circular sum

            prefix += arr[i];

            int sumOfArrayFromEnd = suffixArr[i + 1]; //we get from the next element from current because the new array starts from next index

            circularSum = Math.max(circularSum, Math.max(prefix, prefix + sumOfArrayFromEnd));
        }

        return circularSum;

    }

    public int circularSubArraySum(int[] arr) {

        int n = arr.length;
        int currentMin = 0, currentMax = 0, totalSum = 0, maxSum = arr[0], minSum = arr[0];

        for (int i = 0; i < n; i++) {
            //calculate max sum using Kadane algo
            currentMax = Math.max(currentMax + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currentMax);

            //calculate min. sum using Kadane
            currentMin = Math.min(currentMin + arr[i], arr[i]);
            minSum = Math.min(minSum, currentMin);

            //find total sum because the Sum = a + b
            //So we assume a is max circular  => a = Sum - b(minSum)

            totalSum += arr[i];

        }

        int circularSum = totalSum - minSum;

        //if minSum == totalSum return maxSum as result

        if (minSum == circularSum) return maxSum;

        return Math.max(circularSum, maxSum);
    }


    /**
     * Smallest Positive Missing
     * Using the cyclic sort we can find
     * why cyclic sort because number range is (1 - n)
     * Correct position is as arr[i] should be (arr[i]-1)th index
     */

    public int smallestMissingNumber(int[] arr) {
        int n = arr.length;

        // Cyclic Sort: Place each number at its correct position

        for (int i = 0; i < n; i++) {
            int correctIndex = arr[i] - 1;
            while (arr[i] > 0 && arr[i] <= n && arr[i] != arr[correctIndex]) {
                swapArrayElement(arr, i, correctIndex);
            }
        }


        // Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // If all numbers 1 to n are present, return n+1
        return n + 1;
    }


    public int smallestMissingNumberUsingVisited(int []arr){
        int n = arr.length;

        boolean [] visited = new boolean[n];

        for(int i = 0;i<n;i++){
            if(arr[i]>0 && arr[i]<=n){
                visited[arr[i]-1] = true;
            }
        }

        for(int j = 0 ;j<n;j++){
            if(!visited[j]) return j+1;
        }

        return n+1;
    }

    /** @LeetCode-2161 Partition Array According to Given Pivot*/
    public int[] pivotArray(int[] nums, int pivot) {

        List<Integer> smaller = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();

        // Partitioning nums into three lists
        for (int num : nums) {
            if (num < pivot) {
                smaller.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                larger.add(num);
            }
        }

        // Merging the lists back into nums
        int k = 0;
        for (int num : smaller) nums[k++] = num;
        for (int num : equal) nums[k++] = num;
        for (int num : larger) nums[k++] = num;

        return nums;

    }


}
