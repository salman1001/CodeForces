package com.company.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class GContrivedPaths {
    static class Pair{
        int to;
        long weight;
        Pair(int to,long weight){
            this.to=to;
            this.weight=to;
        }


        public long getWeight() {
            return weight;
        }

        public void setWeight(long weight) {
            this.weight = weight;
        }
    }

    static FastScanner fs =new FastScanner();
    static ArrayList<ArrayList<Pair>> arrList=new ArrayList<>();
    static long[] distances=new long[100005];
    static int n;


    public static void main(String[] args) {
        int m,k;
        n=fs.nextInt();
        m=fs.nextInt();
        k=fs.nextInt();
        long[] arr= new long[n+10];

        int[] arrK=new int[k];
        for (int i=0;i<n;i++){
            arr[i]= fs.nextLong();
        }
        for (int i=0;i<2*n;i++){
            arrList.add(i,new ArrayList<>());
        }
        for (int i=0;i<m;i++){
            int a,b;long w;
            a= fs.nextInt();
            b= fs.nextInt();
            w= fs.nextLong();
            a--;b--;
            arrList.get(a).add(new Pair(b,w));
            arrList.get(b).add(new Pair(a,w));
        }
        for (int i=0;i<k;i++){
            int val= fs.nextInt();
            val--;
            arrK[i]= val;
        }
        for (int i=0;i<n;i++){
            arrList.get(i).add(new Pair(n,arrK[i]));
            arrList.get(n).add(new Pair(i,arrK[i]));
        }
        n++;

    }
    static boolean[] visited=new boolean[100005];
    void dijkstra(int source){
        for (int i=0;i<n;i++){
            distances[i]=1000000009;
            visited[i]=false;
        }
        PriorityQueue<Pair> pq=new PriorityQueue();
        distances[source]=0;
        visited[source]=true;
        pq.add(new Pair(source,0));
        while (!pq.isEmpty()){
            Pair pair=pq.poll();
            long dist=pair.weight;
            int tar=pair.to;
            if (visited[tar]) continue;
            visited[tar]=true;
            for (int i=0;i<arrList.get(tar).size();i++){
          //      long distances=dist+arrList.get(tar).get(i).
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

