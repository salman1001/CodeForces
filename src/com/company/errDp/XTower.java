package com.company.errDp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class XTower {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n= sc.nextInt();
        Type[] arr=new Type[n];
        for (int i=0;i<n;i++){
            arr[i]=new Type(sc.nextInt(), sc.nextInt(), sc.nextLong());
        }
        Arrays.sort(arr, Comparator.comparing(a->(a.weight+a.solidNess)));
     //   System.out.println(arr[1].weight+" "+arr[1].solidNess);
        long[][] dp=new long[1009][20123];
        for (int i=0;i<n;i++) dp[i][arr[i].weight]=arr[i].value;

        for (int i=0;i<n;i++){
            for (int tillnow=0;tillnow<arr[i].solidNess;tillnow++){
                dp[i+1][tillnow]=Math.max(dp[i+1][tillnow],dp[i][tillnow]);

                dp[i+1][tillnow+arr[i].weight]=Math.max(dp[i][tillnow+arr[i].weight],(dp[i][tillnow]+arr[i].value));
            }
        }
//       for (Type type:arr){
//           for (int w=type.solidNess;w>=0;w--){
//               dp[w+type.weight]=Math.max(dp[w+type.weight],dp[w]+type.value);
//           }
//       }
//        long max = Long.MIN_VALUE;
//        for(long v : dp)max = Math.max(max, v);
//        System.out.println(max);
        long max = Long.MIN_VALUE;
        for (int i=0;i<20123;i++){
            max=Math.max(max,dp[n-1][i]);
        }
        System.out.println(max);
    }
    static class Type{
        int weight;
        int solidNess;
        long value;

        public Type(int weight, int solidNess, long value) {
            this.weight = weight;
            this.solidNess = solidNess;
            this.value = value;
        }
    }
}
