package com.company.TressColinE;

import com.company.random.A;

import java.util.ArrayList;
import java.util.Scanner;

public class E {
    static Scanner sc=new Scanner(System.in);
    static int[] arr;
    static long tot=0;
    static long cost=0;
    static long[] sum;
    static long ans;
    static ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
    public static void main(String[] args) {
        int n= sc.nextInt();
        arr=new int[n];
        sum=new long[n];
        for (int i=0;i<n;i++) {
            edges.add(new ArrayList<>()); arr[i]= sc.nextInt();
        }
        for (int i=0;i<n-1;i++){
            int u= sc.nextInt();int v= sc.nextInt();u--;v--;
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        for (int i=0;i<n;i++) tot+=arr[i];
        dfs_cost_with_root(0,-1,0);
        dfs(0,-1);
        System.out.println(ans);






    }

    private static void dfs(int cur, int par) {
        ans=Math.max(ans,cost);
        for (int child:edges.get(cur)){
            if (child!=par){
                long sum_child=sum[child];
                long rem_up=tot-sum_child;
                cost+=rem_up-sum_child;
                dfs(child,cur);
                cost-=rem_up-sum_child;
            }
        }
    }

    private static void dfs_cost_with_root(int curr, int par, int depth) {
        cost+= (long) arr[curr] *depth;
        sum[curr]=arr[curr];
        for (int child:edges.get(curr)){
            if (child!=par){
                dfs_cost_with_root(child,curr,depth+1);
                sum[curr]+=sum[child];
            }
        }

    }
}
