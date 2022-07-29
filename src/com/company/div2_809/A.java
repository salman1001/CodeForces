package com.company.div2_809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A {
    static  FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        int tc= fs.nextInt();
        for (int tcc=0;tcc<tc;tcc++){
            int n= fs.nextInt();int m= fs.nextInt();
            int[] arr = fs.readArray(n);
            StringBuilder stringBuilder=new StringBuilder();
            for (int i=0;i<m;i++){
                stringBuilder.append("B");
            }
            char[] chars=new char[m];
          //  String st =stringBuilder.toString();
            for (int i=0;i<n;i++){
                if (chars[arr[i]-1]!='A'){
//                    stringBuilder.delete(i,i);
//                    stringBuilder.insert(i,'A');
                    chars[arr[i]-1]='A';

                }
                else {
                    chars[(m-(arr[i]))]='A';
//                    stringBuilder.delete((m+1-arr[i]-1)%n,(m+1-arr[i]-1)%n);
//                    stringBuilder.insert((m+1-arr[i]-1)%n,'A');
                  //  stringBuilder.replace((m+1-arr[i]-1)%n,(m+1-arr[i]-1)%n,"A");
                }
            }
            for (int i=0;i<m;i++){
                if (chars[i]!='A') chars[i]='B';
            }
            String ste=String.copyValueOf(chars);
            System.out.println(ste);

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
