package com.company.div2_685;

import java.util.Scanner;

public class A {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for (int i=0;i<tc;i++){
            long n= sc.nextLong();
            if (n==3) {
                System.out.println("2"); continue;
            }
            if (n==1) {
                System.out.println("0");continue;
            }
            if (n==2){
                System.out.println("1");continue;
            }
            if (n%2==0) System.out.println("2");
            else System.out.println("3");

        }



    }
}
