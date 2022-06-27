package com.company.errDp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class FLCA {
    static class Pair{
          public  int lent =0;
         public   int[] arr;
        Pair(int len,int[] arr){
            len=this.lent;
            arr=new int[2];
        }
    }

    static FastScanner fs=new FastScanner();


    public static void main(String[] args) {
        String s=fs.next();
        String t= fs.next();
        Pair[][] dp=new Pair[s.length()+1][t.length()+1];
        for (int i=0;i<=s.length();i++) {
            for (int j = 0; j <= t.length(); j++) {
                dp[i][j]=new Pair(0, new int[2]);

            }
        }
        //dp[i][j]====The maximum length so far if the last element that was considered was i
        //from string one and j from string two
        for (int i=0;i<s.length();i++){
            for (int j=0;j<t.length();j++){
                if (s.charAt(i)==t.charAt(j))
                {
                    dp[i+1][j+1].lent =Math.max(dp[i+1][j+1].lent,dp[i][j].lent +1);
               //     Pair p=dp[i+1][j+1];

                }
                dp[i+1][j].lent =Math.max(dp[i+1][j].lent,dp[i][j].lent);
                dp[i][j+1].lent =Math.max(dp[i][j+1].lent,dp[i][j].lent);


            }
        }
        int ans=0;
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[i].length;j++){
               // System.out.print;
                ans=Math.max(ans,dp[i][j].lent);
            }
        }
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
