package com.company.round725;

import java.util.Scanner;

public class A {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for (int t=0;t<tc;t++){
            int n= sc.nextInt();
            int[] arr=new int[n];
            int x=0,y=0;
            for (int j=0;j<n;j++){
                arr[j]= sc.nextInt();
                if (arr[j]==1) x=j;
                else if (arr[j]==n) y=j;
            }
            if (x>y){
                int temp=y;
                y=x;
                x=temp;
            }
            int ans=Math.min(y+1,n-x);
            ans=Math.min(ans,(x+1)+n-y);
            System.out.println(ans);

        }

    }
}
