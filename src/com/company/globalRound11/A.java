package com.company.globalRound11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class A {
    static long mod=1000000007L;
    static int nax=1000009;
    static Scanner sc=new Scanner(System.in);
    static int[] fac=new int[nax];
    static ArrayList<Pair> list=new ArrayList<>();
    static int[] inFac=new int[nax];
    static class Pair implements Comparable<Pair>{
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.x==this.x){
               return this.y-o.y;
            }
            else return this.x-o.x;
        }
    }
    public static void main(String[] args) {
        fac[0]=inFac[0]=1;
        for (int i=1;i<nax;i++){
            fac[i]=mul(fac[i-1],i);
            inFac[i]=myInv(fac[i]);
        }

        int h= sc.nextInt();int w= sc.nextInt();int n= sc.nextInt();
        int[] dp=new int[n+1];
        for (int i=0;i<n;i++){
            int x= sc.nextInt();int y=sc.nextInt();
            list.add(new Pair(x,y));
        }
        list.add(new Pair(h,w));
        Collections.sort(list);
       // for (int i=0;i<list.size();i++) System.out.print(list.get(i).y+" ");

        for (int i=0;i<=n;i++){
            int tmp= (int) f(list.get(i).x-1,list.get(i).y-1);
            for (int j=0;j<i;j++){
                if (list.get(j).x<=list.get(i).x&&list.get(j).y<=list.get(i).y){
                    tmp=sub(tmp,mul(dp[j],f(list.get(i).x-list.get(j).x,list.get(i).y-list.get(j).y)));
                }


            }
            dp[i]=tmp;
        }
        System.out.println(dp[n]);




    }

     static int sub(int tmp, int mul) {
        return (int) ((tmp-mul+mod)%mod);
    }

    static int mul(long a, long b){
         return (int) ((a*b)%mod);
    }
    static long f(int a,int b){
        return binomial(a+b,b);
    }

    static int binomial(int a,int b){
        if (a<0||b<0||b>a) return 0;
        return mul(fac[a],mul(inFac[b],inFac[a-b]));
    }
    static int pow(int a,int b){
        int r=1;
        while (b>=1){
            if (b%2==1) r=mul(r,a);
            a=mul(a,a);
            b/=2;
        }
        return r;
    }
    static int myInv(int a){
        return pow(a, (int) (mod-2));
    }



}
