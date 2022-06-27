package com.company.dpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class GCoveredPath {
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        int start,end;
        start= fs.nextInt();end=fs.nextInt();
        int time= fs.nextInt();int d= fs.nextInt();
        long cons =-1000000000000000000L;
        long [][] dp=new long[time][1000];
        for (int i=0;i<time;i++){
            for (int j=0;j<1000;j++){
                dp[i][j]=cons;
            }
        }
        dp[0][start]=0;
        for (int i=0;i<time-1;i++){
            for (int j=0;j<1000;j++){
                for (int k=-d;k<=d;k++){
                    if (j+k>0&&j+k<1000){
                        dp[i+1][j+k]=Math.max(dp[i+1][j+k],dp[i][j]+j);
                    }
                }
            }
        }
        System.out.println(end + dp[time - 1][end]);


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
