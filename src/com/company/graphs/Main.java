package com.company.graphs;

import java.io.*;
import java.util.*;

public class Main extends PrintWriter {

    ArrayList<ArrayDeque<int[]>> adj1;


    void solve()  {
        int n = sc.nextInt();
        int m = sc.nextInt();
        adj1 = new ArrayList<>();
        for(int u = 0 ; u < n; u++) adj1.add( new ArrayDeque<>());
        int nn = n;
        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            String pos = Integer.toString(i);
            for(int[] dir : new int[][] {
                    {x,y},{y,x}
            }) {
                int last = dir[0];
                for(int j = 0; j < pos.length()-1; j++) {
                    adj1.add(new ArrayDeque<>());

                    int c = pos.charAt(j)-'0';
                    adj1.get(last).add(new int[] {nn, c});

                    last = nn++;
                }
                int c = pos.charAt(pos.length()-1)-'0';
                adj1.get(last).add(new int[] {dir[1], c});
            }
        }

        ArrayDeque<int[]>[] to_sort = new ArrayDeque[10];
        for(int i = 0; i < 10; i++) to_sort[i] = new ArrayDeque<>();

        for(int i = 0; i < nn; i++) {
            for(int j = 0; j < 10; j++) to_sort[j].clear();
            ArrayDeque<int[]> cur = adj1.get(i);
            for(int[] u : cur) to_sort[u[1]].add(u);
            cur.clear();
            for(int j = 9; j >= 0; j--) cur.addAll(to_sort[j]);
        }

        adj2 = new ArrayDeque[nn];
        for(int u = 0; u < nn; u++) adj2[u] = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] done = new boolean[nn];
        int[] d = new int[nn];
        done[0] = true;
        queue.add(0);
        while(!queue.isEmpty()) {
            int u = queue.removeFirst();
            for(int[] vv : adj1.get(u)) {
                int v = vv[0];
                if(!done[v]) {
                    done[v] = true;
                    d[v] = d[u]+1;
                    queue.addLast(v);
                }
            }
        }
        for(int u = 0; u < nn; u++) {
            for(int[] vv : adj1.get(u)) {
                if(d[vv[0]] == d[u]+1) {
                    adj2[u].add(vv);
                }
            }
        }

        Arrays.fill(done, false);
        ArrayDeque<Integer> state = new ArrayDeque<>(); state.add(0);



        ArrayDeque<ArrayDeque<Integer>> queue2 = new ArrayDeque<>();
        queue2.add(state);
        long[] ans = new long[nn];
        done[0] = true;
        while(!queue2.isEmpty()) {
            ArrayDeque<Integer> uu = queue2.remove();

            long cost_ = ans[uu.getFirst()];

            ArrayDeque<Integer>[] next = new ArrayDeque[10];
            for(int i = 0; i < 10; i++) next[i] = new ArrayDeque<>();

            for(int u : uu) for(int[] vv : adj2[u]) {
                next[vv[1]].add(vv[0]);
            }

            for(int i = 0; i < 10; i++) {
                ArrayDeque<Integer> v = new ArrayDeque<>();
                for(int vv : next[i]) {
                    if(!done[vv]) {
                        v.add(vv);
                        ans[vv] = (cost_ * 10L + i) % MOD;
                        done[vv] = true;
                    }
                }
                if(!v.isEmpty()) queue2.add(v);
            }

        }









        for(int u = 1; u < n; u++) println(ans[u]);





    }


    ArrayDeque<int[]>[] adj2;

    long MOD = 1000000007L;




    //  Solution() throws FileNotFoundException { super(new File("output.txt")); }
//  InputReader sc = new InputReader(new FileInputStream("test_input.txt"));
    Main() { super(System.out); }
    InputReader sc = new InputReader(System.in);
    static class InputReader {
        InputReader(InputStream in) { this.in = in; } InputStream in;

        private byte[] buf = new byte[16384];
        private int    curChar;
        private int    numChars;


        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }

    public static void main(String[] $) {
        new Thread(null, new Runnable() {
            public void run() {
                long start = System.nanoTime();
                try {Main solution = new Main(); solution.solve(); solution.flush();}
                catch (Exception e) {e.printStackTrace(); System.exit(1);}
              //  System.err.println((System.nanoTime()-start)/1E9);
            }
        }, "1", 1 << 27).start();

    }
}
