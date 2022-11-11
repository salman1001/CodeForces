package com.company.codeforces103;

class SortedArray {
    public static void main(String[] args) {
        int []a={2};
        int[] b={};
        System.out.println(fppppindMedipppanSortedArrays(a,b));
    }
   static public double fppppindMedipppanSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int low=0;

        int high =n1;
        while(high>=low){
            int c1=(low+high)/2;
            int  c2=(n1+n2+1)/2-c1;
            int left1=(c1==0?Integer.MIN_VALUE:nums1[c1-1]);
            int left2=(c2==0 ?Integer.MIN_VALUE:nums2[c2-1]);
            int right1=(c1==n1?Integer.MAX_VALUE:nums1[c1]);
            int right2=(c2==n2?Integer.MAX_VALUE:nums2[c2]);

            if(left1<=right2&&left2<=right1){
                if((n1+n2)%2==0){
                    return (Math.max(left1,left2)+Math.min(right1,right2))/2.0D;
                }
                else{
                    return Math.max(left1,left2);
                }

            }else if(left1>right2){
                high=c1-1;

            }
            else{
                low=c1+1;

            }

        }
        return 0.0D;

    }
}
