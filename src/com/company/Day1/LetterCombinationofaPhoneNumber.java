package com.company.Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombinationofaPhoneNumber {
    static Scanner sc=new Scanner(System.in);
     static List<String> finalString=new ArrayList<>();
    public static void main(String[] args){
        String str1=sc.next();
        String[] str=new String[4];
        for (int i=0;i<str.length;i++) str[i]="";
        for(int i=0;i<str1.length();i++){
            switch(str1.charAt(i)){
                case '1':str[i]="";break;
                case '2':str[i]="abc";break;
                case '3'   :str[i]="def";break;
                case  '4' :str[i]="ghi";break;
                case '5'   :str[i]="jkl";break;
                case '6'   :str[i]="mno";break;
                case '7'   :str[i]="pqrs";break;
                case '8'  :str[i]="tuv";break;
                case '9'  :str[i]="wxyz";break;
            }
        }

        recursive(str,0,"");
       // for (int i=0;i<finalString.size();i++) System.out.print(finalString.get(i)+" ");
      //  System.out.println();




    }

    private static void recursive(String[] strArray, int curIndex, String currString) {

        if (curIndex==strArray.length){
            System.out.println("called");
            finalString.add(currString);

        }
        else {
            for (int i=0;i<strArray[curIndex].length();i++){
                System.out.println("called   "+curIndex);

                recursive(strArray,curIndex+1,currString+strArray[curIndex].charAt(i));
            }
        }

    }

}
