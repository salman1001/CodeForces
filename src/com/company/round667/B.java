package com.company.round667;

import java.util.Scanner;

public class B {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for (int j=0;j<tc;j++){
            long a= sc.nextLong();long b= sc.nextLong();long x= sc.nextLong();long y= sc.nextLong();long n= sc.nextLong();
            Long max=1000000000000000000L;
            for (long i=0;i<2;i++){
                long disa=a-x;long ditb=b-y;

                long deca=Math.min(disa,n);
                long decb=Math.min(ditb,n-deca);
                max=Math.min(max,((a-deca)*(b-decb)));
                long temp=a;
                a=b;
                b=temp;
                temp=x;
                x=y;
                y=temp;


            }
            System.out.println(max);
        }



    }
}
