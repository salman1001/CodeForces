package com.company.round701;

import java.util.Scanner;

public class B {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();int q= sc.nextInt();int k= sc.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)arr[i]= sc.nextInt();
        for (int i=0;i<q;i++){
            int l= sc.nextInt();l--;
            int r= sc.nextInt();r--;
            int count=0;
            for (int j=l;j<=r;j++){
                if (j==l){
                   if( k>=arr[j+1]){
                       count+=arr[j+1]-2;
                   }
                   else {
                       count+=k-1;
                   }
                   continue;

                  //  count+=arr[j+1]-1;

                }
                if (j==r-1){
                    if( k>=arr[j-1]){
                        count+=k-arr[j-1]-1;
                    }
                    continue;

                }
                if (k>=arr[j+1]){
                    count+=arr[j+1]-arr[j-1]-1;
                }
                else {
                    if (k<=arr[j-1]) continue;
                    else {
                        count+=k-arr[j-1];
                    }
                }

            }
            System.out.println(count);


        }



    }
}
