package com.company.errDp;

import java.util.Scanner;

public class SDigitSum {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        String str=sc.next();
        int d=sc.nextInt();
        int len=str.length();
        long[][] dp=new long[d][2];
        dp[0][0]=1;
        for (int pointer =0;pointer<len;pointer++){
            long[][] new_dp=new long[d][2];
            for (int sumtill=0;sumtill<d;sumtill++){
                for (int i=0;i<2;i++){
                    for (int dig=0;dig<10;dig++){
                        if (dig>(str.charAt(pointer)-'0')&&i==0){
                            break;
                        }
                        new_dp[(sumtill+(str.charAt(pointer)-'0'))%d][(i==1||dig<(str.charAt(pointer)-'0'))?1:0]=
                                new_dp[(sumtill+(str.charAt(pointer)-'0'))%d][(i==1||dig<(str.charAt(pointer)-'0'))?1:0]+dp[sumtill][i];



                    }

                }
            }
            dp=new_dp;


        }
        long ans=dp[0][1]+dp[0][0];
        System.out.println(ans);


    }
}
