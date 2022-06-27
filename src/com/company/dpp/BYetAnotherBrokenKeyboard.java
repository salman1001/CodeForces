package com.company.dpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BYetAnotherBrokenKeyboard {
    static FastScanner fs=new FastScanner();
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int n= fs.nextInt();
        int k= fs.nextInt();
        int[] arr=new int[26];
        String str=fs.next();
        String s="";
        for (int i=0;i<k;i++){
            s= fs.next();
           int val=s.charAt(0)-'a';
            arr[val]=1;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        long sum=0;
        for (int i=0;i<n;i++){
            if (arr[str.charAt(i)-'a']==1) dp[i+1]=dp[i]+1;
            else dp[i+1]=0;
            sum+=dp[i+1];
        }
        System.out.println(sum);



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
