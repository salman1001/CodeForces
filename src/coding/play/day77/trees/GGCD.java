package coding.play.day77.trees;

import com.company.random.A;

import java.util.ArrayList;
import java.util.Scanner;

public class GGCD {
    static Scanner sc=new Scanner(System.in);
    static boolean[] prime=new boolean[200005];
    static int[] visted=new int[200005];
    static  long[] arr;

    static ArrayList<Integer> primes=new ArrayList<>();
    static ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
   // static int[] vals=new int[200005];
    static ArrayList<Pair> distt=new ArrayList<>();
    static ArrayList<ArrayList<Integer>> vals=new ArrayList<>();
    public static void main(String[] args) {
        int n= sc.nextInt();
        for (int i=0;i<200010;i++){
            edges.add(new ArrayList<>());
            vals.add(new ArrayList<>());
        }
        arr=new long[n];

        for (int i=0;i<n;i++){
            arr[i]= sc.nextLong();
            vals.get((int) arr[i]).add(i);

        }
        //get all the primes
        for (int i=0;i<200005;i++) prime[i]=true;
        for (int i=2;i<200005;i++){
            if (prime[i]){
                primes.add(i);
                for (int j=i*2;j<200005;j+=i){
                    prime[j]=false;
                }

            }
        }
        for (int i=0;i<n-1;i++){
            int u= sc.nextInt();
            int v= sc.nextInt();
            u--;v--;
            edges.get(u).add(v);
            edges.get(v).add(u);
        }


        long ans=0;
        for (Integer p:primes){
            ArrayList<Integer> inc=new ArrayList<>();
            for (int i=p;i<200005;i+=p){
                for (Integer j:vals.get(i)){
                    inc.add(j);
                }

            }

            for (Integer x:inc){
                if (visted[x]!=p){
                    distt.clear();
                    dfs(x,-1,0,p);
                    Pair far=distt.get(0);
                    for (Pair pp:distt){
                       if (pp.dist> far.dist){
                           far=pp;
                       }
                    }


                    distt.clear();
                    dfs(far.vertex, -1,0,p);
                    for (Pair pp :distt){
                        ans=Math.max(ans, pp.dist+1);
                    }



                }
            }






        }
        System.out.println(ans);




    }

    private static void dfs(Integer cur, int par, long dist, Integer prime) {
        distt.add(new Pair(dist,cur));
        visted[cur]=prime;
        for (Integer child:edges.get(cur)){
            if (child!=par){
                if (arr[child]%prime==0) dfs(child,cur,dist+1,prime);
            }
        }

    }

    static class Pair{
        long dist;
        int vertex;

        public Pair(long dist, int vertex) {
            this.dist = dist;
            this.vertex = vertex;
        }
    }


















    /*

    import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class E implements Runnable{
	static int n,m,k;
	static int[] precalc; // What option would he take if he was free at this timestep?
	static Bag[] bag;

	static class Bag implements Comparable<Bag>{
		int l, r, d, w, i;
		public Bag(int a, int b, int c, int e, int k) {
			l=a;
			r=b;
			d=c;
			w=e;
			i=k;
		}
		public Bag(int k) {
			i=k;
			l = bag[i].l;
			r = bag[i].r;
			d = bag[i].d;
			w = bag[i].w;
		}

		public int compareTo(Bag o) {
			if (i==o.i) return 0;
			if (w == o.w) {
				if (d ==  o.d) return i-o.i;
				return o.d-d;
			}
			return o.w -w;
		}
	}

	static class Point implements Comparable<Point>{
		int i;
		boolean open;
		public Point(int a, boolean b) {
			i=a;
			open=b;
		}
		int eval() {
			return open ? bag[i].l : bag[i].r;
		}

		public int compareTo(Point o) {
			int v = eval();
			int ov = o.eval();
		//	System.out.println("Comparing "  + this + " " + o +", and we got " + v + "  " + ov );
			if (v==ov) {
				if (open == o.open) return 0;
				if (open) return -1;
				return 1;
			}
			return v-ov;
		}
		public String toString() {
			return "[" + i +  ", " +  open + "]";
		}
	}

	static long[][] dp;

	static long solve(int  i, int j) {
		//System.out.println(i + " " + j + " "  +precalc[i]);
		if (i>n) return 0;
		if (dp[i][j]==-1) {
			dp[i][j] = Long.MAX_VALUE/30;
			if (precalc[i] == -1) dp[i][j] = solve(i+1,j);
			else {
				Bag cur = bag[precalc[i]];
				dp[i][j] = solve(cur.d+1,j) + cur.w;
				if (j != m) dp[i][j] = min(dp[i][j], solve(i+1,j+1));
			}

		}
		return dp[i][j];
	}


	public static void main(String[] args) throws IOException {
		// br = new BufferedReader(new FileReader(".in"));
		// out = new PrintWriter(new FileWriter(".out"));
		new Thread(null, new E(), "peepee", 1<<28).start();

	}

	/* Stupid things to try if stuck:
	 * n=1, expand bsearch range
	 * brute force small patterns
	 * submit stupid intuition
	 */
/*

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static StringTokenizer st = new StringTokenizer("");
    static String read() throws IOException{return st.hasMoreTokens() ? st.nextToken():(st = new StringTokenizer(br.readLine())).nextToken();}
    static int readInt() throws IOException{return Integer.parseInt(read());}
    static long readLong() throws IOException{return Long.parseLong(read());}
    static double readDouble() throws IOException{return Double.parseDouble(read());}
    @Override
    public void run() {
        // TODO Auto-generated method stub

        try {
            n=readInt();
            m=readInt();
            k=readInt();
            bag = new Bag[k];
            PriorityQueue<Point> pt = new PriorityQueue<Point>();
            for (int i =0;i < k; i++) {
                bag[i]= new Bag(readInt(),readInt(),readInt(),readInt(), i);
                pt.add(new Point(i,true));
                pt.add(new Point(i,false));
            }

            TreeSet<Bag> ts = new TreeSet<Bag>();
            precalc = new int[n+10];
            Arrays.fill(precalc, -1);
            for (int i = 1; i <= n; i++) {
                while(!pt.isEmpty() && pt.peek().eval() <= i && pt.peek().open) {
                    //	System.out.println(pt);
                    ts.add(new Bag(pt.poll().i));
                }
                if (!ts.isEmpty()) precalc[i] = ts.first().i;
                while(!pt.isEmpty() && pt.peek().eval() <= i && !pt.peek().open) {
                    //	System.out.println(pt);
                    ts.remove(new Bag(pt.poll().i));
                }
            }

            dp = new long[n+1][m+1];
            for (long[] x: dp) Arrays.fill(x, -1);

            out.println(solve(1,0));
            out.close();
        }
        catch (IOException e) {}

    }
}




     */






















}
