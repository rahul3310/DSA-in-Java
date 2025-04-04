package PODGfg;

import classes.ArraysUtils;

import java.util.Arrays;

public class GFGSortingProblems extends ArraysUtils {

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
}
