package com.company.round826;

import java.util.Scanner;

public class B {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int tc=sc.nextInt();
        for (int i=0;i<tc;i++){
            int n= sc.nextInt();
            if (n==1||n==3) {

                System.out.println(-1);continue;
            }
            for (int j=n;j>Math.ceil(n/2.0);j--) System.out.print(j+" ");
            for (int j=1;j<=Math.ceil(n/2.0);j++) System.out.print(j+" ");
            System.out.println();




//
        }

    }
}
