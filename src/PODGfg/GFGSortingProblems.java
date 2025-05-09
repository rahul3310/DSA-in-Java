package PODGfg;

import classes.ArraysUtils;

import java.util.Arrays;

public class GFGSortingProblems extends ArraysUtils {

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

    public void mergeSortedArrays(int[] a, int[] b) {
        int n = a.length, m = b.length;

        //Start traversing the second array  from starting
        //Compare first element of b with last element of a
        for (int i = m - 1; i >= 0; i--) {

            if (a[n - 1] > b[i]) {
                //swap both the element
                int key = b[i];  //Store to find its correct index
                int temp = a[n - 1];
                a[n - 1] = b[i];
                b[i] = temp;


                //find the correct index of the element
                int j = n - 2;
                while (j >= 0 && a[j] > key) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = key;
            }
        }
    }

    public void mergeSortedArrays2(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int i = n - 1, j = 0;

        while (i >= 0 && j < m) {
            if (a[i] > b[j]) {
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                i--;
                j++;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }

    public void mergeSortedArrayGapMethod(int[] a, int[] b) {
        //we assume n > m
        int n = a.length, m = b.length;
        int gap = (int) (Math.ceil((double) (n + m) / 2));

        while (gap > 0) {

            int left = 0;
            int right = left + gap;

            while (right < n + m) {
                // case 1: left in arr1[]
                //and right in arr2[]:
                if (left < n && right >= n) {
                    swapIfGreater(a, b, left, right - n);
                }
                // case 2: both pointers in arr2[]:
                else if (left >= n) {
                    swapIfGreater(b, b, left - n, right - n);
                }
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(a, a, left, right);
                }

                left++;
                right++;
            }

            if (gap == 1) break; //Means we compared each and every value

            gap = (int) Math.ceil((double) gap / 2);

        }
    }

    private void swapIfGreater(int[] a, int[] b, int ind1, int ind2) {
        if (a[ind1] > b[ind2]) {
            int temp = a[ind1];
            a[ind1] = b[ind2];
            b[ind2] = temp;
        }
    }

    public int HIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1]; // bucket for citation counts

        // Count how many papers have 'i' citations (or more if >= n)
        for (int c : citations) {
            if (c >= n) {
                count[n]++;
            } else {
                count[c]++;
            }
        }

        int total = 0;
        // Traverse from high to low to find the highest possible h-index
        for (int i = n; i >= 0; i--) {
            total += count[i]; // total papers with at least 'i' citations

            if (total >= i) {
                return i; // found the h-index
            }
        }

        return 0;
    }

    public int inversionCount(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public void maxProduct(int[] arr) {
        int minA = Integer.MIN_VALUE, minB = Integer.MIN_VALUE;
        int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE;
        int n = arr.length;

        if (n < 2) {
            System.out.println("No pairs exists");
            return;
        }

        if (n == 2) {
            System.out.println(arr[0] + " " + arr[1]);
            return;
        }

        for (int j : arr) {
            //find first max and second max
            if (j > maxA) {
                maxB = maxA;
                maxA = j;
            } else if (j > maxB) {
                maxB = j;
            }

            //find min and second min
            if (j < 0 && Math.abs(j) > Math.abs(minA)) {
                minB = minA;
                minA = j;
            } else if (j < 0 && Math.abs(j) > Math.abs(minB)) {
                minB = j;
            }
        }

        //Now compare product
        if ((minA * minB) < (maxA * maxB)) {
            System.out.println(maxA + " " + maxB);
        } else {
            System.out.println(minA + " " + minB);
        }


    }

    public int searchRotatedSortedArray(int[] arr, int key) {
        int result = -1;

        int s = 0, e = arr.length - 1;

        while (s < e) {
            int mid = s + (e - s) / 2;

            //If key is found
            if (arr[mid] == key) return mid;

            //If key lies in left half of the array
            if (arr[mid] >= arr[s]) {
                if (key >= arr[s] && key < arr[mid]) e = mid - 1;
                else s = mid + 1;
            } else {
                if (key<=arr[e] && key > arr[mid]) s = mid +1;
                else e = mid-1;
            }

        }


        return result;
    }


}
