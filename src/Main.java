import PODGfg.GFGArraysProblems;
import PODGfg.GFGStringProblems;

public class Main {
    public static void main(String[] args) {

        GFGArraysProblems ap = new GFGArraysProblems();

        int[] arr = {9, 12, 5, 10, 14, 3, 10};
        int[] arr1 = {-3,4,3,2};

        //System.out.print("Smallest missing number : "+ap.smallestMissingNumber(arr));

        //String Problems
        GFGStringProblems sp = new GFGStringProblems();
        String text = "ABCABCD";
        String pat = "ABC";
        sp.KMPAlgorithm(text, pat);
        System.out.println("Pattern found at : " + sp.patternSearching(text, pat));

        String txt = "BAC";
        sp.lexicographicRankingOfString(txt);

        System.out.println("Length of longest Sub-string : " + sp.longestSubString2(text));
        ap.printArray(ap.pivotArray(arr1, 2));
    }

}