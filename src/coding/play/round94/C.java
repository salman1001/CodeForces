package coding.play.round94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
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

    public static void main(String[] args) {
       FastScanner fs=new FastScanner();
       int tc= fs.nextInt();
       for (int k=0;k<tc;k++){
           char[] arr=fs.next().toCharArray();
           int x= fs.nextInt();
           int n= arr.length;
           char[] ans=new char[n];
           Arrays.fill(ans,'1');
           for (int i=0;i<n;i++){
               if (arr[i]=='0'){
                   if (i-x>=0){
                       ans[i-x]='0';
                   }
                   if (i+x<n){
                       ans[i+x]='0';

                   }
               }
           }
           boolean isposs=true;
           for (int i=0;i<n;i++){
               if (arr[i]=='1'){
                   if (i-x>=0){
                       if (ans[i-x]=='1') continue;
                   }
                   if (i+x<n){
                       if (ans[i+x]=='1') continue;

                   }
                   isposs=false;
               }
           }
          // String srt=new String(ans);
          // System.out.println(srt);
           // System.out.println(isposs?toString(ans):-1);
           System.out.println(isposs?String.valueOf(ans):-1);



       }

    }


}
