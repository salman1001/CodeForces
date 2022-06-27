package com.company.theSweepLineTechnique;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EMikeGeometryProblem {
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
      //  long[] l,r;

        int n= fs.nextInt();
        int k= fs.nextInt();
     //   l=new long[n];
      //  r=new long[n];
        Map<Long,Long> map=new HashMap<>();
        for (int i=0;i<n;i++){
            long a,b;
            a= fs.nextLong();
            b= fs.nextLong();
            long var1=map.get(a).longValue();
            long var2=map.get(b+1).longValue();
            var2--;
            var1++;
            map.put(a,var1);
            map.put(b+1,var2);

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
