import PODGfg.GFGSortingProblems;

public class Main {
    public static void main(String[] args) {

        GFGSortingProblems ap = new GFGSortingProblems();

        int[] a = {2, 4, 7, 10};
        int[] b = {2, 3};
        int[] citations = {3, 0, 6, 1, 5}; // Output: 3
        int[] inversion = {2, 4, 1, 3, 5}; // Output: 3


        /*ap.mergeSortedArrayGapMethod(a, b);

        ap.printArray(a);
        ap.printArray(b);*/

        /*System.out.println("H-Index is " + ap.HIndex(citations));
        System.out.println("Inversion count  is " + ap.inversionCount(inversion));*/
        int [] p = {5, 6, 7, 8, 9, 10, 1, 2, 3,4} ;//{1, 4, 3, 6, 7, 0};
        //ap.maxProduct(p);
        System.out.println("key is found at "+ap.searchRotatedSortedArray(p,3));

    }

}