package com.company.round725;

import java.util.Scanner;

public class G {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for (int i=0;i<tc;i++){
            long x= sc.nextInt(),y= sc.nextInt(),a= sc.nextInt(),b= sc.nextInt();
            if (a>b){
                long temp=a;
                a=b;
                b=temp;

            }
            long l=0L;
            long r= (long) 10e+7;
            while (l<r){
                long m=(l+r)/2;
                long xx=x;
                long yy=y;
                xx-=a*m;
                yy-=a*m;
                boolean ispos=xx>=0&&yy>=0;
                if (b>a) if (xx/(b-a)+yy/(b-a)<m)ispos=false;
                if (ispos) l=m+1;
                else r=m;
            }
            System.out.println(l-1);


        }

    }
}
