package com.company.div3_674;

import java.util.Scanner;

public class E {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        long n=sc.nextLong();
        long[] a=new  long [3];
        long[] b=new  long [3];
        for (int i=0;i<3;i++) a[i]= sc.nextLong();
        for (int i=0;i<3;i++) b[i]= sc.nextLong();
        long min=Math.max(0L,((a[0]+b[1])-n))+Math.max(0L,((a[1]+b[2])-n))+Math.max(0L,((a[2]+b[0])-n));
        long max=Math.min(a[0],b[1])+Math.min(a[1],b[2])+Math.min(a[2],b[0]);
        System.out.println(min+" "+max);



    }
}
