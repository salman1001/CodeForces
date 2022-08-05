package com.company.CodeforcesEducationalRound93;

import java.util.*;

public class B {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int people= sc.nextInt();
        int keys= sc.nextInt();
        long officeLocation= sc.nextInt();
        long[] peopleArray=new long[people];
        long[] keysArray=new long[keys];
        for (int i=0;i<people;i++){
            peopleArray[i]= sc.nextLong();
        }
        Arrays.sort(peopleArray);
        for (int i=0;i<keys;i++){
            keysArray[i]= sc.nextLong();
        }
        Arrays.sort(keysArray);
        long[][] dp=new long[keys+1][people+1];
        long inf= (long) 1e17;

        for (int i=0;i<=keys;i++){
            for (int j=0;j<=people;j++){
                dp[i][j]=inf;

            }
        }
        dp[0][0]=0;
        for (int i=0;i<keys;i++) {
            for (int j = 0; j <= people; j++) {
              dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]);
                 if (j<people ) dp[i+1][j+1]=Math.min(dp[i+1][j+1],
                         Math.max(dp[i][j],
                                 Math.abs(peopleArray[j]-keysArray[i])+Math.abs(keysArray[i]-officeLocation)));
            }
        }
//        long ans=inf;
//        for (int i=0;i<keys;i++) ans=Math.min(ans,dp[i][people-1]);
//        System.out.println(ans);
        System.out.println(dp[keys][people]);



    }
}
