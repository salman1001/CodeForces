package com.company.December.graphs;

import com.company.random.A;

import java.util.*;

public class FSubstring {
    static Scanner sc=new Scanner(System.in);
    static ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
    static int[] inDegree=new int[300005];
    static ArrayList<Integer> topSort=new ArrayList<>(300005);
    static int[] dp=new int[300005];
    public static void main(String[] args) {
        int n= sc.nextInt();
        int m= sc.nextInt();
        String str= sc.next();
        for (int i=0;i<n;i++) edges.add(new ArrayList<>());
        for (int i=0;i<m;i++){
            int x=sc.nextInt();int y= sc.nextInt();x--;y--;
            edges.get(x).add(y);
            inDegree[y]++;
        }
        Queue<Integer> queue=  new  LinkedList<Integer>();
        int count=0;
        for (int i=0;i<n;i++)  if (inDegree[i]==0) queue.add(i);
        while (!queue.isEmpty()){
            count++;
            int a=queue.poll();
            topSort.add(a);
            for (Integer way:edges.get(a)){
              inDegree[way]--;
                if (inDegree[way]==0) queue.add(way);
            }


        }
        if (count<n){
            System.out.println(-1);
            return;
        }
        int ans=0;
        for (char c='a';c<='z';c++){
            Arrays.fill(dp, 0);
            for (Integer x:topSort){
                if (str.charAt(x)==c) ++dp[x];
                for (Integer y:edges.get(x)){
                    dp[y]=Math.max(dp[y],dp[x]);
                }
                ans=Math.max(ans,dp[x]);

            }



        }
        System.out.println(ans);
    }

}