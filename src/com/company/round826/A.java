package com.company.round826;

import java.util.Scanner;

public class A {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for (int i=0;i<tc;i++){
            String  s1= sc.next();
            String s2= sc.next();
            boolean ist=false;
            if (s1.charAt(s1.length()-1)==s2.charAt(s2.length()-1)){
                if (s1.charAt(s1.length()-1)=='S') ist=true;
//                else ist=false;
                if (s1.length()==s2.length()) System.out.println("=");
                else if(s1.length()>s2.length()) System.out.println(ist==true?"<":">");
                else System.out.println(ist==true?">":"<");
            }
            else {
                if (s1.charAt(s1.length()-1)-s2.charAt(s2.length()-1)>0) System.out.println("<");
                else System.out.println(">");

            }
        }

    }
}
