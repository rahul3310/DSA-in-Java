package classes;

public class Patterns {

    public void Pattern1(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void Pattern2(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void Pattern3(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void Pattern4(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(i + 1);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void Pattern5(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void Pattern6(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number - i; j++) {
                System.out.print(j + 1);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void Pattern7(int num) {
        for (int i = 0; i < num; i++) {

            //print spaces
            for (int j = 0; j < num - i - 1; j++) {
                System.out.print(" ");
            }
            //print star
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            //print spaces
            for (int m = 0; m < num - i - 1; m++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void Pattern8(int num) {
        for (int i = 0; i < num; i++) {

            //print spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            //print star
            for (int k = 0; k < 2 * num - 2 * i - 1; k++) {
                System.out.print("*");
            }
            //print spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void Pattern9(int num) {
        Pattern7(num);
        Pattern8(num);
    }

    public void Pattern10(int num) {
        for (int i = 0; i < 2 * num - 1; i++) {
            int stars = i + 1;
            if (i >= num) stars = 2 * num - i - 1;
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void Pattern11(int num) {
        for (int i = 0; i < num; i++) {
            int start = 1;
            if ((i + 1) % 2 == 0) start = 0;
            for (int j = 0; j < i + 1; j++) {
                System.out.print(start);
                System.out.print(" ");
                start = 1 - start;
            }
            System.out.println();
        }
    }

    public void Pattern12(int num) {

        for (int i = 0; i < num; i++) {
            //print numbers
            for (int j = 0; j < i+1; j++) {
                System.out.print(j+1);
            }
            //print space
            for (int j = 0; j < 2*num -2*i-2; j++) {
                System.out.print(" ");
            }


            //print numbers
            for (int j = i; j >=0; j--) {
                System.out.print(j+1);
            }

            System.out.println();
        }
    }

    public void Pattern13(int num){
        int count = 1;
        for (int i = 0; i < num; i++) {
            for (int j=0;j<i+1;j++){
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }
    }

    public void Pattern14(int num){
        char count = 'A';
        for (int i = 0; i < num; i++) {
            for (int j=0;j<i+1;j++){
                System.out.print((char) (count +j));
            }
            System.out.println();
        }
    }

    public void Pattern15(int num){
        char count = 'A';
        for (int i = 0; i < num; i++) {
            for (int j=0;j<num-i;j++){
                System.out.print((char) (count +j));
            }
            System.out.println();
        }
    }

    public void Pattern16(int num){
        char count = 'A';
        for (int i = 0; i < num; i++) {
            for (int j=0;j<i+1;j++){
                System.out.print((char) (count +i));
            }
            System.out.println();
        }
    }

    public void Pattern17(int num){
        char count = 'A';
        int inc;
        for (int i = 0; i < num; i++) {
             inc = 0;
            //print space
            for (int k = 0 ; k<num-i-1;k++){
                System.out.print(" ");
            }
            for (int j=0;j<2*i+1;j++){
                if (j>i) inc--;
                else inc++;
                System.out.print((char) (count +inc-1));
            }
            //print space
            for (int k = 0 ; k<num-i-1;k++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void Pattern18(int num){
        char count = 'A';
        for (int i = 0; i < num; i++) {
            for (int j=0;j<i+1;j++){
                System.out.print((char) (count + num-1+j-i));
            }
            System.out.println();
        }
    }

    public void Pattern19(int num){
        int stars= num;
        for (int i = 0; i <2*num; i++) {

            if (i>=num) stars = i-num+1;
            //print stars
            for (int j=0;j<stars;j++){
                System.out.print("*");
            }

            //print space
            for (int s = 0 ; s<2*i;s++){
                System.out.print(" ");
            }
            //print stars
            for (int j=stars;j>i;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
