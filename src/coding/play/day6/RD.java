package coding.play.day6;

import java.util.ArrayList;
import java.util.Scanner;

public class RD {
    static Scanner sc=new Scanner(System.in);
    static ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
    static long[] dp;
    static int[]  nChild;
    static long[] arr;
    public static void main(String[] args) {
        int n= sc.nextInt();
        for (int i=0;i<n;i++){
            edges.add(new ArrayList<>());
        }
        dp=new long[n];
        nChild=new int[n];
        sum=new long[n];
        //dp[i]--->max i could catch  for the subtree i


        for (int i=0;i<n-1;i++){
            int x=sc.nextInt();
            x--;
            edges.get(x).add(i+1);


        }

       arr =new long[n];
        for (int i=0;i<n;i++)  {
            arr[i]=sc.nextLong();
        }
        /*

        well its optimal for citizens to
         maintain evenness in the child
        so that when bandit comes up he
         will get  the least as possible

        so parent has some

        find the minimum innthe subtree and keep distributing and give out parent  and child max
         */

        //we are going to some sort of dp with dfs
        dfs(0,-1);
        System.out.println(dp[0]);






    }
    static long[] sum;

    private static void dfs(int cur, int par) {
        nChild[cur]=edges.get(cur).size()>0?0:1;
        sum[cur]=arr[cur];
        for (int child:edges.get(cur)){
            if (child!=par){
                dfs(child,cur);
                nChild[cur]+=nChild[child];
                sum[cur]+=sum[child];
                dp[cur]=Math.max(dp[cur],dp[child]);

            }
        }
        dp[cur]=Math.max(dp[cur],(sum[cur]+nChild[cur]-1)/nChild[cur]);





    }
}
