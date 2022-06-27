package com.company.codeforces.round663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BFixYou {
    static FastScanner fs=new FastScanner();

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while (tc-- > 0) {
            int m, n;
            n = fs.nextInt();m = fs.nextInt();char[][] arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = fs.next();
                arr[i] = s.toCharArray();
            }
            int count = 0;
            for (int i=0;i<n;i++){
                if (arr[i][m-1]=='R')count++;
            }
            for (int i=0;i<m;i++){
                if (arr[n-1][i]=='D') count++;
            }
            System.out.println(count);

        }
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
