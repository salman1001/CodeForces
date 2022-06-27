package com.company.dpp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CVitamins {
    static FastScanner fs=new FastScanner();

    public static void main(String[] args) {
        int n= fs.nextInt();
        long[][] dp=new long[n+1][8];
        for (int i=0;i<=n;i++){
            for (int j=0;j<8;j++){
                dp[i][j]=1000000009;
            }
        }
        dp[0][0]=0;

        for (int i=0;i<n;i++) {
            long cost;
            String str;
            cost = fs.nextLong();
            str = fs.next();
            int string_mask = 0;
            for (int k = 0; k<3;k++) {
                char c= (char) ('C'-k);
                boolean doyou=false;
                for (int j=0;j<str.length();j++){
                    if (c==str.charAt(j)) doyou=true;
                }
                if (doyou){
                    string_mask+=(1<<k);
                }

            }
            for (int s=0;s<8;s++){
                dp[i+1][s]=Math.min(dp[i+1][s],dp[i][s]);
                dp[i+1][s|string_mask]=Math.min(dp[i+1][s|string_mask],dp[i][s]+cost);
            }

        }
        long ans=dp[n][7];
        if (ans==1000000009) System.out.println(-1);
        else System.out.println(ans);

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
