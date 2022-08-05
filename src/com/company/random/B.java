package com.company.random;

public class B {
    public static void main(String[] args) {
        int[] array={4,4,4};
        // find max and min prefix
        // find max and min suffix
        // join alternatively
        int minPre=array[0];
        int maxPre=array[0];
        int minSuff=array[0];
        int maxSuff=array[0];
        int tempForPre=array[0];
        int tempForSuff=array[0];
        for (int i=0;i< array.length;i++){
            tempForPre^=array[i];
            if (tempForPre<minPre) minPre=tempForPre;
            if (tempForPre>maxPre) maxPre=tempForPre;
        }
        for (int i=array.length-1;i>=0;i--){
            tempForSuff^=array[i];
            if (tempForSuff<minSuff) minSuff=tempForSuff;
            if (tempForSuff>maxSuff) maxSuff=tempForSuff;
        }
        int max=array[0];
        max=Math.max(minPre^maxSuff,max);
        max=Math.max(maxPre^minSuff,max);
        System.out.println(max);




    }
}
