package com.company.codeforces103;

import java.util.Scanner;

public class Infaltion {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc=sc.nextInt();
        for (int j=0;j<tc;j++){
            int n= sc.nextInt();
            int k=sc.nextInt();
            long[] arr=new long[n];
            for (int i=0;i<n;i++) arr[i]= sc.nextLong();
            long ans=0;long asOfNOW=arr[0];
            for (int i=1;i<n;i++){
                long toLook=(100*arr[i]+k-1)/k;
                ans=Math.max(ans,Math.max(0L,toLook-asOfNOW));
                asOfNOW+=arr[i];
            }
            System.out.println(ans);

        }

    }
}
