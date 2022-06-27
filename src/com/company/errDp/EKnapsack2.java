package com.company.errDp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class EKnapsack2 {



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
    static FastScanner fs=new FastScanner();

    public static void main(String[] args) {
        int n=fs.nextInt();
        long w=fs.nextLong();
        long[] weight=new long[n];
        int[] value=new int[n];
        for (int i=0;i<n;i++){
            weight[i]= fs.nextLong();
            value[i]= fs.nextInt();
        }

        int sum =0;
        for (int i=0;i<n;i++){
            sum+=value[i];
        }
        long[] dp=new long[sum+1];
        for (int i=0;i<sum+1;i++){
            dp[i]=1000000005;
        }
        dp[0]=0;
        for (int i=0 ;i<n;i++){
            for (int val_al=sum-value[i];val_al>=0;val_al--){
                dp[val_al+value[i]]=   Math.min(dp[val_al+value[i]],dp[val_al]+weight[i]);
            }
        }
        long ans=0;
        for (int i=0;i<=sum;i++){
            if (dp[i]<=w){
                ans=Math.max(ans, i);

            }
        }
        System.out.println(ans);





    }

}
