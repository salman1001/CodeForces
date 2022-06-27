package com.company.dpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ElongatedMatrix {
    static FastScanner fs=new FastScanner();
    static int[][] matrix;
    static int[][][] dp=new int[1 << 16][17][17];
    static int[][] costAdj=new int[17][17];
    static int[][] costTop=new int[17][17];
    public static void main(String[] args) {
        int n= fs.nextInt();int m= fs.nextInt();
        matrix=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                matrix[i][j]= fs.nextInt();
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                costAdj[i][j]=Integer.MAX_VALUE;
                for (int k=0;k<m;k++) costAdj[i][j]=Math.min(costAdj[i][j],Math.abs(matrix[i][k]-matrix[j][k]));
            }
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                costTop[i][j]=Integer.MAX_VALUE;
                for (int k=0;k<m-1;k++) costTop[i][j]=Math.min(costTop[i][j],Math.abs(matrix[i][k]-matrix[j][k+1]));
            }
        }
        for (int mask=0;mask<(1<<n)-1;mask++){
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    int nrows=countSetBits(mask);
                    if (nrows==1||i!=j){
                        if (mask & (1 << i)>0){

                        }

                    }

                }
            }

        }




    }
    public static int countSetBits(int n)
    {
        if (n == 0)
            return 0;
        else
            return 1 + countSetBits(n & (n - 1));
    }



    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static class FastScanner {
        public BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
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
