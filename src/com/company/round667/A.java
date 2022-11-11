package com.company.round667;

import java.util.Scanner;

public class A {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for(int i=0;i<tc;i++){
            int a= sc.nextInt();int b= sc.nextInt();
            int dist=Math.abs(a-b);
            System.out.println((dist+9)/10);
        }


    }
}
