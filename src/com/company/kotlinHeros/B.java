package com.company.kotlinHeros;

import java.util.Scanner;

public class B {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        long ans=0;
        long open=0;
        long close=0;
        int n=sc.nextInt();int k= sc.nextInt();
        String str= sc.next();
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)=='(') open++;
            else {
                close++;
                if (open==close){
                    System.out.println(k+" "+open);
                    k-=open;
                    if (k<=0){
                        ans+=(k<0?k+2:k+1);
//                        if (k<0){
//                            ans+=k+2;
//                        }
//                        else {
//                            ans+=k+1;
//                        }
                        break;
                    }
                    else {
                        ans+=open;
                        open=0;
                        close=0;
                    }
                }
            }
        }
      //  System.out.println(ans);


    }
}
