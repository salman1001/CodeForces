package com.company.treesMashup;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class BJourney {


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
    static FastScanner fs=new FastScanner();
     static ArrayList<ArrayList<Integer>> listOfEdges =new ArrayList<>();

    public static void main(String[] args) {
        int n= fs.nextInt();

        for (int i=0;i<n;i++){
            listOfEdges.add(i,new ArrayList<>());
        }
        for (int i=0;i<n-1;i++){
            int a,b;
            a= fs.nextInt();
            b= fs.nextInt();
            a--;b--;
            listOfEdges.get(b).add(a);
            listOfEdges.get(a).add(b);
        }
        System.out.printf("%.14f\n",dfs(0,-1));



    }

    private static double dfs(int cur, int parent) {
        double val=0;
        double currChild=0;
        for (int i=0;i<listOfEdges.get(cur).size();i++){
            if (!listOfEdges.get(cur).get(i).equals(parent)){
                currChild++;
                val+=dfs( listOfEdges.get(cur).get(i),cur);

            }
        }
        if (currChild==0)
            return 0 ;
        return 1+val/currChild;
    }
}
