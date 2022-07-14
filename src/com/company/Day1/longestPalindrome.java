package com.company.Day1;

public class longestPalindrome {
    public static void main(String[] args) {
        System.out.println(maxLengthPalindrome("abcdefghighaaabbbbaaa"));

    }
    public static String maxLengthPalindrome(String str){
        String strTo="";
        for (int i=0;i<str.length();i++){
           int low=i;
           int high=i;
           while (low>=0&&high<str.length()&&str.charAt(low)==str.charAt(high)){
               if (strTo.length()<high-low+1){
                   strTo=str.substring(low,high+1);
               }
               if(!(str.charAt(low)==str.charAt(high))) break;
               low--;high++;
           }
           low=i;
           high=i+1;
            while(low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)){
                if(strTo.length() < high-low+1){
                    strTo = str.substring(low, high+1);
                }
                if(!(str.charAt(low)==str.charAt(high))) break;
                low--;
                high++;
            }
        }
        return strTo;

    }
}
