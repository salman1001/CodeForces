package com.company.round667;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E {
    static Scanner sc=new Scanner(System.in);
    static Pair[] compressed=new Pair[200005];
    static long[] bestprefix;
    static long[] bestsuff;
    static long[] pre;
    static long[] suff;
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for (int j=0;j<tc;j++){
            int n= sc.nextInt();long k=sc.nextLong();
            bestprefix=new long[n];//starting at i
            bestsuff=new long[n];                                      // 2 3 4 5 6 7 8 8 9
            long[] arr=new long[n];                                                   // ---
            long[] arry=new long[n];
//            for (int i=0;i<n;i++){
//                compressed[i]=new Pair();
//            }
            pre=new long[n];
            suff=new long[n];

            for (int i=0;i<n;i++) arr[i]= sc.nextLong();
            for (int i=0;i<n;i++) arry[i]= sc.nextLong();
            HashMap<Long,Integer> map=new HashMap<>();
            for (int i=0;i<n;i++){
                int t=map.getOrDefault(arr[i],0);
                map.put(arr[i],t+1);
            }
            int m=0;
            int rpoint=0;
            int count=0;
            for (Map.Entry<Long,Integer> map1:map.entrySet()) {
                compressed[m++]=new Pair(map1.getKey(),map1.getValue());
               // System.out.println(compressed[m-1].x+"  "+compressed[m-1].count);
            }
//
            for (int i=0;i<m;i++){
                while (rpoint<m&&k+compressed[i].x>=compressed[rpoint].x){
                   // System.out.println(compressed[rpoint].x+" ");
                    count+=compressed[rpoint].count;++rpoint;
                }
                bestprefix[i]=count;
                count-=compressed[i].count;
            }
            count=0;
            int lpoint=m-1;
            for (int i=m-1;i>=0;i--){
                while (lpoint>=0&&compressed[i].x-k<=compressed[lpoint].x){
                    count+=compressed[lpoint].count;--lpoint;
                }
                bestsuff[i]=count;
                count-=compressed[i].count;
            }

            long r=0;
            for (int i=0;i<n;i++){
                r=Math.max(r,bestprefix[i]);
                pre[i]=r;
            }
            r=0;
            for (int i=n-1;i>=0;i--){
                r=Math.max(r,bestprefix[i]);
                suff[i]=r;
            }
            long ans=Math.max(suff[0],pre[n-1] );
            for (int i=0;i<n-1;i++){
                ans=Math.max(ans,pre[i]+suff[i+1]);
            }
            System.out.println(ans);

        }








    }
    static class Pair{
        long x;
        int count;

        public Pair() {
        }

        public Pair(long x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}
