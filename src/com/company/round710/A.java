package com.company.round710;

import java.util.Scanner;

public class A {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc=sc.nextInt();
        for (int i=0;i<tc;i++){
            long n= sc.nextLong();long m= sc.nextLong();long x= sc.nextLong();x--;
          int c1= (int) (x/n);int c2=(int) (x%n);
          long ans=c1+c2*m+1;
            System.out.println(ans);


        }



    }
}
