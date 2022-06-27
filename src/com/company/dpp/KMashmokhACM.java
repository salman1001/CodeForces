package com.company.dpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class KMashmokhACM {
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        int n= fs.nextInt();int k= fs.nextInt();long mod=1000000007L;
        long dp[][]=new long[k+1][n+1];
        dp[0][1]=1;
        for (int i=0;i<k;i++){
            for (int j=1;j<=n;j++){
                for (int v=j;v<=n;v+=j){
                    dp[i+1][v]=(dp[i+1][v]+dp[i][j])&mod;
                }
            }
        }
        long ans=0;
        for (int i=1;i<=n;i++) ans=(ans+dp[k][i])%mod;
        System.out.println(ans);



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
