package com.company.graphsOnceAgain;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CNewsDistribution {
    static ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s[] = in.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        for (int i=0;i<n;i++) adj.add(new ArrayList<>());
        for (int j=0;j<m;j++){
            s=in.readLine().split(" ");
            int size=Integer.parseInt(s[0]);
            for (int i=1;i<size;i++){
                int a=Integer.parseInt(s[i]); a--;
                int b=Integer.parseInt(s[i+1]);b--;
                adj.get(a).add(b);adj.get(b).add(a);
            }
        }
        boolean[] visited=new boolean[n];
        int[] sizes=new int[n];
        for (int i=0;i<n;i++){
            if (!visited[i]){
                ArrayList<Integer> components=new ArrayList<>();
                Queue<Integer> queue=new LinkedList<>();
                queue.add( i);
                while (!queue.isEmpty()){
                    int x=queue.peek(); queue.remove();
                    if (visited[x]) continue;
                    visited[x]=true;
                    components.add(x);
                    for (int y:adj.get(x)){
                        if (!visited[ y]){
                            queue.add(y);
                        }
                    }
                }
                for (int e=0;e<components.size();e++){
                    sizes[components.get(e)]=components.size();
                }

            }

        }
        for (int i=0;i<n;i++){
              System.out.print(sizes[i]+" ");
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
