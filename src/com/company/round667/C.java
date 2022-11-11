package com.company.round667;

import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    static class Pair {
        int max,d;

        public Pair(int max, int d) {
            this.max = max;
            this.d = d;
        }


    }

    public static void main(String[] args) {
        int tc = sc.nextInt();
        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int dist = y - x;
            Pair ans=new Pair(Integer.MAX_VALUE,Integer.MAX_VALUE);
            for (int i = 1; i <= dist; i++) {
                if(x%i==y%i){
                    int ss=getS(i,y, n);
                    int end=ss+(n-1)*i;
                    if (ss<=x&&x<=end){
                        if (ss<=y&&y<=end){
                           if (ans.max>end) ans=new Pair(end,i);

                        }
                    }
                }


            }
            int start=ans.max-(n-1)*ans.d;
            for (int i=0;i<n;i++) System.out.print((start+(i*ans.d))+" ");
            System.out.println();


        }
    }

    private static int getS(int d, int y, int n) {
        int start=y-(n-1)*d;
        while (start<1){
            start+=d;
        }
        return start;
    }
}

