package com.company.div_808;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class C {
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        int tc= fs.nextInt();
        for (int i=0;i<tc;i++){
            int n= fs.nextInt();long q= fs.nextLong();
            long[] arr=fs.readArray(n);
            StringBuilder stringBuilder=new StringBuilder();
            long iq=0;
            for (int j=n-1;j>=0;j--){
                if (iq>=arr[j]) {
                    stringBuilder.append("1");
                }
                if (iq<arr[j]) {
                    if (iq<=q-1){
                        iq++;
                        stringBuilder.append("1");

                    }
                    else {
                        stringBuilder.append("0");
                    }
                }

                //  if (arr[j]>q) stringBuilder.append("0");


            }
            System.out.println(stringBuilder.reverse());
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
        long[] readArray(int n) {
            long[] a=new long[n];
            for (int i=0; i<n; i++) a[i]=nextLong();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
