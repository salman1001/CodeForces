package com.company.dynamicProgrammingOptimizations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AIntroductionSegmentTreeOptimization {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n= sc.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++) arr[i]= sc.nextInt();
        int[] l=new int[n-1];
        int[] r=new int[n-1];
        for (int i=0;i<n-1;i++) {
            l[i]= sc.nextInt()-1;
            r[i]= sc.nextInt()-1;
        }
        long[] dp=new long[4*n];
        long [] pre=new long[n];
        pre[0]=arr[0];
        for (int i=1;i<n;i++) pre[i]=pre[i-1]+arr[i];
        dp[0]=0;
//        SegmentTree segmentTree=new SegmentTree(dp);
//        for (int i=1;i<n;i++){
//            dp[i]=pre[i]+segmentTree.rMinQ(l[i-1],r[i-1]);
//            segmentTree.update(i,i,dp[i]-pre[i-1]);
//        }
//        for (int i=0;i<n;i++) System.out.print(dp[i]+" ");
//        System.out.println();










    }
//    public static class SegmentTree {
//        private Node[] heap;
//        private long[] array;
//        private int size;
//
//        /**
//         * Time-Complexity:  O(n*log(n))
//         *
//         * @param array the Initialization array
//         */
//        public SegmentTree(long[] array) {
//            this.array = Arrays.copyOf(array, array.length);
//            //The max size of this array is about 2 * 2 ^ log2(n) + 1
//            size = (int) (2 * Math.pow(2.0, Math.floor((Math.log((double) array.length) / Math.log(2.0)) + 1)));
//            heap = new Node[size];
//            build(1, 0, array.length);
//        }
//
//
//        public int size() {
//            return array.length;
//        }
//
//        //Initialize the Nodes of the Segment tree
//        private void build(int v, int from, int size) {
//            heap[v] = new Node();
//            heap[v].from = from;
//            heap[v].to = from + size - 1;
//
//            if (size == 1) {
//                heap[v].sum = array[from];
//                heap[v].min = array[from];
//            } else {
//                //Build childs
//                build(2 * v, from, size / 2);
//                build(2 * v + 1, from + size / 2, size - size / 2);
//
//                heap[v].sum = heap[2 * v].sum + heap[2 * v + 1].sum;
//                //min = min of the children
//                heap[v].min = Math.min(heap[2 * v].min, heap[2 * v + 1].min);
//            }
//        }
//
//        /**
//         * Range Sum Query
//         *
//         * Time-Complexity: O(log(n))
//         *
//         * @param  from from index
//         * @param  to to index
//         * @return sum
//         */
//        public long rsq(int from, int to) {
//            return rsq(1, from, to);
//        }
//
//        private long rsq(int v, int from, int to) {
//            Node n = heap[v];
//
//            //If you did a range update that contained this node, you can infer the Sum without going down the tree
//            if (n.pendingVal != null && contains(n.from, n.to, from, to)) {
//                return (to - from + 1) * n.pendingVal;
//            }
//
//            if (contains(from, to, n.from, n.to)) {
//                return heap[v].sum;
//            }
//
//            if (intersects(from, to, n.from, n.to)) {
//                propagate(v);
//                long leftSum = rsq(2 * v, from, to);
//                long rightSum = rsq(2 * v + 1, from, to);
//
//                return leftSum + rightSum;
//            }
//
//            return 0;
//        }
//
//        /**
//         * Range Min Query
//         *
//         * Time-Complexity: O(log(n))
//         *
//         * @param  from from index
//         * @param  to to index
//         * @return min
//         */
//        public long rMinQ(int from, int to) {
//            return rMinQ(1, from, to);
//        }
//
//        private long rMinQ(int v, int from, int to) {
//          Node n = heap[v];
//
//
//            //If you did a range update that contained this node, you can infer the Min value without going down the tree
//            if (n.pendingVal != null && contains(n.from, n.to, from, to)) {
//                return n.pendingVal;
//            }
//
//            if (contains(from, to, n.from, n.to)) {
//                return heap[v].min;
//            }
//
//            if (intersects(from, to, n.from, n.to)) {
//                propagate(v);
//                long leftMin = rMinQ(2 * v, from, to);
//                long rightMin = rMinQ(2 * v + 1, from, to);
//
//                return Math.min(leftMin, rightMin);
//            }
//
//            return Long.MAX_VALUE;
//        }
//
//
//        /**
//         * Range Update Operation.
//         * With this operation you can update either one position or a range of positions with a given number.
//         * The update operations will update the less it can to update the whole range (Lazy Propagation).
//         * The values will be propagated lazily from top to bottom of the segment tree.
//         * This behavior is really useful for updates on portions of the array
//         * <p>
//         * Time-Complexity: O(log(n))
//         *
//         * @param from  from index
//         * @param to    to index
//         * @param value value
//         */
//        public void update(int from, int to, long value) {
//            update(1, from, to, value);
//        }
//
//        private void update(int v, int from, int to, long value) {
//
//            //The Node of the heap tree represents a range of the array with bounds: [n.from, n.to]
//          Node n = heap[v];
//
//            /**
//             * If the updating-range contains the portion of the current Node  We lazily update it.
//             * This means We do NOT update each position of the vector, but update only some temporal
//             * values into the Node; such values into the Node will be propagated down to its children only when they need to.
//             */
//            if (contains(from, to, n.from, n.to)) {
//                change(n, value);
//            }
//
//            if (n.size() == 1) return;
//
//            if (intersects(from, to, n.from, n.to)) {
//                /**
//                 * Before keeping going down to the tree We need to propagate the
//                 * the values that have been temporally/lazily saved into this Node to its children
//                 * So that when We visit them the values  are properly updated
//                 */
//                propagate(v);
//
//                update(2 * v, from, to, value);
//                update(2 * v + 1, from, to, value);
//
//                n.sum = heap[2 * v].sum + heap[2 * v + 1].sum;
//                n.min = Math.min(heap[2 * v].min, heap[2 * v + 1].min);
//            }
//        }
//
//        //Propagate temporal values to children
//        private void propagate(int v) {
//          Node n = heap[v];
//
//            if (n.pendingVal != null) {
//                change(heap[2 * v], n.pendingVal);
//                change(heap[2 * v + 1], n.pendingVal);
//                n.pendingVal = null; //unset the pending propagation value
//            }
//        }
//
//        //Save the temporal values that will be propagated lazily
//        private void change(Node n, long value) {
//            n.pendingVal = value;
//            n.sum = n.size() * value;
//            n.min = value;
//            array[n.from] = value;
//
//        }
//
//        //Test if the range1 contains range2
//        private boolean contains(int from1, int to1, int from2, int to2) {
//            return from2 >= from1 && to2 <= to1;
//        }
//
//        //check inclusive intersection, test if range1[from1, to1] intersects range2[from2, to2]
//        private boolean intersects(int from1, int to1, int from2, int to2) {
//            return from1 <= from2 && to1 >= from2   //  (.[..)..] or (.[...]..)
//                    || from1 >= from2 && from1 <= to2; // [.(..]..) or [..(..)..
//        }
//
//        //The Node class represents a partition range of the array.
//        static class Node {
//            long sum;
//            long min;
//            //Here We store the value that will be propagated lazily
//            Long pendingVal = null;
//            int from;
//            int to;
//
//            int size() {
//                return to - from + 1;
//            }
//        }
//    }




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
