package com.company.stack;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class LongestValidParentheses {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        String s=sc.next();
        Stack<Character> stack=new Stack<>();
        int place=-1;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)=='(') {
                place=i;break;
            }

        }
        if (place!=-1){
            stack.push(s.charAt(place));
        }
       // else return 0;




        while (!stack.isEmpty()){


        }








        int recentMax=0;
        int globalMax=0;
        int index=-1;

        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c=='(') stack.push(c);

            else {
                if (!stack.empty()&&stack.pop()=='('){
                  //  if
                    recentMax+=2;
                    index=i;
                    globalMax=Math.max(recentMax,globalMax);
                    if (i<s.length()-1&&s.charAt(i+1)!=')') {
                        recentMax=0;
                    }
                }
                else {
                    recentMax=0;
                }

            }
        }
        //System.out.println((globalMax));
      ;

    }

}
