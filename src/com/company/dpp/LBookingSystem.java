package com.company.dpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class LBookingSystem {
    static class Pair{
        int size;
        int price;

        public Pair(int size, int price) {
            this.size = size;
            this.price = price;
        }
    }
    static  FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        // Which request to accept and which to decline so that money earned is maximum
        int n= fs.nextInt();
        ArrayList<Pair> listOfPeople=new ArrayList<>();
        for (int i=0;i<n;i++){
            int size= fs.nextInt();
            int price= fs.nextInt();
            Pair p=new Pair(size,price);
            listOfPeople.add(p);
        }
        int chair= fs.nextInt();
        int [] chairSizes= fs.readArray(chair);
        Arrays.sort(chairSizes);


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
