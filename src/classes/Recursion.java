package classes;

public class Recursion {

    public void printNNumbers(int i,int n){
        if (i>n) return;
        System.out.print(i+" ");
        printNNumbers(i+1,n);
    }
    public void printNumber(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printNumber(--n);
        System.out.print(n+1+" ");
    }
    public int sumOfNNumbers(int n){
        if (n==0) return 0;
        return n+sumOfNNumbers(--n);
    }
    public int factorialOfN(int n){
        if (n==1) return 1;
        return n*factorialOfN(n-1);
    }
    public void reverseArray(int[] arr, int start,int end){
        if (start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            reverseArray(arr,start+1,end-1);
        }
    }

    public boolean isStringPalindrome(int i,String s){
        if (i>=s.length()/2) return true;
        if (s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
       return isStringPalindrome(i+1,s);
    }

    public int fibonacci(int n){
        if (n<=1) {
            return n;
        }
        int last = fibonacci(n-1);
        int sLast= fibonacci(n-2);
        return last+sLast;
    }
}
