package com.company.errDp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class GLongestPath {

    static int[] distances=new int[100005];
    static int[] indegree=new int[100005];
    static ArrayList[] edges =new ArrayList[100005];
    static boolean[] visited=new boolean[100005];

     static void dfs(int a){
        visited[a]=true;
//        for (int b:edges[a]){
//            distances[b]=Math.max(distances[b], distances[a]+1);
//            --indegree[b];
//            if (indegree[b]==0){
//                dfs(b);
//
//            }
//
//
//
//        }


    }
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        int n= fs.nextInt();
        int m= fs.nextInt();
        int a,b;

        for (int i=0;i<m;i++){
            a= fs.nextInt();
            b= fs.nextInt();

          //  edges[a].add(a,b);
            edges[a].add(b);


            indegree[b]++;

        }
        for (int i=1;i<=n;i++){
            if (!visited[i]&&indegree[i]==0){
                dfs(i);
            }
        }
        int ans=0;
        for (int i=1;i<=n;i++)
            Math.max(ans,distances[i]);
        System.out.println(ans);



//        int[] dp=new int[n+5];
//        for (int i=0;i< dp.length;i++){
//            dp[i]=-1000000005;
//        }
//        Pair[] arr=new Pair[m+5];
//        int a,b;
//        for (int i=0;i<m;i++){
//            a= fs.nextInt();
//            b= fs.nextInt();
//            arr[i]=new Pair(a,b);
//        }
//        for (int i=0;i<n;i++){
//            for (int j=0;j<n;j++){
//                if (arr[i].from==i&&arr[i].to==j){
//                    dp[]
//                }
//            }
//        }





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
