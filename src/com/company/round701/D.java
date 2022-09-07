package com.company.round701;

import java.util.Scanner;

public class D {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        int m= sc.nextInt();
       // int [][] arr=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++) {
                int a = sc.nextInt();
                if ((i+j)%2==0) System.out.print(720720+" ");
                else System.out.print(720720+(int) Math.pow(a,4)+" ");
            }
            System.out.println();
        }



    }
}
