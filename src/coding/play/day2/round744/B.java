package coding.play.day2.round744;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc=sc.nextInt();
        for (int i=0;i<tc;i++){
            int n= sc.nextInt();
            Pair[] arr=new Pair[n];
            for (int j=0;j<n;j++) arr[i]=new Pair(sc.nextInt(),i);
            Arrays.sort(arr);
            System.out.println(n);
            for(int k=0;k<n;k++){
               // System.out.println((k+1)+" "+(arr[k].index+1)+" "+());
            }
        }



    }
    static class Pair implements  Comparable<Pair>{
        long val;
        int index;

        public Pair(long val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
             return (int) (this.val-o.val);
        }
    }
}
