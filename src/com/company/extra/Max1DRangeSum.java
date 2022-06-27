package com.company.extra;

public class Max1DRangeSum {
    public static void main(String[] args) {
        int n = 9, A[] = { 4, -5, 4, -3, 4, 4, -4, 4, -5 };
        int sum=0,ans=0;
        for (int i=0;i<n;i++){
            sum+=A[i];
            ans=Math.max(ans,sum);
            if (sum<0)
                 sum=0;
        }
        System.out.println(ans);
    }
}
