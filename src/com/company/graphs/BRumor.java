package com.company.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BRumor {
    static FastScanner fs=new FastScanner();
    static long ans=0;
    static boolean[] visited;
     static long[] arr;
static ArrayList<ArrayList<Integer>> arrays=new ArrayList<>();


    public static void main(String[] args) {
        int n= fs.nextInt();
        int m= fs.nextInt();
         arr=new long[n];
        visited=new boolean[n];

        for (int i=0;i<n;i++){
            arr[i]= fs.nextLong();
        }
        for (int i=0;i<n;i++){
            arrays.add(i,new ArrayList());
        }
        for (int i=0;i<m;i++){
            int u,v;
            u= fs.nextInt();
            v= fs.nextInt();
            u--; v--;
            arrays.get(u).add(v);
            arrays.get(v).add(u);
        }

        ans=0;
        for (int i=0;i<n;i++){
            if (!visited[i]){
                ans+=dfs(i);
                //System.out.println(ans);
            }
        }
        System.out.println(ans);



    }

    private static long dfs(int i) {
        long min=arr[i];
        visited[i]=true;
        for (int j=0;j<arrays.get(i).size();j++){
            if (!visited[arrays.get(i).get(j)]){
                min=Math.min(min,dfs(arrays.get(i).get(j)));
            }
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
