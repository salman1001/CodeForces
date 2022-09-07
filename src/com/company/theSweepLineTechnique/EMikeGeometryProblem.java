package com.company.theSweepLineTechnique;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EMikeGeometryProblem {
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        int n= fs.nextInt();int k= fs.nextInt();
        long ans=0;

        Map<Long,Long> active=new HashMap<>();
        for (int i=0;i<n;i++){
            long l= fs.nextLong();
            long r= fs.nextLong();
//            long diff=r-l+1;
//            active.put(l,diff);
//            active.put(r,-diff);
            active.putIfAbsent(l, 0L);
             long val1=active.get(l);val1++;
             active.put(l,val1);
            active.putIfAbsent(r+1, 0L);

            long val2=active.get(r+1);val2--;
            active.put(r+1,val2);
            ArrayList<Long> arrayList=new ArrayList<>();
            for (Map.Entry<Long,Long> entry : active.entrySet()) arrayList.add(entry.getKey());
            long curr=0;
            for (int j=0;j< arrayList.size()-1;j++){
                curr+=active.get(arrayList.get(j));
                long size=arrayList.get(j+1)-arrayList.get(j);
                if (curr>=k) ans=(ans+combinations(curr,k)*size)%1000000007;
            }
        }
        System.out.println(ans);




    }
        public static long combinations(long n, long r) {
        long numerator = 1, denominator = 1;
        if (r > n - r) {
            r = n - r;
        }
        for (long i = 1L; i <= r; ++i) {
            denominator *= i;
        }
        for (long i = n - r + 1L; i <= n; ++i) {
            numerator *= i;
        }
        return  (long) numerator / denominator;
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
