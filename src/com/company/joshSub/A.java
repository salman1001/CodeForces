package com.company.joshSub;

import java.util.Scanner;

public class A {
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        int tc=scanner.nextInt();
        for (int i=0;i<tc;i++){
            int n= scanner.nextInt();
            int  s= scanner.nextInt();
            String str=String.valueOf(s);
            int temp=n;
            int razeEven=0;int razeOdd=0;int breachOdd=0;int breachEven=0;
            for (int j=0;j<n;j++){
                var i1 = (int) str.charAt(j) % 2;
                if (j%2==0){
                    if (i1 ==0) breachEven++;
                    else breachOdd++;
                }
                else {
                    if (i1 ==0) razeEven++;
                    else razeOdd++;
                }
            }
            if (n%2==0){
           //  if (n/2==)

            }
            else {

            }
        }


    }
}
