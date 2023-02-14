package jan.dp_at_coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class XTowers {
    static class Tower implements Comparable<Tower>{
        int weight,strength;
        long val;

        public Tower(int weight, int strength, long val) {
            this.weight = weight;
            this.strength = strength;
            this.val = val;
        }

        @Override
        public int compareTo(Tower o) {
            return (o.strength+o.weight)-this.weight+this.strength;
        }
    }

    public static void main(String[] args) {
        FastScanner fastScanner=new FastScanner();
        int n= fastScanner.nextInt();
        Tower[] towers=new Tower[n];
        for (int i=0;i<n;i++) towers[i]=new Tower(fastScanner.nextInt(), fastScanner.nextInt(), fastScanner.nextLong());
        Arrays.sort(towers);
        long[] dp=new long[10009];

        dp[0]=0;
        for (int i=0;i<n;i++){
            Tower tower=towers[i];
            for (int j= i;j>=0;j--){
             //   System.out.println(i+" "+j);
                dp[tower.weight+towers[j].weight]=Math.max(dp[tower.weight+towers[j].weight],dp[towers[j].weight]+tower.val);
                dp[tower.weight]=Math.max(dp[tower.weight],dp[towers[j].weight]);

            }

        }
        long max=Long.MIN_VALUE;
        for (long i:dp){
            max=Math.max(max,i);
        }
        System.out.println(max);


    }

    static final Random random=new Random();
    static final int mod=1_000_000_007;
    static long[] factorials=new long[2_000_001];
    static long[] invFactorials=new long[2_000_001];

    static void ruffleSort(int[] a) {
        int n=a.length;//shuffle, then sort
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }

    static long add(long a, long b) {
        return (a+b)%mod;
    }

    static long sub(long a, long b) {
        return ((a-b)%mod+mod)%mod;
    }

    static long mul(long a, long b) {
        return (a*b)%mod;
    }

    static long exp(long base, long exp) {
        if (exp==0) return 1;
        long half=exp(base, exp/2);
        if (exp%2==0) return mul(half, half);
        return mul(half, mul(half, base));
    }

    static void precompFacts() {
        factorials[0]=invFactorials[0]=1;
        for (int i=1; i<factorials.length; i++) factorials[i]=mul(factorials[i-1], i);
        invFactorials[factorials.length-1]=exp(factorials[factorials.length-1], mod-2);
        for (int i=invFactorials.length-2; i>=0; i--)
            invFactorials[i]=mul(invFactorials[i+1], i+1);
    }

    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n-k]));
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
