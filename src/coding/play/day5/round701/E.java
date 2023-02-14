package coding.play.day5.round701;

import java.util.ArrayList;
import java.util.Scanner;

public class E {

    static ArrayList<ArrayList<Integer>> child;
    static ArrayList<ArrayList<Integer>> nodesAt;
    static ArrayList<ArrayList<Integer>> edges;
    static int[] d;
    static int maxD;
    static Scanner sc =new Scanner(System.in);
    static long[] dp;

    public static void main(String[] args) {
        /*
        in a single dfs know about
        the no of node in each layer
        and maximum no layers in it
        and what is minimum and
        maximum value of endpoints
        we also need all the node at the single level
        */
        int tc= sc.nextInt();
        for (int i=0;i<tc;i++){
            int n= sc.nextInt();
            dp=new long[n+10];
//            child.clear();
//            nodesAt.clear();
//            edges.clear();

            child=new ArrayList<>();
            nodesAt=new ArrayList<>();
            edges=new ArrayList<>();
            for (int j=0;j<n+10;j++){
               child.add(new ArrayList<>());
               nodesAt.add(new ArrayList<>());
               edges.add(new ArrayList<>());
            }
            maxD=  0;d=new int[n+10];
            for (int k=0;k<n+10;k++) d[k]=0;
            for (int j=0;j<n-1;j++){
                int x= sc.nextInt();
                x--;
//                child.get(i).add(x);
                edges.get(i+1).add(x);
                edges.get(x).add(i+1);
            }
            long arr[]=new long[n];
            arr[0]=0;
            for (int j=1;j<n;j++){
                arr[j]= sc.nextLong();
            }
            dfs(0,-1,0);
            maxD++;
            for (int m=0;m<n+10;m++) dp[m]=0;

            for (int j=0;j<maxD;j++){
                long min= (long) 2e9;
                long max=-1;
                for (int k:nodesAt.get(j+1)){
                    min=Math.min(min,arr[k]);
                    max=Math.max(max,arr[k]);

                }
                for (int k:nodesAt.get(j) ){
                    for (int l:child.get(k)){
                        long best=Math.max(arr[l]-min,max-arr[l]);
                        dp[l]=Math.max(dp[l],dp[k]+best);
                    }

                }
                min= (long) 2e9;
                max= (long) -1e17;
                for (int k:nodesAt.get(j)){
                    long minV= (long) 2e9;
                    long maxV=(long) -2e9;
                    for (int l:child.get(k)){
                        minV=Math.min(minV,arr[l]);
                        maxV=Math.max(maxV,arr[l]);
                    }
                    max=Math.max(max,dp[k]+maxV);
                    min=Math.min(min,minV-dp[k]);

                }
                for (int k:nodesAt.get(j+1)){
                    dp[k]=Math.max(dp[k],Math.max(max-arr[k],arr[k]-min));
                }


            }
            long ans=0;
            for (int k:nodesAt.get(maxD-1)){
                ans=Math.max(ans,dp[k]);
            }
            System.out.println(ans);







        }



    }

    private static void dfs(int cur,int par, int depth) {
        d[cur]=depth;
        maxD=Math.max(maxD,depth);
        nodesAt.get(depth).add(cur);
        for (int x:edges.get(cur)){
            if(x!=par){
                dfs(x,cur,depth+1);
                child.get(cur).add(x);
            }
        }

    }
}
