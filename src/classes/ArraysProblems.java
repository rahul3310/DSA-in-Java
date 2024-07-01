package classes;

import java.util.*;

public class ArraysProblems extends SortingAlgorithm {

    /**
     * find the largest element of the array
     */
    public int largestElement(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (maxElement < arr[i]) {
                maxElement = arr[i];
            }
        }

        return maxElement;
    }

    /**
     * find the second-largest element of the array
     */
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

    /**
     * Check the give array is sorted or not
     */
    //Here we do if any arr[i] < arr[i-1] than not sorted
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

    /**
     * Remove duplicate elements from the Array given
     */
    //Here we take an extra space (temp array) and added unique element the temp array.
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

    //Using Set (Because set does not contain duplicates and not maintained order)
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

    //Using swapping along with Two pointer approach place all duplicate element at the end of the array
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

    /**
     * Left rotate the given array
     */
    //Store the first element in a temp space
    //Now move each element to step one left
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

    //Store the K elements in a temp space
    //Now move each element to K step left
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


    //First reverse array 0 to k-1
    //Then reverse array k to n-1
    //Finally reverse array 0 to n-1
    public void leftRotateKStepsOptimal(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
        reverseArray(arr, 0, n - 1);
        printArray(arr);
    }


    /**
     * Find union of the two arrays* -->
     */
    //Here we are using set.
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


    /**
     * Move All the zeros to end --->
     */
    //First find the first zero
    //Then swap zero with next element
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


    /**
     * Find the missing number in the array
     */
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int[] hash = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            hash[arr[i]]++;
        }

        for (int j = 1; j < hash.length; j++) {
            if (hash[j] == 0) {
                return j;
            }
        }
        return -1;
    }

    public int missingNumberMethod2(int[] arr) {
        int missingNumber = -1;
        int n = arr.length;

        int i = 0, j = 1;
        while (j < n) {
            j = i + 1;
            if (arr[j] == arr[i] + 1) {
                i++;
            } else {
                missingNumber = arr[i] + 1;
                break;
            }
        }

        return missingNumber;
    }

    public int missingNumberMethod3(int[] arr) {
        int N = arr.length;
        int xor1 = 0, xor2 = 0;

        for (int i = 0; i < N - 1; i++) {
            xor2 = xor2 ^ arr[i]; // XOR of array elements
            xor1 = xor1 ^ (i + 1); //XOR up to [1...N-1]
        }
        xor1 = xor1 ^ N; //XOR up to [1...N]

        return (xor1 ^ xor2);
    }

    /**
     * Find maximum number of consecutive ones
     */
    public int maximumConsecutiveOnes(int[] arr) {
        int count = 0, max = 0;
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

    /**
     * Find the frequency of the element of the array
     */
    public void elementFrequency(int[] arr) {
        int ones = -1;
        int twice = -1;
        int n = arr.length;
        int[] hash = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            hash[arr[i]]++;
        }

        for (int j = 0; j < hash.length; j++) {
            if (hash[j] == 1) {
                ones = j;
            } else if (hash[j] == 2) {
                twice = j;
            }
        }

        System.out.println("Number present one times " + ones);
        System.out.println("Number present two times " + twice);
    }

    public void elementFrequency2(int[] arr) {
        int ones = -1;
        int twice = -1;
        int n = arr.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            int value = hashMap.getOrDefault(arr[i], 0);
            hashMap.put(arr[i], value + 1);
        }

        for (Map.Entry<Integer, Integer> e : hashMap.entrySet()) {
            if (e.getValue() == 1) {
                ones = e.getKey();
            } else if (e.getValue() == 2) {
                twice = e.getKey();
            }
        }

        System.out.println("Number present one times " + ones);
        System.out.println("Number present two times " + twice);
    }

    /** Print All Sub-Arrays*/
    public void printAllSubArray(int[] arr) {
        int n = arr.length;
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    /**
     * Find length of the longest sub-array having sum is equal to K
     */
    public int longestSubArray(int[] arr, int k) {
        int len = 0;
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }

    //This method is only for non-negative numbers ------>>
    public int longestSubArrayMethod2(int[] arr, int k) {
        int len = 0, left = 0, right = 0, sum = arr[0];
        int n = arr.length;

        while (right < n) {
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) len = Math.max(len, right - left + 1);
            right++;
            if (right < n) sum += arr[right];
        }

        return len;
    }


    //This is for positive and negative numbers
    public int longestSubArrayMethod3(int[] arr, int k) {
        int maxLen = 0;
        int sum = 0;
        int n = arr.length;
        HashMap<Long, Long> preSum = new HashMap<Long, Long>();

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == k) maxLen = Math.max(maxLen, i + 1);

            long rem = k - sum;

            if (preSum.containsKey(rem)) {
                int len = (int) (i - preSum.get(rem));
                maxLen = Math.max(maxLen, len);

            }

            //Finally, update the map checking the conditions:
            if (!preSum.containsKey(sum)) {
                preSum.put((long) sum, (long) i);
            }

        }
        return maxLen;
    }

    public void TwoSum(int[] arr, int targetSum) {
        int n = arr.length;
        Arrays.sort(arr);
        int left = 0, right = n - 1;
        ArrayList<Integer> ans = new ArrayList<>();

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == targetSum) {
                ans.add(arr[left]);
                ans.add(arr[right]);
            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(ans);
    }

    //Dutch National Flag Algorithm to sort array of 0,1 & 2's-------->>
    //In this Algorithm we have three pointers low , mid & high
    public void dutchNationalFlagAlgo(int[] arr) {
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid < high) {
            if (arr[mid] == 0) {
                swapArrayElement(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swapArrayElement(arr, mid, high);
                high--;
            }
        }

        printArray(arr);
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

    //Kadden's Algorithm to find maximum sum of sub-array
    public void maximumSumSubArray(int[] arr) {
        int sum = 0, maxSum = arr[0];
        int start = 0;
        int ansStart = -1, ansEnd = -1;

        for (int i = 0; i < arr.length; i++) {

            if (sum == 0) start = i;

            sum += arr[i];

            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) sum = 0;

        }

        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Maximum sum " + maxSum);
    }

    public void sortZerosOnesTwosArray(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;
        int n = arr.length;

        for (int j : arr) {
            if (j == 0) {
                count0++;
            } else if (j == 1) {
                count1++;
            } else {
                count2++;
            }
        }


        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < count1; i++) {
            arr[i] = 1;
        }
        for (int i = 0; i < count2; i++) {
            arr[i] = 2;
        }

        printArray(arr);
    }

    public void buySellStock(int [] arr){
        int n = arr.length;
        int min = arr[0];
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            int cost = arr[i] -  min;
            maxProfit = Math.max(cost,maxProfit);
            min = Math.min(min,arr[i]);
        }

        System.out.println("Maximum profit is "+maxProfit);
    }

    public void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            swapArrayElement(arr, start++, end--);
        }
    }
}
