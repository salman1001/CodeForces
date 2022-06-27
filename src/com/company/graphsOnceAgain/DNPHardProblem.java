package com.company.graphsOnceAgain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class DNPHardProblem {
    static FastScanner fs=new FastScanner();
    static boolean[] visited;
    static boolean possible=true;
    static int[] colo;
    static ArrayList<ArrayList<Integer>> adj;
    public static void main(String[] args) {

        int n= fs.nextInt();int m= fs.nextInt();
        visited=new boolean[n];
        colo=new int[n];
        adj=new ArrayList<>(n);
        for (int i=0;i<n;i++) adj.add(new ArrayList<>());
        for (int i=0;i<m;i++){
            int a= fs.nextInt();int b= fs.nextInt();a--;b--;
            adj.get(a).add(b);adj.get(b).add(a);
        }
        for (int i=0;i<n;i++){
            if (!visited[i]) {
                dfs(i,0);
            }
        }
        if (!possible){
            System.out.println(-1);return;
        }
        int[] sizes=new int[2];
        for (int i=0;i<n;i++) ++sizes[colo[i]];

        System.out.println(sizes[0]);
        for (int i=0;i<n;i++) {
            if (colo[i]==0) System.out.print(i+1+" ");
        }
        System.out.println();

        System.out.println(sizes[1]);
        for (int i=0;i<n;i++) {
            if (colo[i]==1) System.out.print(i+1+" ");
        }
        System.out.println();






    }

    private static void dfs(int curr, int color) {
        if (visited[curr]) return;
        visited[curr]=true;
        colo[curr]=color;
        for (int a:adj.get(curr)){
            if (!visited[a]){
                dfs(a,color^1);
            }
            else {
                if (color==colo[a]) possible=false;

            }
        }

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
