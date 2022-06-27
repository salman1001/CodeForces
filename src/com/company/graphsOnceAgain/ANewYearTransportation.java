package com.company.graphsOnceAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ANewYearTransportation {
    static  FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        int n= fs.nextInt();int t= fs.nextInt();
        int[] arr=fs.readArray(n-1);
        boolean reached=false;
        int curPos=1;
        for (int i=0;i<n-1;i++){
            if (i==curPos-1){
                curPos+=arr[curPos-1];
                if (curPos==t){
                    reached=true;
                }
            }

        }
        System.out.println(reached?"YES":"NO");


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
