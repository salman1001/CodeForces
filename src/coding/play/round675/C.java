package coding.play.round675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
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
    static long mod=1000000007;

    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        char[] nums=fs.next().toCharArray();
        int n= nums.length;
        int[] values=new int[n];
        for (int i=0;i< n;i++) {
            values[i]=nums[n-i-1]-'0';

        }
        long tenPow=1;
        long total=0;
        long biggernum= n-1;
        long tensVl=0;
        long multiple=1;
        for (int i:values){
           // System.out.println(total);
            total=add(total,mul(i,mul(nCr(biggernum),tenPow)));
            total=add(total,mul(i,tensVl));
            tensVl=add(tensVl,mul(tenPow,multiple));
            multiple=add(multiple,1);
            tenPow=mul(tenPow,10);
            biggernum--;

        }
        System.out.println(total);


    }
    static long add(long a,long b){
        return ((a+b)%mod+mod)%mod;
    }
    static long mul(long a,long b){
        return ((a*b)%mod+mod)%mod;
    }
    static long nCr(long n){
         return add(n*(n+1)/2,0);
    }


}
