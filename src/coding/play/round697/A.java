package coding.play.round697;

import java.util.Scanner;

public class A {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for (int i=0;i<tc;i++){
            long n= sc.nextLong();
            while (n%2==0)n/=2;
            System.out.println(n>1?"YES":"NO");
        }



    }

}
