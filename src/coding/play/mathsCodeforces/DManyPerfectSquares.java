package coding.play.mathsCodeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DManyPerfectSquares {
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
    static long ans=1;
    static long[] arr;


    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        int t= fs.nextInt();
        for (int i=0;i<t;i++){
            int n= fs.nextInt();
            arr= fs.readLongArray(n);
            for (int j=0;j<n;j++){
                for (int k=j+1;k<n;k++){
                    long diff=arr[k]-arr[j];
                    for (int w=1;w*w<=diff;w++){
                        if (diff%w==0){
                            long q=diff/w+w;
                            if (q%2==0){
                                q/=2;
                                if (q*q-arr[k]>=0){
                                    maxIcanGet(q*q-arr[k]);
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
            ans=1;

        }
    }
    static void maxIcanGet(long x){
        int counter=0;
        for (int i=0;i<arr.length;i++){
            long srt= (long) Math.sqrt(arr[i]+x);
          //  System.out.println(srt+"   "+(arr[i]+x));
            if ((srt*srt)==(arr[i]+x)) counter++;
        }
        ans= Math.max(ans,counter);
    }

}
