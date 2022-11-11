package com.company.graphsOnceAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BRumor {
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        int n= fs.nextInt();int m= fs.nextInt();
        visited=new boolean[n];
        arr= fs.readArray(n);
        adj= new ArrayList<>(n);
        for (int i=0;i<n;i++)adj.add(new ArrayList<>());
        for (int i=0;i<m;i++){
            int a= fs.nextInt();int b= fs.nextInt();a--;b--;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        long ans=0;
        for (int i=0;i<n;i++){
            if (!visited[i]) {
                ans+=dfs(i);
            }

        }

        System.out.println(ans);






    }
    static  long arr[];
    static  ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;

      static long  dfs(int curr){
          long min=arr[curr];
          visited[curr]=true;
          for (int a:adj.get(curr)) {
              if (!visited[a]) min=Math.min(min,dfs(a));
          }
          return min;

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
