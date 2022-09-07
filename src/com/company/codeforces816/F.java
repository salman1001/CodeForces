package com.company.codeforces816;

import java.util.Scanner;

public class F {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        String st="1C0C1C1A0B1";
        int ans;
        if (st==null||st.length()==0)  ans=-1;
        char[] charar=st.toCharArray();
        ans=charar[0]-'0';

        for (int i=1;i<=st.length()-2;i+=2){

            switch (charar[i]) {
                case 'A' -> ans &= (charar[i + 1]-'0');
                case 'B' -> ans |= (charar[i + 1]-'0');
                case 'C' -> ans ^= (charar[i + 1]-'0');
            }


        }
        System.out.println(ans);


    }
}
