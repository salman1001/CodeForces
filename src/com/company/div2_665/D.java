package com.company.div2_665;

import java.util.*;

public class D {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
    static int n;
    static long mod=1000000007;
    static int[] nPath;
    public static void main(String[] args) {
        int t= sc.nextInt();
        for (int tc=0;tc<t;tc++){
            n= sc.nextInt();
            edges.clear();
            nPath=new int[100005];
            for (int i=0;i<n;i++) edges.add(new ArrayList<>());
            for (int i=0;i<n-1;i++){
                int u=sc.nextInt();int v= sc.nextInt();
                u--;v--;
                edges.get(u).add(v);
                edges.get(v).add(u);
            }
            int m= sc.nextInt();
            long[] arr=new long[n];
            for (int i=0;i<m;i++) arr[i]= sc.nextLong();
           // Collections.reverse(Collections.singletonList(arr));

            dfs(0,-1);
            n--;
            for (int i=m;i<=n;i++) arr[i]=1;
            Arrays.sort(arr);

           // Collections.reverse(Arrays.asList(arr));




            Arrays.sort(nPath);
            //Collections.reverse(Arrays.asList(nPath));

            for (int i:nPath) System.out.println(i);
            System.out.println();


            for (int i=0;i<n-1;i++) nPath[i]%=mod;
            long ans=0;
            if (m<=n){
                for (int i=0;i<n;i++){
                    System.out.println("cal");
                    ans=(ans+nPath[i]*arr[i])%mod;
                }

            }
            else {
              //  System.out.println("m>n");

                int rem=m-n;
                long initial=1;
                for (int i=0;i<rem+1;i++){
                    initial=(initial*arr[i])%mod;
                }
                ans=(ans+initial*nPath[0])%mod;
                for (int i=1;i<n;i++){
                    ans=(ans+arr[i+rem]*nPath[i])%mod;
                }

            }
           System.out.println(ans);

        }



    }

    private static int dfs(int cur, int par) {
        int below=1;
        for (int child:edges.get(cur)){
            if (child!=par){

                below+=dfs(child,cur);

            }
        }
        int above=n-below;
        int total=above*below;
       if (cur>0) nPath[cur-1]=total;
       return below;

    }
}
