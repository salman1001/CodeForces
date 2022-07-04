package com.company.graphsOnceAgain;

import java.util.Arrays;
import java.util.Scanner;

public class PrakA {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int[] arr={9,9};
        Arrays.sort(arr);
        int  day=0;int cur=1;
        for (int i=0;i<arr.length;i++){
            day+=arr[i]/cur;cur++;
        }
        System.out.println(day+1);





    }

}
