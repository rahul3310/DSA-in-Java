import PODGfg.GFGSortingProblems;

public class Main {
    public static void main(String[] args) {

        GFGSortingProblems ap = new GFGSortingProblems();

        int[] a = {2,4,7,10};
        int[] b = {2,3};

        ap.mergeSortedArrayGapMethod(a,b);

        ap.printArray(a);
        ap.printArray(b);

    }

}