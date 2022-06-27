package com.company.dpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class DLectureSleep {
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        int n= fs.nextInt();int k= fs.nextInt();int[] a= fs.readArray(n);int[] t= fs.readArray(n);
        int[] psum=new int[n];
        int[] p=new int[n];
        int[] s=new int[n];
        int sum=0;
        for (int i=0;i<n;i++) {
            sum+=a[i];psum[i]=sum;
        }
        int pi=0;
        for (int i=0;i<n;i++){
            pi+=a[i]*t[i];p[i]=pi;
        }
        int si=0;
        for (int i=n-1;i>=0;i--){
            si+=a[i]*t[i];s[i]=si;
        }
        long ans=0;
        for (int i=0;i+k-1<n;i++){
            long cur=0;
            if (i>0) cur+=p[i-1];
            if (i+k<n) cur+=s[i+k];
            long range_sum=psum[i+k-1];
            if (i>0) range_sum-=psum[i-1];
            cur+=range_sum;
            ans=Math.max(ans,cur);
        }
        System.out.println(ans);




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
