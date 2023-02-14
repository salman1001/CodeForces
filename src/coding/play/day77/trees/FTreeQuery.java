package coding.play.day77.trees;

import java.util.*;

public class FTreeQuery {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        go();
       // call();
//        int n= scanner.nextInt();
//        int k= scanner.nextInt();
//        int[] arr=new int[n];
//        for (int i=0;i<n;i++){
//            arr[i]= scanner.nextInt();
//        }
//        double l=0,r=  10e9;
//        for (int i=0;i<60;i++){
//            double mid=l+(r-l)/2;
//            if (fun(mid,arr,k)){
//                l=mid;
//
//            }
//            else {
//                r=mid;
//
//            }
//        }
//        System.out.println(l);
    }

    private static void go() {
        int n= scanner.nextInt();int m= scanner.nextInt();int k= scanner.nextInt();
        Pair[] pairs=new Pair[n];
        HashMap<Integer, List<Pair>> hashMap=new HashMap<>();

        for (int i=0;i<k;i++){
            long s= scanner.nextLong();
            long t= scanner.nextLong();
            long d= scanner.nextLong();
            long w=scanner.nextLong();
          //  pairs[i]=new Pair(s,t,d,w);



        }

        //dp[i][j]-----> max she could get if she is at ith time and she has left j no of disturbance allowed
        long[][] dp=new long[100005][205];


        for (int i=0;i<100005;i++){
            Pair p=new Pair(0,0,0,0);
            for (int j=205;j>=1;j--){
                dp[i+1][j]=Math.max(dp[i+1][j],dp[i][j]);
                dp[i+1][j-1]=Math.max(dp[i+1][j],(dp[i][j]+p.w));
            }
        }
        long ans=0;
        for (int i=0;i<205;i++){
            ans=Math.max(ans,dp[n-1][i]);
        }
        System.out.println(ans);



    }
    static class Pair{
        int type;
        long start;

        long d;
        long w;

        public Pair(long start, long d, long w,int type) {
            this.start = start;

            this.d = d;
            this.w = w;
            this.type=type;
        }
    }


    private static void call() {
       // PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->-(a-b));
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));

        pq.add(10);
        pq.add(5);
        pq.add(20);

            System.out.print(pq.poll()+" ");
        System.out.print(pq.poll()+" ");

        System.out.print(pq.poll()+" ");


        System.out.println();
    }

    private static boolean fun(double mid, int[] arr, int k) {
        int count=0;
        for (Integer i:arr){
            count+=i/mid;
        }
        return count>=k;
    }
}
