package com.company.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CNewsDistribution {
    static FastScanner fs=new FastScanner();
    static boolean[] visited;

    static ArrayList<ArrayList<Integer>> arrays=new ArrayList<>();
     static ArrayList ans =new ArrayList();


    public static void main(String[] args) {
        int n= fs.nextInt();
        int m= fs.nextInt();
        visited=new boolean[n];

        for (int i=0;i<m;i++){
            long k= fs.nextLong();
            for (int l=0;l<n;l++){
                arrays.add(l,new ArrayList());
            }
            ArrayList<Integer> list=new ArrayList();
            for (int o=0;o<n;o++) ans.add(o,0);

            for (int j=0;j<k;j++){
                int val= fs.nextInt();
                val--;
                list.add(val);

            }
            for (int j=0;j+1<k;j++){
                arrays.get(list.get(j)).add(list.get(j+1));
                arrays.get(list.get(j+1)).add(list.get(j));

            }
            for (int j=0;j<n;j++){
                if (!visited[j]){
                    ArrayList<Integer> component=new ArrayList<>();
                    Queue<Integer> queue=new LinkedList<>();
                    queue.add(j);
                    while (!queue.isEmpty()){
                        long x=queue.peek();
                        queue.poll();
                        if (visited[(int) x]) continue;
                        visited[(int) x]=true;
                        component.add((int) x);
                        for (int p=0;p<arrays.get(j).size();p++){
                            if (!visited[arrays.get(j).get(p)]){
                                queue.add(arrays.get(j).get(p));
                            }
                        }

                    }
                    for (int q=0;q<component.size();q++){
                        ans.set(component.get(q),component.size());
            //            System.out.println(ans.get(component.get(q)));

                    }

                }
            }


        }


        for (int j=0;j<n;j++) System.out.print(ans.get(j));
        System.out.println();




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
