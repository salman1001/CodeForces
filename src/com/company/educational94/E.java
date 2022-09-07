package com.company.educational94;
import java.util.Scanner;
public class E {
    static Scanner sc=new Scanner(System.in);
    static  long[] arrr;
    static int n;
    public static void main(String[] args) {
        n=sc.nextInt();
        arrr=new long[n];
        for (int i=0;i<n;i++) arrr[i]= sc.nextLong();
        long ans=0;
        int l=0;
        for (int i=0;i<n;i++){
            if (arrr[i]==0){
                if (l<i) ans+=recursive(l,i-1);
                l=i+1;
            }
        }
        if (l<n) ans+=recursive(l,n-1);
        System.out.println(ans);




    }
    static long recursive(int l,int r){
        long min=1000000005;
        for (int i=l;i<=r;i++) min=Math.min(min,arrr[i]);
        long ans=min;
        for (int i=l;i<=r;i++) arrr[i]-=min;
        int tl=l;
        for (int i=l;i<=r;i++){
            if (arrr[i]==0){
                if (tl<i) ans+=recursive(tl,i-1);
                tl=i+1;
            }
        }
        if (tl<=r) ans+=recursive(tl,r);
        return Math.min(ans,r-l+1);


    }
}
