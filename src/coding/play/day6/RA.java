package coding.play.day6;

import java.util.Scanner;

public class RA {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for (int t=0;t<tc;t++){
            int n= sc.nextInt();
            int m= sc.nextInt();
            for (int i=0;i<n;i++)m-= sc.nextInt();
            System.out.println((m==0)?"YES":"NO");

        }




    }
}
