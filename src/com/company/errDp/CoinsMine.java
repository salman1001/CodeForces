package com.company.errDp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CoinsMine {
    static Scanner fs=new Scanner(System.in);
    public static void main(String[] args) {
        int n= fs.nextInt();
        double[] arr=new double[n+1];
        arr[0]=1.00;
        for (int i=0;i<n;i++){
             double pHeads=fs.nextDouble();
            for (int j=i;j>=0;j--){
                arr[j+1]+=pHeads*arr[j];
                arr[j]=(1-pHeads)*arr[j];
            }
        }
        double ans=0;
        for (int i=n/2+1;i<=n;i++){
            ans+=arr[i];
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
