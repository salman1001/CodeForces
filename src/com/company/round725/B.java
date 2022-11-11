package com.company.round725;

import java.util.Scanner;

public class B {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc=sc.nextInt();
        for (int t=0;t<tc;t++){
            int n= sc.nextInt();
            int[] arr=new int[n];
            int sum=0;
            for (int i=0;i<n;i++) {
                arr[i]= sc.nextInt();
                sum+=arr[i];
            }
            int one=sum/n;
            if (one!=Math.ceil((double) sum/n)){
                System.out.println(-1);
                continue;
            }
            int ans=0;
            for (int i=0;i<n;i++)  if (arr[i]>one)ans++;
            System.out.println(ans);



        }
    }

}
