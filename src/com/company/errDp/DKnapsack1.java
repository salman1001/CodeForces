package com.company.errDp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class DKnapsack1 {
//    static class Pair{
//        int w;
//        long va;;
//         public Pair(int w,long val){
//             this.va=val;
//             this.w=w;
//         }
//    }
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        int n=fs.nextInt();
        int w=fs.nextInt();
        int we;
        long[] dp=new long[w+10];
        long v;
        for (int i=0;i<n;i++){

            we= fs.nextInt();
            v= fs.nextLong();
            for (int we_al=w-we;we_al>=0;we_al--){
              //  max_self(dp[we_al+w],dp[we_al]+v);
                dp[we_al+we]=  Math.max(dp[we_al+we],dp[we_al]+v);
            }

        }
        //dp[i]====the maximum amount that I have achieve with exactly i weight
        long ans=0;
        for (int i=0;i<=w;i++){
           // max_self(ans,dp[i]);
            ans=Math.max(ans,dp[i]);

        }
        System.out.println(ans);


    }

    private static void max_self(long i, long l) {
        i=Math.max(i,l);
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
