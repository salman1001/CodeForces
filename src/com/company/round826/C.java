package com.company.round826;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc=sc.nextInt();
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)  arr[i]=sc.nextInt();
        long[] pre=new long[n];
        pre[0]=arr[0];
        long sum=0;
        sum+=arr[0];

        for (int i=1;i<n;i++) {
            pre[i]=pre[i-1]+arr[i];
            sum+=arr[i];
        }
      //  boolean found =false;
        for (int i=2;i<=n;i++){
           int ans= Arrays.binarySearch(pre,sum/i);
           if(ans==-1) continue;
        ///   if ((long) (ans + 1) *i!=sum) continue;
           int k=ans;
            System.out.println(i);
            return;
//           boolean is=true;
//           while (k<n&&is){
//              if( pre[2*k+1]-pre[k]!=sum/i){
//                  is=false;
//              }
//              else {
//                  k=k*2-1;
//              }
//              if (k==n-1){
//                  System.out.println(i);
//                  return;
//              }
//
//           }

        }




    }
}
