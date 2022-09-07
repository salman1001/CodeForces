package com.company.div3_674;

import java.util.HashMap;
import java.util.Scanner;
// 16 -5 -11 -15 10 5 4 -4
// 16 11 0 -15  -5   0 4 0
// 3

public class D {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n= sc.nextInt();
        long[] arr=new long[n];
        for (int i=0;i<n;i++) arr[i]= sc.nextLong();
        long pSum=0;
        HashMap<Long,Long> hashMap=new HashMap<>();
        long ans=0;
        hashMap.put(pSum,hashMap.getOrDefault(pSum,0L)+1);


        for (int i=0;i<n;i++){
            pSum+=arr[i];
            if (hashMap.getOrDefault(pSum,0L)>0) {
                ans++;
                hashMap.clear();
                hashMap.put(pSum-arr[i],hashMap.getOrDefault(pSum-arr[i],0L)+1);
            }
            hashMap.put(pSum,hashMap.getOrDefault(pSum,0L)+1);



        }
        System.out.println(ans);




    }
}
