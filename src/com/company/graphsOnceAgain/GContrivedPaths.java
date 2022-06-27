package com.company.graphsOnceAgain;

import com.company.codeforces.contest782.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class GContrivedPaths {
    static int vv;
    static  FastScanner fs=new FastScanner();
    static long[] distances=new long[100005];
    static int[] kvals;
     static ArrayList<ArrayList<Pair>> arrayList=new ArrayList<>();
    static class Pair {
        int desti;
        long wei;
        Pair(int desti,long wei){
            this.wei=wei;
            this.desti=desti;
        }


    }
    static class PqPair implements Comparable<PqPair>{
        long dist;
        int target;

        public PqPair(long dist, int target) {
            this.dist = dist;
            this.target = target;
        }

        @Override
        public int compareTo(PqPair o) {

            return (int) (o.dist-dist);
        }
    }

    public static void main(String[] args) {
        int n= fs.nextInt();int m= fs.nextInt();int k= fs.nextInt();
        long[] arr=new long[n];
        kvals=new int[k];
        vv=n;
        for (int i=0;i<n;i++) {
            arr[i]= fs.nextLong();

        }
        for (int i=0;i<n+1;i++) arrayList.add(new ArrayList<>());

        for (int i=0;i<m;i++) {
            int a= fs.nextInt();int b= fs.nextInt();long w= fs.nextLong();a--;b--;
            arrayList.get(a).add(new Pair(b,w));
            arrayList.get(b).add(new Pair(a,w));
        }
        for (int i=0;i<n;i++){
            arrayList.get(i).add(new Pair(n,arr[i]));
            arrayList.get(n).add(new Pair(i,arr[i]));
        }
        n++;
        vv=n;
        for (int i=0;i<k;i++) {
            int ss= fs.nextInt();ss--;
            // kvals[i]= ss;
            dijkstra(ss);
            for (int t=0;t<n;t++) System.out.print(distances[t]+" ");
            System.out.println();

        }










    }
    static boolean[] vis=new boolean[100005];
   static void dijkstra(int  source){
        for (int i=0;i<vv;i++) {
            distances[i]=Long.MAX_VALUE;
        }
        PriorityQueue<PqPair> pq=new PriorityQueue<>();
        distances[source]=0;
        pq.add(new PqPair(0,source));
        while (!pq.isEmpty()){
            PqPair pqPair= pq.peek();pq.remove();
            long dis=pqPair.dist;int target=pqPair.target;
            if (vis[target]) continue;
            vis[target]=true;
            for (Pair p:arrayList.get(target)){
                long dist=dis+p.wei;
                if (dist<distances[p.desti]){
                    distances[p.desti]=dist;
                    pq.add(new PqPair(dist,p.desti));

                }

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
