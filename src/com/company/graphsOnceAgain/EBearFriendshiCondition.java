package com.company.graphsOnceAgain;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class EBearFriendshiCondition {
    static FastScanner fs=new FastScanner();
    static ArrayList<ArrayList<Integer>> adj;
    static int[] label=new int[150005];
    static int[] sizes=new int[150005];
    static int[] nOfEdges=new int[150005];

    public static void main(String[] args) {
        int n= fs.nextInt();int m=fs.nextInt();
        adj=new ArrayList<>(n);
        for (int i=0;i<n;i++) adj.add(new ArrayList());
        for (int i=0;i<n;i++){
            label[i]=i;
            sizes[i]=1;
        }
        for (int i=0;i<m;i++){
            int a= fs.nextInt();int b=fs.nextInt();
            a--;b--;
            merge(a,b);


        }
        boolean isPoss=true;
        for (int i=0;i<n;i++){
            if (nOfEdges[label[i]]!=(sizes[label[i]]*(sizes[label[i]])-1)/2) isPoss=false;
        }
        System.out.println(isPoss?"YES":"NO");

    }

    private static void merge(int a, int b) {
        adj.get(a).add(b);adj.get(b).add(a);
        int la=label[a];int lb=label[b];
        nOfEdges[la]++;
        if (la==lb) return;
        if (sizes[la]>sizes[lb]) {
            relabel(b,la);
            sizes[la]+=sizes[lb];
            nOfEdges[la]+=nOfEdges[lb];

        }
        else {
            relabel(a,lb);
            sizes[lb]+=sizes[la];
            nOfEdges[lb]+=nOfEdges[la];

       }



    }

    private static void relabel(int a, int target) {
        if (label[a]==target) return;
        label[a]=target;
        for (int f:adj.get(a)){
            relabel(f,target);
        }
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
