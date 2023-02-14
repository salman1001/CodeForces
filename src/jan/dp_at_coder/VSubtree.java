package jan.dp_at_coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class VSubtree {
  static   int n;
  static   long M;
   static ArrayList<ArrayList<Integer>> edges;
    public static void main(String[] args) {
        FastScanner fastScanner=new FastScanner();

         n= fastScanner.nextInt();
        M= fastScanner.nextLong();
         edges=new ArrayList<>();
        for (int i=0;i<n;i++) edges.add(i,new ArrayList<>());
        for (int i=0;i<n-1;i++){
            int a= fastScanner.nextInt();a--;
            int b= fastScanner.nextInt();b--;
            edges.get(a).add(b);
            edges.get(b).add(a);
        }
        /*

        What we need to do::::

        for a node we need the value for its
        children...how many ways can we either
        paint its children either it's all black
        or none is black.

        we also need to the same for its parent
        and combine its solution the parents either
        has to black or none has to be black






         */



    }
     static long[] simple =new long[n+5];
  static   long[] actualSol=new long[n+5];
  static   long [] dp=new long[n+5];

    void dfs1(int cur,int par){
        simple[cur]=1;
        for (Integer child:edges.get(cur)){
            if (child!=par){
                dfs1(child,cur);
                simple[cur]*=(1+simple[child]);
                simple[cur]=simple[cur]%M;
            }
        }

    }


    void dfs2(int cur,int parent,long pref,long suff){
        if (cur==0){
            dp[0]=1;
            actualSol[0]=simple[0];
        }
        else {
            long val=(pref*suff%M)*dp[parent];
            dp[cur]=1+val;
            dp[cur]%=M;
            actualSol[cur]=(dp[cur]*simple[cur])%M;
            actualSol[cur]=actualSol[cur]%M;

        }
        if (edges.get(cur).size()==1) return;
       // long[]  values=new long[];
        long[] pre=new long[edges.get(cur).size()+1];
        long[] suf=new long[edges.get(cur).size()+1];
        int j=0;
        for (Integer i:edges.get(cur)){
            if (i!=parent){
        //        values[j]=1+simple[i];
        //        values[j]%=M;
                j++;
            }
        }
        pre[0]=1;
        for (int i=0;i<edges.get(cur).size();i++){
      //      pre[i+1]=(pre[i]*values[i])%M;
        }
        suf[edges.get(cur).size()]=1;
//        for (int i=edges.get(cur).size();i>=0i--){
//            suf[i+1]=(pre[i]*values[i])%M;
//        }








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
        long[] readLongArray(int n) {
            long[] a=new long[n];
            for (int i=0; i<n; i++) a[i]=nextLong();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }

}
