package com.company.codeforces103;

import java.util.Scanner;

public class KDivisibleSum {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for(int i=0;i<tc;i++){
            long n= sc.nextLong();long k= sc.nextLong();
            long a=(n+k-1)/k;
            a*=k;
            System.out.println((a+n-1)/n);
        }

    }
}
