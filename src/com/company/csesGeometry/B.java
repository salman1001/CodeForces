package com.company.csesGeometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B {
    static class Points{
        public Points() {
        }

        long l;long r;

        public Points(long l, long r) {
            this.l = l;
            this.r = r;
        }
    }
    static FastScanner fs=new FastScanner();
    public static void main(String[] args) {































        int n= fs.nextInt();
        ArrayList<Points> list=new ArrayList<>();
        for (int i=0;i<n;i++)  list.add(new Points(fs.nextLong(), fs.nextLong()));
        Collections.sort(list ,(p1,p2)->{
            if (p1.l==p2.l) return (int) (p1.r-p2.r);
            else return(int) (p1.l-p2.l);
        });
        ArrayList<Points> myList=new ArrayList<>();
//        for (int i=0;i<list.size();i++){
        for (int rep=0;rep<2;rep++) {
            for (Points C : list) {
                while (myList.size() >= 2) {
                    Points A = myList.get(myList.size() - 2);
                    Points B = myList.get(myList.size() - 1);
                    Points Cn=new Points();
                    Cn=C;
                    Points Bn=new Points();
                    Bn=B;
                    Bn.l -= A.l;
                    Bn.r -= A.r;
                    Cn.l -= A.l;
                    Cn.r -= A.r;
                    if ((Bn.l * Cn.r - Bn.r * Cn.l) >= 0) {
                  /*      B.l -= RA.l;
                        B.r -= RA.r;
                        C.l -= RA.l;
                        C.r -= RA.r;*/
                        break;

                    }
//                    B.l += RA.l;
//                    B.r += RA.r;
//                    C.l += RA.l;
//                    C.r += RA.r;
                    myList.remove(myList.size() - 1);


                }
                myList.add(C);
            }
            myList.remove(myList.size()-1);
            for (int i=0;i<myList.size();i++) System.out.println(myList.get(i).l+"   "+myList.get(i).r);
            Collections.sort(list ,(p1,p2)->{
                if (p2.l==p1.l) return (int) (p2.r-p1.r);
                else return(int) (p2.l-p1.l);
            });
        }





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
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
