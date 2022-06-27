package com.company.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FSubstring {
    static FastScanner fs=new FastScanner();static ArrayList<ArrayList<Integer>> arrays=new ArrayList<>();


    public static void main(String[] args) {
        int m,n;
        n= fs.nextInt();m= fs.nextInt();
        String str= fs.next();
        int[] inDegree=new int[n+10];
        for (int i=0;i<n;i++){
            inDegree[i]=0;
        }
        for (int i=0;i<300005;i++){
            arrays.add(i,new ArrayList());
        }
        for (int i=0;i<m;i++){
            int a= fs.nextInt();int b= fs.nextInt();
            a--; b--;
            arrays.get(a).add(b);
            inDegree[b]++;
        }
        ArrayList<Integer> topSort=new ArrayList();
        Queue<Integer> myQueue=new LinkedList<>();
        int cnt=0;
        for (int i=0;i<n;i++){
            if (inDegree[i]==0) myQueue.add(i);
        }
       // System.out.println(myQueue.size());
        while (!myQueue.isEmpty()){
            cnt++;
           // System.out.println(cnt);
            int x=myQueue.peek();
            myQueue.remove();
            topSort.add(x);
            for (int i=0;i<arrays.get(x).size();i++){
              //  indegree[i]--;
               // System.out.println(indegree[arrays.get(x).get(i)]);
                inDegree[arrays.get(x).get(i)]--;

                if ( inDegree[arrays.get(x).get(i)]==0) myQueue.add( inDegree[arrays.get(x).get(i)]);
               // System.out.println(myQueue.size());
                System.out.println(inDegree[arrays.get(x).get(i)]);
            }
        }
        if (cnt<n){
            System.out.println(-1);
            return;
        }
        int ans=0;
        for (char c='a';c<='z';c++){
            int[] dp=new int[n];
            for (int i=0;i<n;i++) dp[i]=0;
            for (int i=0;i<topSort.size();i++){
                if (str.charAt(i)==c) dp[i]++;
                for (int j=0;j<arrays.get(i).size();j++){
                    dp[j]=Math.max(dp[j],dp[i]);
                }
                ans=Math.max(ans,dp[i]);
            }
        }
        System.out.println(ans);




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
