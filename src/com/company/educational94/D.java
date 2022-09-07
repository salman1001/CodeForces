package com.company.educational94;

import java.util.Scanner;

public class D {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        int[] arr;
        for (int i=0;i<tc;i++){
            int n= sc.nextInt();
            arr=new int[n];
            for (int j=0;j<n;j++) {
                arr[j]= sc.nextInt();
                --arr[j];
            }
            long [] lcnt=new long[n];
            long[] rcnt=new long[n];
            long ans=0;

            for (int j=0;j<n;j++){
                for (int k=0;k<n;k++) lcnt[k]=rcnt[k]=0;
                long nMatches=0;
                for (int l=j+1;l<n;l++) ++rcnt[arr[l]];
                for (int m=j+1;m<n;m++){
                    nMatches-=lcnt[arr[m]];
                    --rcnt[arr[m]];
                    if (m>j+1){
                        nMatches+=rcnt[arr[m-1]];
                        ++lcnt[arr[m-1]];
                    }
                    if (arr[j]==arr[m]) ans+=nMatches;

                }
            }
            System.out.println(ans);



        }

    }
}
