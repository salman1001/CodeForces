package com.company.div2_807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class A {
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        int t= fs.nextInt();
        for (int i=0;i<t;i++){
            int n= fs.nextInt();int x= fs.nextInt();
            int[] arr= fs.readArray(2*n);
            Arrays.sort(arr);
            boolean isPoss=true;
            for (int j=2*n/2;j<2*n;j++){
                if ((arr[j]-arr[j-n]<x)) isPoss=false;

            }
            System.out.println(isPoss?"YES":"NO");
        }


    }



    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static class FastScanner {
        public BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
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
