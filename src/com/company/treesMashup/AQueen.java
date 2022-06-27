package com.company.treesMashup;

import com.company.codeforces.contest782.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AQueen {
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
    public static void main(String[] args) {
        int n= fs.nextInt();
        ArrayList<ArrayList<Integer>> children=new ArrayList<>();
        ArrayList arr=new ArrayList();
        for (int i=0;i<n+10;i++)
            children.add(i,new ArrayList<>());
        for (int i=0;i<n;i++){
            int val1=fs.nextInt();
            int val2= fs.nextInt();
            if (val1!=-1){
                val1--;
                children.get(val1).add(i);
            }


            arr.add(i,val2);
        }


        ArrayList<Boolean> ans=new ArrayList();
        for (int i=0;i<n;i++)
            ans.add(i,false);

        for (int i=0;i<n;i++){
            if (arr.get(i).equals(1)){
                boolean possible=true;
                for (int child=0;child<children.get(i).size();child++){
                    if (arr.get(child).equals(0)){
                        possible=false;
                        break;
                    }
                    if (possible){
                        ans.add(i+1, true);
                }

                }
            }
        }
        if (ans.size()>0){
            for (int i=0;i<ans.size();i++){
                if (ans.get(i)==true){
                    System.out.print(i+ " ");
                }

            }
            System.out.println();
        }
        else {
            System.out.println("-1");
        }
    }
}