package coding.play.day1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Raif_E_Carrots_For_Rabbit {
    static Scanner sc=new Scanner(System.in);
    static long get(long n,long parts){
        return (long) (n / parts) *(n/parts)*(parts-n%parts)+ (long) (n / parts + 1) *(n/parts+1)*(n%parts);
    }

    public static void main(String[] args) {
        int n= sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        //int[] b=new int[n];
        for (int i=0;i<n;i++)arr[i]= sc.nextInt();
        int s=k-n;
        long ans=0;
        PriorityQueue<long[]> pq=new PriorityQueue<>(
                (x,y)-> -Long.compare(x[2],y[2])

        );
        for (int i=0;i<n;i++){
            ans+=get(arr[i],1);
            pq.add(new long[]{arr[i],1,get(arr[i],1)-get(arr[i],2)});

        }
        for (int i=0;i<s;i++){
            long[] cur= pq.poll();
            ans-=cur[2];
            cur[1]++;
            cur[2]= get(cur[0],cur[1])-get(cur[0],cur[1]+1);
            pq.add(cur);
        }
        System.out.println(ans);


//        PriorityQueue<Pair> pq= new PriorityQueue<>();
//        for (int i = 0; i < n; i++) b[i] = 1;
//        long tot=0;
//        for (int i=0;i<n;i++){
//            tot+= (long) arr[i] *arr[i];
//        }
//
//        for (int i=0;i<n;i++){
//            long cost=diff(arr[i],2)-diff(arr[i],1);
//            pq.add(new Pair(-cost,i));
//        }
//        //for (int i=0;i<pq.size();i++) System.out.print(pq.poll().diff+" ");
//       // System.out.println();
//        for (int i=0;i<s;i++){
//            Pair pp= pq.poll();
//            tot-=pp.diff;
//            b[pp.parts]++;
//            long cost=diff(arr[pp.parts],b[pp.parts]+1 )-diff(arr[pp.parts],b[pp.parts]);
//            pq.add(new Pair(-cost,pp.parts));
//
//        }
//        System.out.println(tot);




    }
    public static long  diff(int n,int parts){
        int f=n/parts;
        int r=n%parts;
        return (long) (parts - r) *f*f+r*(f+1)*(f+1);


    }

    static class Pair implements Comparable<Pair> {
        long diff;
        int parts;

        public Pair(long diff, int parts) {
            this.diff = diff;
            this.parts = parts;
        }

        @Override
        public int compareTo(Pair o) {
            //return this.diff-o.diff;
            return (int) (o.diff-this.diff);
        }

//        @Override
//        public int compare(Pair o1, Pair o2) {
//            //return o1.diff-o2.diff;
//            return o2.diff-o1.diff;
//        }
    }

}
