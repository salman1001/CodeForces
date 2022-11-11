package com.company.round725;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class C {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc = sc.nextInt();
        for (int tt = 0; tt < tc; tt++) {
            int n = sc.nextInt();
            long l = sc.nextLong();
            long r = sc.nextLong();
            Integer[] arrr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arrr[i] = Math.toIntExact(sc.nextLong());
            }
            long ans = 0;
            Arrays.sort(arrr);

           // long ans = 0;
            for (int i = 1; i < n; i++) {
                int pl = find_greater_than((int) (l - arrr[i]), arrr, i - 1);
                int pr = find_less_than((int) (r - arrr[i]), arrr, i - 1);

                if (pl == -1 || pr == -1) continue;
                ans += pr - pl + 1;
            }
            System.out.println(ans);
        }
    }

        private static int find_greater_than(int value, Integer[] a, int end) {
            int left = 0;
            int right = end;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (a[mid] < value) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return a[right] >= value ? right : -1;
        }

        private static int find_less_than(int value, Integer[] a, int end) {
            int left = 0;
            int right = end;
            while (left < right) {
                int mid = (left + right + 1) >> 1;
                if (a[mid] > value) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return a[left] <= value ? left : -1;
        }
//          //  System.out.println(arrr[0]);
//
//     //    outer:   for (int i=0;i<n;i++){
//                int left=0,right=n-1;
//                while (left<right){
//                    long temp=arrr[left]+arrr[right];
//                    if (temp>=l&&temp<=r){
//                       // System.out.println(temp+" "+i+" "+left+" "+right);
//                        ans++;
//                    }
//                    else if (temp<l){
//                         left++;
//                    }
//                    else {
//                        right--;
//                    }
//
//                }
//
//
//         //   }
//            System.out.println(ans);

        }
