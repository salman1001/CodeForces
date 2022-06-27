package com.company.dpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
// An Example of Pull Dp
public class HThreedisplays {
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        int n= fs.nextInt();long[] font=fs.readArray(n);long[] price=fs.readArray(n);
        long dp[][]=new long[n+1][3];
        long inf=1000000000000000000L;
        long ans=inf;
        for (int i=0;i<n;i++){
            dp[i][0]=price[i];
            for (int j=1;j<3;j++){
                dp[i][j]=inf;
                for (int k=0;k<i;k++){
                    if (font[i]>font[k]){
                        dp[i][j]=Math.min(dp[i][j],dp[k][j-1]+price[i]);
                    }
                }
            }
            ans=Math.min(ans,dp[i][2]);
        }
        if (ans==inf) System.out.println(-1);
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
        long[] readArray(int n) {
            long[] a=new long[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
