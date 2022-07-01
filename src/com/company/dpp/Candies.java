package com.company.dpp;

import java.util.Scanner;

public class Candies {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int n,k;
        n= sc.nextInt();k= sc.nextInt();
        //dp[i]----no of ways such that we have i candies so far
        int[] arr=new int[k+1];
        arr[0]=1;
        for (int child=0;child<n;child++){
            int up_to= sc.nextInt();
            int[] fake=new int[k+1];
            for (int used=k;used>=0;used--){
                int temp=arr[used];
                int L=used+1;
                int R=used+Math.min(up_to,k-used);
                if (L<=R){
                    fake[L]=fake[L]+temp;
                    if (R+1<=k) fake[R+1]=fake[R+1]-temp;
                }
            }


            int psum=0;
            for (int i=0;i<=k;i++){
                psum=(psum+fake[i])%1000000007;
                arr[i]=(arr[i]+psum)%1000000007;

            }
        }
        System.out.println(arr[k]%1000000007);


    }
}
