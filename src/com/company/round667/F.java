package com.company.round667;

import java.util.Scanner;

public class F {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        //dp[i][j][k]--->the maximum value i can get if i am at position i j and have used k operations so far
        //will take and go down or move right
        //will not take and go down or move right
        //ans---->Max(dp[r][c][1....k])

        int n=sc.nextInt();int m= sc.nextInt();int k= sc.nextInt();
        long[][] mat=new long[n][m];
        long[][][]  dp=new long[3005][3005][4];
        for (int i=0;i<k;i++){
            int r= sc.nextInt();int c= sc.nextInt();long x= sc.nextLong();r--;c--;
            mat[r][c]=x;

        }



        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                for (k=0;k<4;k++){
                    dp[i][j][k]=Long.MIN_VALUE;
                }
            }
        }
        dp[0][0][0]=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                // if its greater than 0 we will take it
                for( k=2;k>=0;k--){
                    dp[i][j][k+1]=Math.max(dp[i][j][k+1],dp[i][j][k]+mat[i][j]);
                }
                for (k=0;k<4;k++){
                    dp[i+1][j][0]=Math.max(dp[i+1][j][0],dp[i][j][k]);
                    dp[i][j+1][k]=Math.max(dp[i][j+1][k],dp[i][j][k]);
                }
            }
        }
        long ans=0;
        for (int i=0;i<4;i++) ans=Math.max(ans,dp[n-1][m-1][i]);
        System.out.println(ans);





    }
}
