import PODGfg.GFGArraysProblems;

public class Main {
    public static void main(String[] args) {

        GFGArraysProblems ap = new GFGArraysProblems();

        int [] arr = {2,4,1,7,5,0};
        System.out.print("Array : ");
        ap.printArray(arr);
        System.out.println(" ");
        System.out.print("Next permutation is : ");
        ap.nextPermutation(arr);
        ap.printArray(arr);
    }

}