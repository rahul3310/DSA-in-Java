package classes;

import java.util.Scanner;

public class Hashing {
    /**
     * In order to optimize this approach, we need to use hashing.
     * If we say the definition of hashing in a naive way,
     * it is nothing but the combination of the steps, pre-storing, and fetching.
     */
    public void hashingTechnique() {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("NUmber of element of array : ");
        n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Elements of Array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //precompute:
        int[] hash = new int[13];
        for (int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }

        int q;
        System.out.println("Number of Query : ");
        q = sc.nextInt();

        while (q!=0){
            int number;
            number = sc.nextInt();
            System.out.println("Frequency of "+q+" is "+ hash[number]);
            q--;
        }
    }

}
