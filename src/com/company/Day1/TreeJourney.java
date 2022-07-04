package com.company.Day1;

import java.util.*;

public class TreeJourney {
     static ArrayList<ArrayList<Integer>> arrayList=new ArrayList<>();
    public static void main(String[] args) {
        Scanner fs=new Scanner(System.in);
        int n=fs.nextInt();
        for (int i=0;i<n;i++) arrayList.add(new ArrayList<>());
        for (int i=0;i<n-1;i++){
            int a=fs.nextInt();
            int b=fs.nextInt();
            a--;b--;
            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }

        double ans =dfs(0,-1);
        System.out.printf("%.14f\n",ans);


    }

    private static double dfs(int curr, int parent) {
        double toret=0d;
        int noOfChild=0;
        for (int a:arrayList.get(curr)){
            if (a!=parent){
                ++noOfChild;
                 toret+=dfs(a,curr);
            }
        }
        if (noOfChild==0) return 0;
        return 1+toret/noOfChild;


    }
}