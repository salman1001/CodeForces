package com.company.errDp;


import java.util.LinkedList;
import java.util.Scanner;

public class Z {
    static Scanner sc=new Scanner(System.in);
    static long[] a;
    public static void main(String[] args) {
        int n = sc.nextInt();
        long c= sc.nextLong();

        a = new long[n];
        for(int i = 0; i < n; i++) a[i] = sc.nextInt();
//
//        long[] b = new long[n];
//        for(int i = 0; i < n; i++) b[i] = sc.nextInt();

        ConvexHullTrick lines = new ConvexHullTrick();


        long[] dp = new long[n];
        lines.insert(new Line(-2*a[0],a[0]*a[0]));
        for(int i = 1; i < n; i++) {
            dp[i] = lines.query(a[i])+a[i]*a[i]+c;
            lines.insert(new Line(-2*a[i],dp[i]+a[i]*a[i]));
        }
        System.out.println((dp[n-1]));
    }
    static class ConvexHullTrick {
        LinkedList<Pair<Line, Long>> dq = new LinkedList<>();

        void insert(Line line) {
            if (dq.isEmpty()) {
                dq.add(new Pair<Line,Long>(line, 0l));
                return;
            }
            while (!dq.isEmpty()) {
                long x = line.xIntersect(dq.peekLast().getKey());
                if (x <= dq.peekLast().getValue()) {
                    dq.pollLast();
                } else {
                    Pair<Line, Long> newPair = new Pair<Line, Long>(line, x);
                    dq.addLast(newPair);
                    break;
                }
            }
        }

        long query(long x) {
            while (dq.size() > 1) {
                if (dq.get(1).getValue() <= x) {
                    dq.removeFirst();
                } else {
                    break;
                }
            }
            return dq.peekFirst().getKey().valAtX(x);
        }
    }

    static class Line {
        long slope;
        long yIntercept;

        Line(long m, long c) {
            this.slope = m;
            this.yIntercept = c;
        }

        long valAtX(long x) {
            return slope * x + yIntercept;
        }

        long xIntersect(Line line) {
            return (long) Math.ceil(1.0 * (line.yIntercept - this.yIntercept) / (this.slope - line.slope));
        }
    }

    static class Pair<K,V>{
        K key;
        V value;
        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
        K getKey(){
            return key;
        }
        V getValue(){
            return value;
        }
    }
}
