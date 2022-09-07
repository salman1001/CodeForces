package com.company.div3_674;

import java.util.*;
public class F{
    static Scanner sc=new Scanner(System.in);
    static final long mod=1000000007;
    public static void main(String args[]){
        int n=sc.nextInt();
        String str=sc.next();
        long ca=0;
        long cab=0;
        long cabc=0;
        long stringll=1;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='a') ca= (ca+stringll)%mod;
            else if((str.charAt(i)=='b')) cab=(cab+ca)%mod;
            else if((str.charAt(i)=='c')) cabc= (cabc+cab)%mod;
            else{
                cabc= (3*cabc+cab)%mod;
                cab=(3*cab+ca)%mod;
                ca= (3*ca+stringll)%mod;
                stringll=(3*stringll)%mod;
            }
        }
        System.out.println(cabc%mod);



    }
}