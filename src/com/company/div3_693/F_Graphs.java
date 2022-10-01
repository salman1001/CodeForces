package com.company.div3_693;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class F_Graphs {
    static long[] indeg=new long[300005];
    static ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    static ArrayList<Integer> topSort=new ArrayList();
    static long[] dp=new long[300005];




    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n= sc.nextInt();int m= sc.nextInt();String  s= sc.next();
        for (int i=0;i<n;i++) adj.add(new ArrayList<>());
        for (int i=0;i<m;i++){
            int a= sc.nextInt();int b= sc.nextInt();a--;b--;
            adj.get(a).add(b);
            indeg[b]++;
        }
        Queue<Long> queue=new LinkedList<>();
        int count=0;
        for (long i=0;i<n;i++){
            if (indeg[(int) i]==0){
                queue.add(i);
            }

        }
        while (!queue.isEmpty()){
            count++;
            long a=queue.peek();
            queue.remove();
            topSort.add((int)a);
            for (long d:adj.get((int) a)){
                indeg[(int) d]--;
                if (indeg[(int) d]==0) queue.add(d);
            }
        }
        if (count<n) {
            System.out.println(-1);
            return;
        }
        long ans=0;
        for (char c='a';c<='z';c++){
            for (int i=0;i<n;i++) dp[i]=0;
            for (int a:topSort){
                if (s.charAt(a)==c) dp[ a]=dp[a]+1;
                for (int f:adj.get(a)){
                    dp[f]=Math.max(dp[f],dp[a] );
                }
                ans=Math.max(ans,dp[ a]);
            }




            }
        System.out.println(ans);





    }
}
