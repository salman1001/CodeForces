package com.company.graphsOnceAgain;

import java.util.Arrays;
import java.util.Scanner;

public class PrakA {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int[] arr={9,9};
        Arrays.sort(arr);
        int currLimit=1;
        int temp=1;
        int day=0;
        for (int i=0;i< arr.length;i++){

            if (temp<arr[i]){
                do {
                    temp+=currLimit;
                    day++;
                } while (temp<arr[i]);

                currLimit+=1;
                temp=currLimit;;

            }
            else {
                day++;
                currLimit+=1;
                temp=currLimit;
              //  System.out.print("day---"+ day+"   Temp---"+temp+"   ");
            }
        }
        System.out.println(day);




    }

}
