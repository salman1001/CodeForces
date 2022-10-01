package com.company.codeforces103;

import java.util.Scanner;

public class Shubham {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n= sc.nextInt();
        int[] arr=new int[n+1];
        for (int i=1;i<n+1;i++){
            arr[i]= sc.nextInt();
        }
        int x= sc.nextInt();
        int ans=0;
        for (int i=1;i<n+1;i++){
            int m=x/(i);
            int j=m;
            while (j>=1&&j<=n){
                if (j>i&&arr[i]==arr[j]) ans++;
                j+=m;
            }
        }
        System.out.println(ans);
    }
}




