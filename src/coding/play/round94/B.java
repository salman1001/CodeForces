package coding.play.round94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
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
        for (int j=0;j<tc;j++){
            long n= fs.nextLong();long m= fs.nextLong();
            long ns= fs.nextLong();long na= fs.nextLong();
            long ws= fs.nextLong();long wa= fs.nextLong();
            if (ws>wa){
                //swap
                long temp =ns;
                ns=na;
                na=temp;

                temp=ws;
                ws=wa;
                wa=temp;
            }
            long ans=0;

            for (int i=0;i<=ns;i++){
                long tempns=ns;long tempna=na;long tempi=n;long temph=m;
                long cur=0;
                cur=i;
                if (i*ws<=tempi){
                    tempi-=i*ws;
                    tempns-=i;
                    long takeA=Math.min(tempna,tempi/wa);
                    tempi-=takeA*wa;
                    tempna-=takeA;
                    cur+=takeA;

                    long hs=Math.min(tempns,temph/ws);
                    tempns-=hs;
                    temph-=hs*ws;
                    cur+=hs;

                    long ha=Math.min(tempna,temph/wa);
                    tempna-=ha;
                    temph-=ha*wa;
                    cur+=ha;
                    ans=Math.max(ans,cur);


                }
            }
            System.out.println(ans);
        }



    }

}
