package com.company.random;
public class C {
    public static void main(String[] args) {
        int a=6;
        int b=20;
        //dp[i]---probability of getting to i
        double[] dp=new double[a+10];
        double[] ev=new double[a+10];
        dp[a]=1;
        for (int i=a;i>0;i--){
            double p_waste=(double) (a-i)/a;
            double ev_waste=p_waste/(1-p_waste)+1;
            ev[i]+=ev_waste*dp[i];


            dp[i-1]+=(dp[i]*0.5);
            ev[i-1]+=ev[i]*0.5;
            if (i<b) {
                dp[i+1]+=(dp[i]*0.5);
                ev[i+1]+=(ev[i]*0.5);
            }
        }
        //System.out.println(dp[1]);
        System.out.println(ev[1]);



    }



}
