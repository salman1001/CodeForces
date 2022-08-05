package com.company.dpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class JHelgaHufflepuffCup {
    static FastScanner fs=new FastScanner();
     static ArrayList<Long>[] edges =new ArrayList[100005];
    static int x;
    static int k;
    static long m;
    static int n;


    static long mod= (long) 1e9+7;
    static long[][][] dp=new long[100005][12][4];
    public static void main(String[] args) {
        n= fs.nextInt();
        m= fs.nextLong();
        for (int i=0;i<n;i++) edges[i]=new ArrayList<>();
        for (int i=0;i<n-1;i++){
            int u= fs.nextInt();int v= fs.nextInt();
            v--;u--;
            edges[u].add((long) v);
            edges[v].add((long) u);


        }
        k= fs.nextInt();x= fs.nextInt();

        dfs(0,-1);
        long ans=0;
        for (int i=0;i<=x;i++){
            for (int j=0;j<3;j++){
                ans=(ans+dp[0][i][j])%mod;
            }
        }
        System.out.println(ans);


    }
     static void dfs(long v ,long p){
         System.out.println("Called for "+v+" "+"with parent "+p);
        long[][] sub_dp =new long[edges[(int)v].size()+1][x+1];
        for (long y:edges[(int) v]){
            if (y!=p){
                dfs(y,v);
            }
        }


        {
            System.out.println("Calling for 0  for vertex "+v);

            for (int i=0;i<sub_dp.length;i++){
                for (int j=0;j<sub_dp[0].length;j++){
                    sub_dp[i][j]=0;
                }
            }
            sub_dp[0][0]=1;
            int count=0;
            for (long y:edges[(int) v] ){
                if (y!=p){
                    for (long cur_taken=0;cur_taken<=x;cur_taken++){
                        for (long take =0;take<=x-cur_taken;take++){
                            long tot=cur_taken+take;
                            long val=dp[(int) y][(int) take][0]
                                    +dp[(int) y][(int) take][1]
                                    +dp[(int) y][(int) take][2];
                            System.out.println("Updating the sub_dp "+(count+1)+"  "+tot);
                            sub_dp[count+1][(int) tot]=(sub_dp[count+1][(int) tot]
                                    +val*sub_dp[count][(int) cur_taken])%mod;

                        }
                    }
                    count++;

                }
            }
            for (int i=0;i<=x;i++) {
                System.out.println("Updating the dp "+(v)+"  "+i+" "+" At 0");

                dp[(int)v][i][0]=(sub_dp[count][i]*(k-1))%mod;
            }

        }
        {
            System.out.println("Calling for 1 ");

            for (int i=0;i<sub_dp.length;i++){
                for (int j=0;j<sub_dp[0].length;j++){
                    sub_dp[i][j]=0;
                }
            }
            sub_dp[0][0]=1;
            int count=0;
            for (long y:edges[(int) v] ){
                if (y!=p){
                    for (long cur_taken=0;cur_taken<=x;cur_taken++){
                        for (long take =0;take<=x-cur_taken;take++){
                            long tot=cur_taken+take;
                            long val=dp[(int) y][(int) take][0];
                            System.out.println("Updating the sub_dp "+(count+1)+"  "+tot);

                            sub_dp[count+1][(int) tot]=(sub_dp[count+1][(int) tot]
                                    +val*sub_dp[count][(int) cur_taken])%mod;

                        }
                    }
                    count++;

                }
            }
            for (int i=0;i<=x;i++){
                System.out.println("Updating the dp "+(v)+"  "+i+" "+" At 1");

                dp[(int) v][i+1][1]=(sub_dp[count][i])%mod;
            }

        }



        {
            System.out.println("Calling for 2 ");

            for (int i=0;i<sub_dp.length;i++){
                for (int j=0;j<sub_dp[0].length;j++){
                    sub_dp[i][j]=0;
                }
            }
            sub_dp[0][0]=1;
            int count=0;
            for (long y:edges[(int) v] ){
                if (y!=p){
                    for (long cur_taken=0;cur_taken<=x;cur_taken++){
                        for (long take =0;take<=x-cur_taken;take++){
                            long tot=cur_taken+take;
                            long val=dp[(int) y][(int) take][0]
                                    +dp[(int) y][(int) take][2];
                            System.out.println("Updating the sub_dp "+(count+1)+"  "+tot);

                            sub_dp[count+1][(int) tot]=(sub_dp[count+1][(int) tot]
                                    +val*sub_dp[count][(int) cur_taken])%mod;

                        }
                    }
                    count++;
                }
            }
            for (int i=0;i<=x;i++){
                System.out.println("Updating the dp "+(v)+"  "+i+" "+" At 2");

                dp[(int) v][i][2]=(sub_dp[count][i]*(m-k))%mod;
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
