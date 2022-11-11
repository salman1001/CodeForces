package com.company.round725;

import java.util.Scanner;

public class F {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for (int tt=0;tt<tc;tt++){
            int l=sc.nextInt();int r= sc.nextInt();
            int ans=r-l;
            while (l<r){
                l/=10;r/=10;
                ans+=r-l;
            }
            System.out.println(ans);
        }

    }
}
