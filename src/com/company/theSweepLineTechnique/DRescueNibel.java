package com.company.theSweepLineTechnique;

import com.company.codeforces.contest782.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DRescueNibel {

//       public static class Pair{
//
//        long l;
//        long r;
//        Pair(long l,long r){
//            this.r=r;
//            this.l=l;
//
//        }
//    }


    static FastScanner fs=new FastScanner();

    public static void main(String[] args) {
     //   ArrayList<Pair> pairs=new ArrayList<>();
//        ArrayList<Integer> l=new ArrayList<>();
//        ArrayList<Integer> r=new ArrayList<>();
        long[] l,r;

        int n= fs.nextInt();
        int k= fs.nextInt();
        l=new long[n];
        r=new long[n];
        for (int i=0;i<n;i++){
            long a,b;
            a= fs.nextLong();
            b= fs.nextLong();
            l[i]=a;
            r[i]=b;
//            Pair pair=new Pair(a,b);
//            pairs.add(pair);

        }
        Arrays.sort(l);
        Arrays.sort(r);
        int i=0;
        int j=0;
        long on=0;
        long ans=0;
        while (i<n &&j<n){
           // System.out.println(i+" "+n+" "+j);
            if (l[i]<=r[j]){
                on++;
                i++;


                if (on>=k){

                    //System.out.println("On has become   "+on+"  and i and j are  " +l[i-1]+"  "+r[j-1]);
                    ans=(ans+ nCr(on,k))%998244353;
                   // ans=ans+Math.abs(i-j+1);
               //      ans=(ans+ combinations(on,k-1)*Math.abs(j-i))%998244353;

                }



            }
            else {
                on--;
                j++;
            }

        }
        ans=ans%998244353;
        System.out.println(ans);




    }
//    public static long combinations(long n, long r) {
//        long numerator = 1, denominator = 1;
//        if (r > n - r) {
//            r = n - r;
//        }
//        for (long i = 1L; i <= r; ++i) {
//            denominator *= i;
//        }
//        for (long i = n - r + 1L; i <= n; ++i) {
//            numerator *= i;
//        }
//        return  (long) numerator / denominator;
//    }








    //
     static long nCr(long n,long r)
        {
            if (r==0||n-r==0 )return 1L;
            return fact(n) / (fact(r) *
                    fact(n - r));
        }

        // Returns factorial of n
        static long fact(long n)
        {
            long res = 1;
            for (long i = 2; i <= n; i++)
                res = res * i;
            return res;
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
