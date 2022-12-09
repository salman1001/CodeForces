package com.company.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class Demo {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
      //  int n=3;
        long[] arr= {30,10,9,30,19,26,28,49,42};
        HashMap<Long, Long> tmap = new HashMap<>();
        for (int i=0;i< arr.length;i++){
         //   System.out.println(tmap.containsKey(arr[i]));
            if (tmap.containsKey(arr[i])) {
                Long c = (tmap.get(arr[i]));

                tmap.put((long) arr[i], (long) (c + 1));
                //System.out.println(arr[i]+"  "+c+1);
            }
            else {
                tmap.put((long) arr[i], 1L);
              //  System.out.println(arr[i]+"  "+1);

            }

        }
        long max=Integer.MIN_VALUE;
        long count=0;
        for (Entry m : tmap.entrySet()){
            long a= (long) m.getKey();
             long coun= (long) m.getValue();
             if (coun>=count){
                 max=a;
                 count=coun;
             }

        }
        int counter=0;
    //    System.out.println(max);
        for (int i=0;i< arr.length;i++){
            if (arr[i]!=max) counter++;
        }
        System.out.println(counter+1);



    }



    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static class FastScanner {
       public BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
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
