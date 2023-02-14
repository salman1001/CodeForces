package coding.play.day2.round744;

import java.util.Arrays;
import java.util.Scanner;

public class G {
    static Scanner sc=new Scanner(System.in);
    static int[][] dp=new int[2][2050];
    public static void main(String[] args) {
        int tc= sc.nextInt();
       for (int i=0;i<2;i++){
           for (int k=0;k<2050;k++){
               dp[i][k]=1;
           }
       }
        for (int i=0;i<tc;i++){
            dp[0][0]=0;
            int n= sc.nextInt();
            for (int j=0;j<n;j++){
                int move= sc.nextInt();
                int thisTime=j%2;
                for (int k=0;k< dp[0].length;k++) dp[thisTime^1][k]=1;


                for (int k=0;k<2049;k++){
                    int newVal=dp[thisTime][k]+Math.max(0,move-k);
                    System.out.println(dp[thisTime][k]);
                    int newState=Math.max(0,k-move);
                    if (newVal<2049&&newState<2049){
                       // System.out.println("Left "+newVal+" ");
                        dp[thisTime^1][newState]=Math.min(dp[thisTime^1][newState],newVal);
                    }


                    int newVal1=dp[thisTime][k]+Math.max(0,move+k);
                    int newState1=Math.max(0,k+move);
                    if (newVal1<2049&&newState1<2049){
                      //  System.out.println("Right "+newVal1+"  ");

                        dp[thisTime^1][newState1]=Math.min(dp[thisTime^1][newState1],newVal1);
                    }

                }




            }
            long ans= (long) 10e9;
            for (int l=0;l<2049;l++) ans=Math.min(ans,dp[(n%2)][l]);
           // System.out.println(ans);
        }

    }
}
