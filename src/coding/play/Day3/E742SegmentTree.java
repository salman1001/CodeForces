package coding.play.Day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.out;

public class E742SegmentTree {

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

    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        //read an array


        //make a segmentTree


        //look for the type of query asked


        //either update or a query on update


        //if asked for update set it in array and say whether there an inversion



        int n=fs.nextInt(), q=fs.nextInt();
        int[] a=fs.readArray(n);
        Seg st=new Seg(0, n-1);
        for (int i=0; i<n-1; i++) {
            if (a[i]>a[i+1]) st.pointUpdate(i, true);
        }
        for (int qq=0; qq<q; qq++) {
            int type=fs.nextInt();
            if (type==1) {
                //point update
                int position=fs.nextInt()-1, value=fs.nextInt();
                a[position]=value;
                if (position!=0) {
//					System.out.println("Setting index "+(position-1)+" to "+(a[position]<a[position-1]));
                    st.pointUpdate(position-1, a[position]<a[position-1]);
                }
//				System.out.println("\n\n");
                if (position!=n-1)
                    st.pointUpdate(position, a[position+1]<a[position]);
            }
            else {
                int l=fs.nextInt()-1, r=fs.nextInt()-1;
//				System.out.println("Quering "+l+" "+r);
                long ans=st.rangeQuery(l, r).value();
                out.println(ans);
            }
        }



    }
    static class Seg{

        int leftMost,rightMost;


        Seg lChild,rChild;


        Data data;

        //has constructor and initialize the array

        public Seg(int leftMost, int rightMost) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost==rightMost) data=new Data(1,1,0,1);
            else {
                int mid=(leftMost+rightMost)/2;
                lChild=new Seg(leftMost, mid);
                rChild=new Seg(mid+1, rightMost);
                recalc();

            }


        }
        void recalc() {
            if (leftMost==rightMost) {
                return;
            }
            data=data.combine(lChild.data, rChild.data);

        }




        void pointUpdate(int position, boolean isCutPoint) {
            if (leftMost==rightMost) {
                data=new Data(1, isCutPoint?0:1, 1, 0);
                return;
            }
            if (position<=lChild.rightMost) {
                lChild.pointUpdate(position, isCutPoint);
            }
            else {
                rChild.pointUpdate(position, isCutPoint);
            }
            recalc();
        }
        Data rangeQuery(int l, int r) {
            if (l>rightMost || r<leftMost) return null;
            if (l<=leftMost && r>=rightMost) return data;
            Data lAns=lChild.rangeQuery(l, r);
            Data rAns=rChild.rangeQuery(l, r);
            return Data.combine(lAns, rAns);
        }

    }
     public static class Data{
        //hold the longest prefix of 1s
        int leftStraight,rightStraight,middle,size;

        public Data(int leftStraight, int rightStraight, int middle, int size) {
            this.leftStraight = leftStraight;
            this.rightStraight = rightStraight;
            this.middle = middle;
            this.size = size;
        }
        //has a function to calculate its val on the basis of pre suffix and middle
         public int value(){
             if (size==leftStraight)
                 return (int) nC2(leftStraight);
             return (int) (middle+nC2(leftStraight) + nC2(rightStraight));

         }

        boolean uninterrupted() {
            return rightStraight==size;
        }

        static Data combine(Data l, Data r) {
            if (l==null) return r;
            if (r==null) return l;
            int newSize=l.size+r.size;
            int newL=-1;
            int newR=-1;
            long newM=-1;
            if (l.uninterrupted()) {
                newM=r.middle;
                newL=l.size+r.leftStraight;
            }
            else {
                newL=l.leftStraight;
            }
            if (r.uninterrupted()) {
                newR=r.size+l.rightStraight;
                newM=l.middle;
            }
            else {
                newR=r.rightStraight;
            }
            if (newM==-1) {
                newM=l.middle+r.middle+nC2(l.rightStraight+r.leftStraight);
            }
            Data ans=new Data(newL, newR, (int) newM,newSize);
//		System.out.println("Combined "+l+" "+r+" to "+ans);
            return ans;
        }
        static long nC2(int n) {
            return n*(long)(n+1)/2;
        }
        //has the function to combine
    }
}