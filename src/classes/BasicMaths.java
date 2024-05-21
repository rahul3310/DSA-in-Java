package classes;

import java.util.ArrayList;

public class BasicMaths {

    public void gcd(int num1,int num2){
        int gtrNum = Math.min(num1, num2);
        int gcd = 1;
        for (int i = 1; i < gtrNum; i++) {
            if (num1%i==0 && num2%i==0){
                if (gcd<i) gcd = i;
            }

        }
        System.out.println("GCD "+gcd);
    }
    public void gcdMethod2(int a,int b){
        while (a>=0 && b>=0){
            if (a>b){
                a= a%b;
            }else{
                b=b%a;
            }
        }
        if (a==0){
            System.out.println("GDC "+b);
        }else{
            System.out.println("GCD "+a);
        }
    }

    public void armStrongNumber(int num){
        int n = num;
        int result = 0;
        int k = String.valueOf(num).length(); //number of digits

        while (n>0){
            int digit = n%10;
            n = n/10;
            result += (int) Math.pow(digit,k);
        }

        if (result == num) System.out.println(num + " is ArmStrongNumber");
        else System.out.println(num + " is not ArmStrongNumber");
    }

    public void printAllPrimeDivisor(int num){
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num%i==0) {
                divisors.add(i);

                // Add the counterpart divisor
                // if it's different from i
                if (i != num / i) {
                    // Add the counterpart
                    // divisor to the list
                    divisors.add(num / i);
                }
            }
        }
        System.out.println(divisors);
    }

    public void checkPrime(int num){
        int count = 0;
        for (int i = 1; i < Math.sqrt(num); i++) {
            if (num%i==0){
                count++;
                if (i!=num/i)
                    count++;
            }
        }

        if (count == 2){
            System.out.println(num + " number is Prime");
        }else System.out.println(num + " number is not Prime");
    }
}
