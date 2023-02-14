package coding.play.round675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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

    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        char[] chars=fs.next().toCharArray();
        char[] stcaks=new char[chars.length+500];
        ArrayList<String> ans=new ArrayList<>();
        int myLastChanger=-1;
        int front =-1;
        PrintWriter pw=new PrintWriter(System.out);
        for (int i=chars.length-1;i>=0;i--){
            char currentCur=chars[i];
            if (front==-1){
                stcaks[++front]=currentCur;

            }
            else if (currentCur==stcaks[front]){
                if (myLastChanger==-1||stcaks[myLastChanger]<currentCur){
                    front--;
                }
                else {
                    stcaks[++front]=currentCur;
                }
            }
            else  {
                myLastChanger=front;
                stcaks[++front]=currentCur;
            }
            int length=front+1;
            StringBuilder st=new StringBuilder();
            if (length<=10){
                st.append(length+" ");
                for (int j=front;j>=0;j--){
                    st.append(stcaks[j]);
                }
                ans.add(st.toString());


            }
            else {
                st.append(length+" ");
                for (int j=front;j>front-5;j--){
                    st.append(stcaks[j]);
                }
                st.append("...");
                st.append(stcaks[1]);
                st.append(stcaks[0]);
                ans.add(st.toString());


            }
        }
        Collections.reverse(ans);
        for (String s:ans){
            pw.println(s);
        }
        pw.close();

    }
}
