package com.company.csesGeometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A {
  //  static Scanner sc=new Scanner(System.in);
 static FastScanner sc=new FastScanner();
 static PrintWriter printWriter=new PrintWriter(System.out);

    public static void main(String[] args) {
        int tc= sc.nextInt();
        for (int i=0;i<tc;i++){
            long x1,y1,x2,y2,x3,y3;
            x1= sc.nextLong();y1= sc.nextLong();
            x2= sc.nextLong();y2= sc.nextLong();
            x3= sc.nextLong();y3= sc.nextLong();
            x2-=x1;y2-=y1;x3-=x1;y3-=y1;
            long val=x2*y3-y2*x3;
            if (val<0) printWriter.println("RIGHT");
            else if ( val>0) printWriter.println("LEFT");
            else printWriter.println("TOUCH");

        }
        printWriter.close();


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
