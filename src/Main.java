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
        String text = "larbjrpjjjgharbjrpjjjgh";
        String pat = "jjgh";
        sp.KMPAlgorithm(text, pat);
        //System.out.println("Pattern found at : " + sp.patternSearching(text, pat));


    }

}