package coding.play.round675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {
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

    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        //we have a points in the form starting and ending
        int n= fs.nextInt();
        int m= fs.nextInt();
        Vector start=new Vector(fs.nextInt(), fs.nextInt());
        Vector end=new Vector(fs.nextInt(), fs.nextInt());
        Vector[] bonus=new Vector[m];
        for (int i=0;i<m;i++)  bonus[i]=new Vector(fs.nextInt(), fs.nextInt());
        Arrays.sort(bonus,(a,b)->{
            return Integer.compare(a.x,b.x);
        });



        dij(end,bonus);
        for (Vector v:bonus) v.d2=v.d1;
        dij(start,bonus);
        long ans=Math.abs(start.x- end.x)+Math.abs(start.y- end.y);
        for (Vector v:bonus){
            ans=Math.min(v.d1+ v.d2,ans );
        }
        System.out.println(ans);







    }
    static void dij(Vector start,Vector[] points){
        PriorityQueue<State> pq=new PriorityQueue<>();
        start.d1=0;
        for (Vector v:points) v.d1=Long.MAX_VALUE;
        pq.add(new State(start,0));

        while (!pq.isEmpty()){
            State next= pq.remove();
            if (next.dist!=next.n.d1) continue;
            for (int i=0;i<next.n.adJ.size();i++){
                Vector to=next.n.adJ.get(i);
                long newCost= next.dist+next.n.cost.get(i);
                if (newCost<to.d1){
                    to.d1=newCost;
                    pq.add(new State(to, to.d1));
                }
            }

        }
    }
    static class Vector{
        int x,y;
        ArrayList<Vector> adJ=new ArrayList<>();
        ArrayList<Long> cost=new ArrayList<>();
        long d1=Long.MAX_VALUE;
        long d2=Long.MAX_VALUE;

        public Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class State implements  Comparable<State> {
        Vector n;
        long dist;

        public State(Vector n, long dist) {
            this.n = n;
            this.dist = dist;
        }

        @Override
        public int compareTo(State o) {
            return Long.compare(dist,o.dist);
        }
    }

}
