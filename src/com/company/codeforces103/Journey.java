package com.company.codeforces103;

import java.util.Scanner;

public class Journey {
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
                for (int i=0;i<str.length();i++){
                    boolean what= ((i % 2) ^ it) == 1;
                    char weWant=what?'R':'L';
                    if (str.charAt(i)==weWant){
                        jumps++;
                    }
                    else {
                        jumps=0;
                    }
                    if (it==i%2){
                        a[i+1]=jumps;

                    }
                }
                jumps=0;
                int pp=(size-1)%2;
                for (int i=str.length()-1;i>=0;i--){
                    boolean what= ((i % 2==pp?0:1) ^ it) == 1;
                    char weWant=what?'R':'L';
                    if (str.charAt(i)==weWant){
                        jumps++;
                    }
                    else {
                        jumps=0;
                    }

                    if ((i%2==pp?0:1)!=it){
                        b[i]=jumps;

                    }
                }
            }
            for (int i=0;i<size+1;i++){
                System.out.print(a[i]+b[i]+1+" ");
            }
            System.out.println();


        }



    }
}
