package com.company.div_808;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[]={1,2,4,7,8};
        System.out.println(  minimumTimeRequired(arr,2));
    }
     static public int minimumTimeRequired(int[] jobs, int k) {
        int left=jobs[0];
        int right=0;
        for(int i=0;i<jobs.length;i++){
            left=Math.max(left,jobs[i]);
            right+=jobs[i];
        }
         System.out.println(left+" "+right);
        while(left<right){
            System.out.println("Called "+ left+"  "+right);
            int mid=left+right/2;
            if(isPoss(jobs,mid,k)){
                left=mid;

            }
            else{
                right=mid-1;
            }

        }
        return left;
    }
    static boolean isPoss(int[] jobs,int limit,int k){
        int counter=1;
        int curSum=0;
        for(int i=0;i<jobs.length;i++){
            if(curSum+jobs[i]>=limit){
                curSum=0;
                counter++;
            }
            else curSum+=jobs[i];

        }
        if(counter>=k) return true;
        else return false;



    }
}
