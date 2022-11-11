package com.company.round725;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Scanner;

public class D {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for (int i=0;i<tc;i++){
            long a= sc.nextLong(), b= sc.nextLong(),k= sc.nextLong();
            if (k==1){
                System.out.println(((b%a==0||a%b==0)&&a!=b)?"YES":"NO");
                continue;
            }
            ArrayList<Integer> arr=getFactors((int) a);
            ArrayList<Integer> arr1=getFactors((int)b);
            System.out.println((arr.size()+arr1.size()>=k?"YES":"NO"));


        }

    }
    static ArrayList<Integer> getFactors (int num) {
        ArrayList<Integer> arr=new ArrayList<>();
        int i;
        boolean flag = false;
        for(i = 1; i <= Math.sqrt(num); i++)
        {
            if (num % i == 0)
                arr.add(i);


            if(i == num/i)
                flag = true;
        }
        if(flag)
            i -= 2;
        for(; i >= 1; i--)
        {
            if (num % i == 0) arr.add(num/i);
        }
        return arr;
    }

}
