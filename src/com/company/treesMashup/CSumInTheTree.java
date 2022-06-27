package com.company.treesMashup;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class CSumInTheTree {


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
     static ArrayList<Long> sumValue=new ArrayList<>();
    static ArrayList<ArrayList<Integer>> listOfChildren =new ArrayList<>();
   static  ArrayList value=new ArrayList<>();


    // static ArrayList<ArrayList<Integer>> listOfEdges =new ArrayList<>();

    public static void main(String[] args) {
        int n= fs.nextInt();


        for (int i=0;i<n;i++){
            listOfChildren.add(i,new ArrayList<>());
        }
        for (int i=0;i<n-1;i++){
            int a;
            a= fs.nextInt();
            a--;
//            b= fs.nextInt();
//            a--;b--;
//            listOfEdges.get(b).add(a);
//            listOfEdges.get(a).add(b);

           listOfChildren.get(a).add(i+1);
        }
        for (int i=0;i<n;i++){
            sumValue.add(i, fs.nextLong());
        }
      //  double ans=sumValue.get(0);
     //   s.add(0,sumValue.get(0));
        ans=0;
        dfs(0,-1);
        boolean isPossible=true;
        for (int i=0;i<n;i++){
            if (value.get(i).equals(-1)){
                isPossible=false;
                break;
            }
        }
        if (!isPossible) System.out.println(-1);
        else {
            System.out.println(ans);
        }








     }
     static long ans=0;
      static void  dfs(int cur,int par){
        long s_parent=0;
        if (par!=-1) s_parent= sumValue.get(par);
        if (sumValue.get(cur).equals(-1)){
            long min=200000000;
            for (int child =listOfChildren.get(cur).size();child>0;child--){
                min=Math.min(min, sumValue.get(child));
            }
            if (listOfChildren.get(cur).size()==0) min=s_parent;
            //sumValue.set(cur, min);
         //   sumValue.add(cur,min);
           // sumValue[cur]=min;
          //  System.out.println(cur+"  "+min);
            sumValue.set(cur,min);

        }
        for (int child =listOfChildren.get(cur).size()-1;child>=0;child--){
            dfs(listOfChildren.get(cur).get(child),cur);
        }
          System.out.println(cur+"  "+ (sumValue.get(cur)- s_parent));
        value.add(cur,sumValue.get(cur)- s_parent);
        ans+=(long)value.get(cur);


     }

}
