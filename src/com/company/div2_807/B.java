package com.company.div2_807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B {
    static FastScanner fs=new FastScanner();

    public static void main(String[] args) {
        int tcc= fs.nextInt();
        for (int u=0;u<tcc;u++){
            int n= fs.nextInt();
            long[] arr=new long[n];
            for (int i=0;i<n;i++) arr[i]= fs.nextLong();
            boolean isdone=false;
            long ans=0;
            for (int i=0;i+1<n;i++){
                ans+=arr[i];
                if (arr[i]!=0) isdone=true;
                else if (isdone) ans++;

            }
            System.out.println(ans);



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
