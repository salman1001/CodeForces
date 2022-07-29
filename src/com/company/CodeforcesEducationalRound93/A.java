package com.company.CodeforcesEducationalRound93;

import java.util.Scanner;

public class A {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc=sc.nextInt();
        for (int k=0;k<tc;k++){
            int n= sc.nextInt();
            int[] arr=new int[n];
            for (int j=0;j<n;j++){
                arr[j]= sc.nextInt();
            }
            if (arr[0]+arr[1]<=arr[n-1]) System.out.println(1+" "+2+" "+n);
            else System.out.println(-1);




        }

    }
}
