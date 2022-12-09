package com.company.TressColinE;

import java.util.ArrayList;
import java.util.Scanner;

public class B {
    static Scanner sc=new Scanner(System.in);
    static ArrayList<ArrayList<Integer>> edges=new ArrayList<>();

    public static void main(String[] args) {
        int n= sc.nextInt();
        for (int i=0;i<n;i++) edges.add(new ArrayList<>());
        for (int i=0;i<n-1;i++){
            int u= sc.nextInt();int v= sc.nextInt();u--;v--;
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        double ans=dfs(0,-1);
        System.out.printf("%.14f\n",ans);



    }

    private static double dfs(int cur, int par) {
        int nChild=0;
        double tot=0;
        for (int child: edges.get(cur)){
            if (child!=par){
                nChild++;
                tot+=dfs(child,cur);
            }
        }



        if (nChild==0) return 0;
        return 1+ (double)tot/nChild;
    }

}
