package com.company.December.graphs;

import com.company.Day1.Pattern;
import com.company.random.A;
import kotlin.Pair;

import java.util.*;

public class GContrivedPath {
    static Scanner sc=new Scanner(System.in);
   // static ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
   static long[] distances=new long[100005];
   static boolean[] visit=new boolean[100005];
    static ArrayList<ArrayList<Node>> edges=new ArrayList<>();
    static int n;


    public static void main(String[] args) {
       n= sc.nextInt();int m= sc.nextInt();int k= sc.nextInt();
        long[] a=new long[n];
        for (int i=0;i<n;i++)a[i]=sc.nextLong();
        for (int i=0;i<=n;i++) edges.add(new ArrayList<>());
        for (int i=0;i<m;i++) {
            int u = sc.nextInt();int v = sc.nextInt();u--;v--;
            long weight= sc.nextLong();
            edges.get(u).add(new Node(v,weight));
            edges.get(v).add(new Node(u,weight));

        }
        for (int i=0;i<n;i++){
            edges.get(i).add(new Node(n,a[i]));
            edges.get(n).add(new Node(i,a[i]));
        }
        n++;
        int[] kval=new int[k];

        for (int i=0;i<k;i++) {
            int ss= sc.nextInt();ss--;
            // kvals[i]= ss;
            dijisktra(ss);
            for (int t=0;t<n-1;t++) System.out.print(distances[t]+" ");
            System.out.println();

        }
    }
    static class Prior implements Comparable<Prior>{
        long dist;
        int source;

        public Prior(long dist, int source) {
            this.dist = dist;
            this.source = source;
        }

        @Override
        public int compareTo(Prior o) {
            return (int) (o.dist-dist);
        }
    }
    static void dijisktra(int source){
        for (int i=0;i<n;i++) {
            distances[i]= (long) 1e18;
            visit[i]=false;
        }
        PriorityQueue<Prior> priorityQueue=new PriorityQueue<>();
        distances[source]=0;
       // visit[source]=true;
        priorityQueue.add(new Prior(0,source));
        while (!priorityQueue.isEmpty()){
            Prior pair=priorityQueue.poll();
            long dist=pair.dist;
            int target=pair.source;
            if(visit[target]) continue;
            visit[target]=true;
            for (Node e:edges.get(target)){
                long ndist=dist+e.weight;
                if (ndist<distances[e.destination]){
                    distances[e.destination]=ndist;
                    priorityQueue.add(new Prior(distances[e.destination], e.destination));
                }
            }
        }
    }
    static class Node{
        int destination;
        long weight;

        public Node(int destination, long weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }




//
//    static void dijkstra(int src,long[] distance) {
//        Arrays.fill(distance, 3);
//        int n=distance.length;
//        boolean[] visited=new boolean[n];
//        PriorityQueue<long[]> p=new PriorityQueue<>(new Comparator<long[]>() {
//            public int compare(long[] a,long[] b) {
//                return Long.compare(a[1],b[1]);
//            }
//        });
//        distance[src]=0;
//        p.add(new long[] {src,0});
//        while(!p.isEmpty()) {
//            long[] curr=p.poll();
//            if(visited[(int)curr[0]]) {
//                continue;
//            }
//            visited[(int)curr[0]]=true;
//            for(int[] child:g[(int)curr[0]]) {
//                if(distance[child[0]]>(distance[(int)curr[0]]+child[1])) {
//                    distance[child[0]]=distance[(int)curr[0]]+child[1];
//                    p.add(new long[] {child[0],distance[child[0]]});
//                }
//            }
//        }
//    }
}
