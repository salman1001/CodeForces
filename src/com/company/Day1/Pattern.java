package com.company.Day1;

import java.util.Scanner;

public class Pattern {
    static Pair[] dp=new Pair[20000+10];
    static class Pair{
        int less;
        int more;

        public Pair(int less, int more) {
            this.less = less;
            this.more = more;
        }
    }

    static Scanner sc=new Scanner(System.in);
    //dp[i]----pair(x,y)-----x is the count of number less than index i and y is the count of number that are greater than i
    public static void main(String[] args) {
        for (int i=0;i<20000+10;i++) dp[i]=new Pair(0,0);
        long[] arr={2,6,8,5,4,6,7,};

        for (int i=0;i<arr.length;i++){

        }

    }


}
