package jan.dp_at_coder;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WInterval {

    static class  Interval implements Comparable<Interval>{
        int l,r;
        long value;
        public Interval(int l, int r, long value) {
            this.l = l;
            this.r = r;
            this.value = value;
        }
        @Override
        public int compareTo(Interval o) {
            if (o.l==this.l) return o.r-this.r;
            else return o.l-this.l;
        }
    }

    public static void main(String[] args) {
        FastScanner fastScanner=new FastScanner();
        int n= fastScanner.nextInt();
        int m= fastScanner.nextInt();
        Interval[] intervals=new Interval[m];
        TreeMap<Integer, Long> hashMap=new TreeMap<>();

        for (int i=0;i<m;i++) {
            int l= fastScanner.nextInt();int r= fastScanner.nextInt();long val= fastScanner.nextLong();l--;r--;
            hashMap.put(l,hashMap.getOrDefault(l,0L)+val);
            hashMap.put(r+1,hashMap.getOrDefault(r+1,0L)-val);
        }
        //Uses Segment Tree and Sweep line may be
        SegmentTree segmentTree=new SegmentTree(n+5);
        for (int i=1;i<=n;i++){
            segmentTree.increment(0,i-1,hashMap.getOrDefault(i,0l));
            segmentTree.increment(i,i, (long) segmentTree.max(0,i-1));
        }
        System.out.println(segmentTree.max(0,n));








    }

    public static class SegmentTree implements QueryInterface {
        int n;
        int[] lo,hi,min,delta;
        public SegmentTree(int n) {
            this.n=n;
            lo=new int[4*n+1];
            hi=new int[4*n+1];
            min=new int[4*n+1];
            delta=new int[4*n+1];

            init(1,0,n-1);
        }

        private void init(int i, int a, int b) {
            lo[i]=a;
            hi[i]=b;
            if (a==b) return;
            int m=(a+b)/2;
            init(2*i,a,m);
            init(2*i+1,m+1,b);
        }


        @Override
        public void increment(int a, int b, Long val) {
            increment(1,a,b, val);

        }
        void increment(int index,int a ,int b ,long val){
            if (b<lo[index]||hi[index]<a) return;
            if (a<=lo[index]&&hi[index]<=b) {
                delta[index]+=val;
                return;
            }
            prop(index);
            increment(2*index,a,b,val);
            increment(2*index+1,a,b,val);
            update(index);
        }
        void prop(int i){
            delta[2*i]+=delta[i];
            delta[2*i+1]+=delta[i];
            delta[i]=0;

        }
        void update(int i){
            min[i]=Math.max(min[2*i]+delta[2*i],min[2*i+1]+delta[2*i+1]);
        }

        @Override
        public int max(int i, int j) {
            return max(1,i,j);
        }
        int max(int index, int a, int b){
            if (b<lo[index]||hi[index]<a) return Integer.MIN_VALUE;
            if (a<=lo[index]&&hi[index]<=b) return min[index]+delta[index];
            prop(index);
            int minLeft= max(2*index,a,b);
            int minRight= max(2*index+1,a,b);

            update(index);
            return Math.max(minLeft,minRight);



        }



        public static void main(String[] args) {

        }
    }
    interface QueryInterface{
        void increment(int i, int j, Long val);
        int max(int i, int j);
    }
    class SlowRange implements QueryInterface {
        int [] arr;

        public SlowRange(int n) {
            arr=new int[n];
        }


        @Override
        public void increment(int i, int j, Long val) {
            for (int k=i;k<=j;k++) arr[k]+=val;

        }

        @Override
        public int max(int i, int j) {
            int res=arr[i];
            for (int k=i+1;k<=j;k++) res=Math.max(res,arr[k]);
            return res;
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
