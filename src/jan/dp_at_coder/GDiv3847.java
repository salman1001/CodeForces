package jan.dp_at_coder;

import coding.play.day6.RE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GDiv3847 {
    public static void main(String[] args) {
        FastScanner fastScanner=new FastScanner();
        int t= fastScanner.nextInt();
     for (int tc=0;tc<t;tc++){
            int n= fastScanner.nextInt();
            int m= fastScanner.nextInt();
            int normal= fastScanner.nextInt();
            int live= fastScanner.nextInt();
            int[] normalsIndex=new  int[normal+5];
            int[] livesIndex= new int[live+5];
            for (int i=0;i<normal;i++) normalsIndex[fastScanner.nextInt()]++;
            for (int i=0;i<live;i++) livesIndex[fastScanner.nextInt()]++;

            int[] isPossToGetI=new int[n+5];
            ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
            for (int i=0;i<n+5;i++) edges.add(new ArrayList<>());
            for (int i=0;i<m;i++){
                int a= fastScanner.nextInt();int b= fastScanner.nextInt();
                edges.get(a).add(b);
                edges.get(b).add(a);
                if (livesIndex[a]>0) isPossToGetI[b]=1;
                if (livesIndex[b]>0) isPossToGetI[a]=1;


            }
            //See if 1 has a one if yes done
            if (normalsIndex[1]>0) {
                System.out.println("YES");
                continue;
            }
            //now check if its adjacent either has one or its adjacent
            // has a jumps that has a one adjacent to jumps
            boolean[] visited=new boolean[n];
            ArrayDeque<DequeNode> deque=new ArrayDeque();
            deque.add(new DequeNode(1,0));
            int finalSteps=0;
            int counter=0;
            DequeNode lastFound=new DequeNode(0,0);
            while (!deque.isEmpty()){
                DequeNode dequeNode=deque.poll();
              //  System.out.println("j");
                if (!visited[dequeNode.index]) continue;
                visited[dequeNode.index]=true;
                if (normalsIndex[dequeNode.index]>0) {
                    counter++;
                    finalSteps= dequeNode.dist;
                    lastFound=dequeNode;
                }
                for (Integer ii:edges.get(dequeNode.index)){

                        if (livesIndex[ii]>0){
                            deque.add(new DequeNode(ii, dequeNode.dist+1));
                        }

                }
            }
            if (counter>1){
                System.out.println("YES");
                continue;

            }
            if (counter==0){
                System.out.println("NO");
                continue;
            }
            int helperCounter=0;

            for (int i=0;i<n;i++){
                if (normalsIndex[i]==0||i==lastFound.index) continue;
                if (isPossToGetI[i]>0) {
                    helperCounter++;
                }
                for (Integer ii:edges.get(i)){
                    if (livesIndex[ii]<=0) continue;
                    if (isPossToGetI[ii]>=0) {
                        System.out.println("YES");
                        break;
                    }


                }

            }
            if (helperCounter>=finalSteps-1){
                System.out.println("YES");
            }
            else System.out.println("NO");




        }

    }
    static class DequeNode{
        int index;
        int dist;

        public DequeNode(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
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
