package com.company.codeforces103;

import java.util.Scanner;

public class EPatternMatching {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for (int j=0;j<tc;j++){
            int size= sc.nextInt();

            int[] a=new int[size+1];
            int[] b=new int[size+1];
            String str= sc.next();
            for (int it=0;it<2;it++){
                int jumps=0;
                // I am looking for 0 that is i am just going left right now
                for (int i=0;i<str.length();i++){
                    boolean whatDoneed=((i%2)^it)==1;
                    char whichCharDoweNeed=whatDoneed?'R':'L';
                    if (str.charAt(i)==whichCharDoweNeed) {
                        jumps++;
                    }
                    else {
                        jumps=0;
                    }
                    if (it==(i%2)) a[i+1]=jumps;

                }

            }
            for (int i=0;i<size+1;i++){
                System.out.print(a[i]+b[i]+1+" ");
            }
            System.out.println();


        }



    }
}
