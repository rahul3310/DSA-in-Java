import PODGfg.GFGArraysProblems;
import PODGfg.GFGStringProblems;

public class Main {
    public static void main(String[] args) {

        GFGArraysProblems ap = new GFGArraysProblems();

        int[] arr = {2, -3, 4, 1, 1, 7};

        //System.out.print("Smallest missing number : "+ap.smallestMissingNumber(arr));

        //String Problems
        GFGStringProblems sp = new GFGStringProblems();
        String text = "ABCABCD";
        String pat = "AB025";
        sp.rabinKarpAlgo(text,pat);
        System.out.println("Pattern found at : "+sp.patternSearching(text,pat));
    }

}