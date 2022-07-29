package com.company.div_808;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D {
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        int tc= fs.nextInt();
        for (int i=0;i<tc;i++){
            int n= fs.nextInt();
            int[] arr= fs.readArray(n);
            PriorityQueue<Integer> pq1=new PriorityQueue();
            PriorityQueue<Integer> pq2=new PriorityQueue();

            for (int j=0;j<n;j++){
               // System.out.print(arr[j]+" ");
                pq1.add(arr[j]);
            }
            boolean goto0=true;
            for (int j=0;j<n-1;j++){
                if (goto0) {
                    boolean gone=false;


                    while (!pq1.isEmpty() && pq1.peek() == 0&&pq1.size()>1) {
                       // System.out.println("called");
                        pq1.poll();
                        gone=true;
                    }


                    if (!pq1.isEmpty()&&pq1.size()>1) {
                        if (gone) pq1.add(0);
                        int a = pq1.poll();
                        while (!pq1.isEmpty()) {
                            int b = pq1.poll();
                            int diff = b - a;
                            a = b;
                            pq2.add(diff);
                        }
                    }
                    goto0=false;
                }


                else {
                    boolean gone=false;
                        while (!pq2.isEmpty()&&pq2.peek()==0&&pq2.size()>1){
                          //  System.out.println("called2");

                            pq2.poll();
                            gone=true;
                        }
                    if (!pq2.isEmpty()&&pq2.size()>1) {
                        if (gone) pq2.add(0);

                        int a=pq2.poll();
                        while (!pq2.isEmpty()){
                            int b=pq2.poll();
                            int diff=b-a;
                            a=b;
                            pq1.add(diff);

                        }
                    }
                    goto0=true;

                }


            }
            long ans=0;
            if (!pq1.isEmpty()) ans+=pq1.poll();
            if (!pq2.isEmpty()) ans+=pq2.poll();

//            if (n%2==0) System.out.println(pq2.poll());
//            else System.out.println(pq1.poll());
            System.out.println(ans);


        }



    }



    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static class FastScanner {
        public BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
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
