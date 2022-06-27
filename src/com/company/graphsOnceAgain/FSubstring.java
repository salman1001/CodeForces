package com.company.graphsOnceAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FSubstring {
    static FastScanner fs=new FastScanner();
    static long[] indegree=new long[300005];
    static ArrayList topSort=new ArrayList();
    static long[] dp=new long[300005];

    static ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    public static void main(String[] args) {
        int n= fs.nextInt();int m= fs.nextInt();String  s= fs.next();
        for (int i=0;i<n;i++) adj.add(new ArrayList<>());
        for (int i=0;i<m;i++){
            int a= fs.nextInt();int b= fs.nextInt();a--;b--;
            adj.get(a).add(b);
            indegree[b]++;
        }
        Queue<Long> queue=new LinkedList<>();
        int count=0;
        for (long i=0;i<n;i++){
            if (indegree[(int) i]==0){
                queue.add(i);
            }

        }
        while (!queue.isEmpty()){
            count++;
            long a=queue.peek();
            queue.remove();
            topSort.add(a);
            for (long d:adj.get((int) a)){
                indegree[(int) d]--;
                if (indegree[(int) d]==0) queue.add(d);
            }
        }
        if (count<n) {
            System.out.println(-1);
            return;
        }
        long ans=0;
        for (char c='a';c<='z';c++){
            for (int i=0;i<n;i++) dp[i]=0;

            for (int a=0;a<topSort.size();a++){
                if (s.charAt(a)==c) dp[a]++;
                for (int f:adj.get(a)){
                    dp[f]=Math.max(dp[f],dp[a] );
                }
                ans=Math.max(ans,dp[a]);

            }


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
