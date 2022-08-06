package com.company.dpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LBookingSystem {
    static class Pair implements Comparator<Pair> {
        int groupSize;
        int moneypaid;

        public Pair() {
        }

        public Pair(int groupSize, int moneypaid) {
            this.groupSize = groupSize;
            this.moneypaid = moneypaid;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.groupSize==o2.groupSize) return -(o1.moneypaid-o2.moneypaid);
           else return o1.groupSize-o2.groupSize;
        }

//        @Override
//        public int compareTo(Pair o) {
//            if (o.groupSize==this.groupSize) return o.moneypaid-this.moneypaid;
//            else return o.groupSize-this.groupSize;
//        }
    }

    static  FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        // Which request to accept and which to decline so that money earned is maximum
        int n= fs.nextInt();
        Pair[] pairs=new Pair[n];
        for (int i=0;i<n;i++){
            int size= fs.nextInt();
            int money= fs.nextInt();
            pairs[i]=new Pair(size,money);
        }
        int noOfTable = fs.nextInt();
        int[] tableSizes=new int[noOfTable];
        for (int i=0;i<noOfTable;i++) tableSizes[i]= fs.nextInt();
        Arrays.sort(pairs, new Pair());
        Arrays.sort(tableSizes);
        int[][] dpTable=new int[100][100];
        for (int i=0;i<dpTable.length;i++)
            for (int j=0;j<dpTable[0].length;j++)
                dpTable[i][j]=Integer.MIN_VALUE;
        dpTable[0][0]=0;


        /*








        D. Chip Move
time limit per test2 seconds
memory limit per test256 megabytes

There is a chip on the coordinate line. Initially, the chip is located at the point 0.
You can perform any number of moves; each move increases the coordinate of the chip by some
positive integer (which is called the length of the move). The length of the first move you make should be divisible by k,
 the length of the second move — by k+1, the third — by k+2, and so on.

For example, if k=2, then the sequence of moves may look like this: 0→4→7→19→44,
because 4−0=4 is divisible by 2=k, 7−4=3 is divisible by 3=k+1, 19−7=12 is divisible by 4=k+2, 44−19=25 is divisible by 5=k+3.

You are given two positive integers n and k. Your task is to count the number of ways to reach the point x,
 starting from 0, for every x∈[1,n]. The number of ways can be very large, so print it modulo 998244353.
 Two ways are considered different if they differ as sets of visited positions.

Input
The first (and only) line of the input contains two integers n and k (1≤k≤n≤2⋅105).

Output
Print n integers — the number of ways to reach the point x, starting from 0, for every x∈[1,n], taken modulo 998244353.

Examples
inputCopy
8 1
outputCopy
1 1 2 2 3 4 5 6
inputCopy
10 2
outputCopy
0 1 0 1 1 1 1 2 2 2
Note
Let's look at the first example:

Ways to reach the point 1: [0,1];

Ways to reach the point 2: [0,2];

Ways to reach the point 3: [0,1,3], [0,3];

Ways to reach the point 4: [0,2,4], [0,4];

Ways to reach the point 5: [0,1,5], [0,3,5], [0,5];

Ways to reach the point 6: [0,1,3,6], [0,2,6], [0,4,6], [0,6];

Ways to reach the point 7: [0,2,4,7], [0,1,7], [0,3,7], [0,5,7], [0,7];

Ways to reach the point 8: [0,3,5,8], [0,1,5,8], [0,2,8], [0,4,8], [0,6,8], [0,8].










         DP[i][j]---> the maximum amount i can have if i have taken i no of orders and last given chair was jth
          if  does not Allows
              dp[i+1][j]=Math.max(itself,dp[i][j]
          else
               k>j  dp[i+1][k]=Math.max(itself,dp[i][j]+cost
         */
        for (int i=0;i<n;i++) {
        for (int j = 0; j < noOfTable; j++) {


                for (int k = j; k < noOfTable; k++) {
                  //  System.out.println("called");

                    if (pairs[i].groupSize <= tableSizes[k]) {
                        dpTable[i+1][k]=Math.max(dpTable[i+1][k],dpTable[i][j]+pairs[i].moneypaid);
                        System.out.println(" True Possible  The Value of "+(i+1)+"  "+k+" " +dpTable[i+1][k]);

                    } else {
                        dpTable[i + 1][j] = Math.max(dpTable[i + 1][j], dpTable[i][j]);
                        System.out.println("The Value of "+(i+1)+"  "+j+" " +dpTable[i+1][j]);

                    }

                }
            }
        }










//
//        for (int i=0;i<n;i++){
//            for (int j=0;j<noOfTable;j++){
//                dpTable[i+1][j]=Math.max(dpTable[i+1][j],dpTable[i][j]);
//                System.out.println("The Value of "+(i+1)+"  "+j+" " +dpTable[i+1][j]);
//                for (int k=j+1;k<noOfTable;k++){
//
//                    if (i+1<n&&tableSizes[k]>=pairs[i].groupSize){
//                        dpTable[i+1][k]= Math.max(dpTable[i+1][k],dpTable[i][j] +pairs[i].moneypaid);
//                        System.out.println(" True Possible  The Value of "+(i+1)+"  "+k+" " +dpTable[i+1][k]);
//
//                    }
//
//                }
//
//            }
//        }
//        int ans=0;
//        for (int i=0;i<noOfTable;i++) ans+=dpTable[n-1][i];
//        System.out.println(ans);
      // System.out.println(dpTable[n-1][noOfTable-1]);
        int ans=0;
        for (int i=0;i<noOfTable;i++) ans=Math.max(ans,dpTable[n][i]);
        System.out.println(ans);






    }



    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
