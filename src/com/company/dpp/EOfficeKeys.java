package com.company.dpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class EOfficeKeys {
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        int n= fs.nextInt();
        int k= fs.nextInt();
        long p= fs.nextLong();
        long a[] =new long[n];
        for (int i=0;i<n;i++) a[i]= fs.nextLong();
        long b[] =new long[k];
        for (int i=0;i<k;i++) b[i]= fs.nextLong();
        sort(b);

        long inf=1000000000000000000L;
        long[][] dp=new long[k+1][n+1];
        for (int i=0;i<=k;i++){
            for (int j=0;j<=n;j++){
                dp[i][j]=inf;
            }
        }
        //dp[i][j]===j people has been assigned and we are at ith key
        dp[0][0]=0;

        for (int i=0;i<k;i++){
            for (int j=0;j<=n;j++){
                dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]);
                if (j<n){
                    dp[i+1][j+1]=Math.min(dp[i+1][j+1],
                            Math.max(dp[i][j],
                                    Math.abs(a[j]-b[i])+Math.abs(b[i]-p)
                                     ));
                }
            }
        }
        System.out.println(dp[k][n]);
    }



    static void sort(long[] a) {
        ArrayList<Long> l=new ArrayList<>();
        for (long i:a) l.add(i);
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
