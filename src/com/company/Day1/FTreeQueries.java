package com.company.Day1;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class FTreeQueries {
    static Scanner scanner=new Scanner(System.in);
    static ArrayList<ArrayList<Integer>> arrayList=new ArrayList<>();
    static int[] starting,ending,dep,parents;
    static int entryTime=-1;

    public static void main(String[] args) {
        int n=scanner.nextInt();int m=scanner.nextInt();
        starting=new int[n];ending=new int[n];dep=new int[n];parents=new int[n];
        for (int i=0;i<n;i++) arrayList.add(new ArrayList<>());
        PrintWriter pw=new PrintWriter(System.out);

        for (int i=0;i<n-1;i++){
            int u= scanner.nextInt();
            int v=scanner.nextInt();
            u--;v--;
            arrayList.get(u).add(v);
            arrayList.get(v).add(u);
        }
        dfs(0,-1,0);

        for (int i=0;i<m;i++){
            int k=scanner.nextInt();
            int[] arr=new int[k];
            for (int j=0;j<k;j++){
                int ver=scanner.nextInt();ver--;
                arr[j]=ver;
            }
            int lowest =arr[0];
            for (int j=0;j<k;j++){
                if (dep[lowest]<dep[arr[j]]){
                    lowest=arr[j];
                }
            }
            boolean canHave=true;
            for (int j=0;j<k;j++){
                int cur=arr[j];
                if (cur!=0) cur=parents[cur];
                if (!(starting[cur]<=starting[lowest]&&ending[lowest]<=ending[cur])) canHave=false;


            }
            pw.println(canHave?"YES":"NO");

        }
        pw.close();

    }

    private static void dfs(int curr, int par,int  depth) {
        parents[curr]=par;
        dep[curr]=depth;
        starting[curr]=++entryTime;
        for (int i=0;i<arrayList.get(curr).size();i++){
            if (arrayList.get(curr).get(i)!=par){
                dfs(arrayList.get(curr).get(i),curr,depth+1);
            }
        }
        ending[curr]=entryTime;


    }
}
