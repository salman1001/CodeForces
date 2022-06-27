package com.company.errDp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class PIndependentSet {
     static class Pair{
        int a,b;
        Pair(int a,int b){
            this.a=a;
            this.b=b;

        }



    }
    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
     static int nax=10005;
    static int mod=1000000007;
     static ArrayList<ArrayList<Integer> > edges = new ArrayList<>(nax);
     static FastScanner fs=new FastScanner();
     public static void main(String[] args) {
        int n=fs.nextInt();
        for (int i=0;i<n-1;i++) {
            int a ,b;a=fs.nextInt();b=fs.nextInt();
            addEdge(edges,a,b);
            addEdge(edges,b,a);

        }
      //  dfs(1,-1);
     }

//    private static Pair dfs(int a,int parent) {
//         for (int i=0;i<edges.get(a).size();i++){
//             if (i!=parent){
//                 dfs(i,a);
//                 Pair pair=new Pair(i,a);
//             }
//
//         }
//
//     }

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
