package coding.play.round94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        int tc= fs.nextInt();
        for (int i=0;i<tc;i++){
            int n= fs.nextInt();
            int[] a= fs.readArray(n);
            long ans=0;
            int[] lc=new int[n+100];
            for (int l=0;l<n;l++){
                int[] rC=new int[n+100];
                for (int r=n-1;r>l;r--){
                    System.out.println(ans+"    "+(l+1)+"   "+(r+1)+"   "+lc[a[r]]+"    "+rC[a[l]]);
                    ans+= (long) rC[a[l]] *lc[a[r]];
                    rC[a[r]]++;
                }
                lc[a[l]]++;
            }
            System.out.println(ans);
        }

    }

}
