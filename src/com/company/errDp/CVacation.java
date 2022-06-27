package com.company.errDp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CVacation {
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {

        int n= fs.nextInt();
        int [] dp=new int[3];

        for (int i=0;i<n;i++){
            int [] new_dp=new int[3];
            int [] ci=new int[3];
            for (int k=0;k<3;k++){
                ci[k]= fs.nextInt();
            }
            for (int h=0;h<3;h++){
                for (int j=0;j<3;j++){
                    System.out.println("The value of h is "+h+"    and the value of j is  "+j);
                    if (h!=j){
                        // System.out.println(i+"  "+j);
                        System.out.println( "Prev  "+new_dp[j]);
                        new_dp[j]=Math.max(new_dp[j], dp[h]+ci[h]);
                        System.out.println( "After  "+new_dp[j]);

                    }
                }
            }
            dp=new_dp;


//            for (int j=0;j<3;j++){
//                arr[i][j]= fs.nextInt();
//            }
        }
//        new_dp[0]=0;
//        new_dp[1]=0;
//        new_dp[2]=0;


      //  dp=new_dp;
        int max=Math.max(dp[0],Math.max(dp[1],dp[2]));
        System.out.println(max);



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
