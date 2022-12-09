package com.company.div2_665;

import com.company.div3_744.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        BITree biTree=new BITree(1000009);
        long n= sc.nextLong();
        long m=sc.nextLong();
        XLines[] xLines=new XLines[(int) n];
        YLines[] yLines=new YLines[(int) n];
        ArrayList<ArrayList<Events>> events=new ArrayList<>();
        for (int i=0;i<1000009;i++) events.add(new ArrayList<>());


        for (int i=0;i<n;i++){
            System.out.println("22");
            long a= sc.nextLong();long b= sc.nextLong();long c= sc.nextLong();
            xLines[i]=new XLines(a,b,c);
        }
        long cons=1000000;
        long ans=1;
        for (int i=0;i<m;i++){
            System.out.println("22");

            long a= sc.nextLong();long b= sc.nextLong();long c= sc.nextLong();
            yLines[i]=new YLines(a,b,c);
            events.get((int) b).add(new Events(a,1));
            events.get((int) b).add(new Events(a,-1));
//            events.add((int) b,new Events(a,1));
//            events.add((int) b,new Events(a,-1));
            if (b==0&&c==cons) ans++;
        }
        biTree.add(0,1);
        biTree.add((int) cons,1);
        Arrays.sort(xLines);
        long pt=0;
        for (long i=0;i<n;i++){
            while (pt<=xLines[(int) i].height){
                for (Events e:events.get((int) pt)){
                    if (e.count==1) biTree.add((int) e.xPos,1);
                    else biTree.add((int) e.xPos,-1);
                }
                pt++;
            }
            ans+=biTree.sum(xLines[(int) i].start,xLines[(int) i].end)-1;
        }
        System.out.println(ans);








    }
    static public class Events{
        long xPos;
        long count;

        public Events(long xPos, long count) {
            this.xPos = xPos;
            this.count = count;
        }
    }
     static public class YLines  {
        long length;
        long start;
        long end;

        public YLines(long length, long start, long end) {
            this.length = length;
            this.start = start;
            this.end = end;
        }

    }
    static public class XLines implements Comparable<XLines>{
        long height;
        long start;
        long end;

        public XLines(long height, long start, long end) {
            this.height = height;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(XLines o) {
             return (int) (this.start-o.start);
        }
    }

    public static class BITree {

        private final int n;
        private long[] tree;

        public BITree(int n) {
            this.n = n;
            this.tree = new long[n + 1];
        }

        public BITree(long[] values) {
            values[0] = 0L;

            this.n = values.length;

            tree = values.clone();

            for (int i = 1; i < n; i++) {
                int parent = i + lsb(i);

                if (parent < n) {
                    tree[parent] += tree[i];
                }
            }
        }

        public long sum(long left, long right) {
            return prefixSum((int) right) - prefixSum((int) (left - 1));
        }

        public long get(int i) {
            return sum(i, i);
        }

        public void add(int i, long v) {
            while (i < n) {
                tree[i] += v;
                i += lsb(i);
            }
        }

        public void set(int i, long v) {
            add(i, v - sum(i, i));
        }


        private long prefixSum(int i) {
            long sum = 0L;

            while (i != 0) {
                sum += tree[i];
                i &= ~lsb(i); // or, i -= lsb(i);
            }
            return sum;
        }

        private static int lsb(int i) {
            return i & -i;
        }
    }

}

