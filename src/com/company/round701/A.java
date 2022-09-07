package com.company.round701;

import java.util.Scanner;
//2 4 8 16 32 64 128
//3 9 27 81
// 4 16 64 256

public class A {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        while (--tc>=0){
            int a= sc.nextInt();int b= sc.nextInt();
            int best=Integer.MAX_VALUE;
            for (int i=0;i<50;i++){
                best=Math.min(best,i+get(a,b+i));

            }
            System.out.println(best);




        }


    }

    private static int get(int a, int i) {
        if (i==1) return Integer.MAX_VALUE;
        int c=0;
        while (a!=0){
            a/=i;
            c++;
        }
    return c;
    }

}
