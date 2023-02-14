package coding.play.round94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {
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
    static   int[] arr;
     static int n;
     static int[][] dp;

    public static void main(String[] args) {
       FastScanner fs=new FastScanner();
       n= fs.nextInt();
     arr= fs.readArray(n);
     dp=new int[n+1][n+1];
        Arrays.fill(dp,-1);
        System.out.println(solve(0,n));

    }

    private static long solve(int index, int depthINdex) {
        if (index>=n) return 0;
        if (dp[index][depthINdex]!=-1) return dp[index][depthINdex];
        int sum=0;
        if (arr[index]>arr[depthINdex]){
            sum= (int) (1+solve(index+1,depthINdex));

        }
        else {

        }
        return dp[index][depthINdex]=  sum;

    }


}
