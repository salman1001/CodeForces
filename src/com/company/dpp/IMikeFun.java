package com.company.dpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class IMikeFun {
    static int m;
    static int  n;
    static int[][] array;
    static long[] best;
    static  FastScanner fs=new FastScanner();

    public static void main(String[] args) {
       n= fs.nextInt(); m= fs.nextInt();
       int q= fs.nextInt();
        array=new int[n][m];
        best=new long[n];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                array[i][j]= fs.nextInt();
            }
        }
        for (int i=0;i<n;i++) solveRow(i);
        long[] anss=new long[q];
        for (int i=0;i<q;i++){
            int a= fs.nextInt();
            int b= fs.nextInt();
            a--;b--;
            array[a][b] ^=1;
            solveRow(a);
            long ans=0;
            for (int y=0;y<n;y++) {
                ans=Math.max(ans,best[y]);
            }
            anss[i]=ans;

        }
        for (int i=0;i<q;i++) System.out.println(anss[i]);


    }

    private static void solveRow(int i) {
        long[] arrm=new long[m+1];
        //dp[i] ----- is the longest no of 1's ending at i
        arrm[0]=0;
        long ans=0;
        for (int j=1;j<=m;j++){
            if (array[i][j-1]==0) arrm[j]=0;
            else arrm[j]=arrm[j-1]+1;
            ans=Math.max(ans,arrm[j]);

        }
        best[i]=ans;



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
