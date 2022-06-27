package com.company.errDp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import java.util.StringTokenizer;

public class BFrog2 {
    static FastScanner fs= new FastScanner();
    private static int[] dp;
    public static void main(String[] args) {
        int n= fs.nextInt();
        int k= fs.nextInt();
        dp=new int[n+10];
        int[] arr=new int[n+10];
        for (int i=0;i<n;i++){
            arr[i]= fs.nextInt();
        }
        for (int i=0;i< dp.length;i++){
            dp[i]=1000000005;
        }
        dp[0]=0;

        for (int i=0;i<n;i++){
            for (int j=i+1;j<=i+k;j++){
                if (j<n){
                    dp[j]=Math.min(dp[i]+Math.abs(arr[i]-arr[j]),dp[j]);

                }
            }
        }
        System.out.println(dp[n-1]);


    }


    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
