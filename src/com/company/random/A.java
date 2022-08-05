package com.company.random;

import java.util.ArrayList;

public class A {
    public static void main(String[] args) {
        String [] strings={"a","b","c","dd","daad","ebcbe"};
        ArrayList<Integer> stringsCountPalin=new ArrayList();
       for (int i=0;i<strings.length;i++){
           stringsCountPalin.add(longestPalSubstr(strings[i]));
       }
       StringBuilder stringBuilder=new StringBuilder();
       for (int i=0;i<stringsCountPalin.size();i++) stringBuilder.append(stringsCountPalin.get(i));
       int count=longestPalSubstr(stringBuilder.toString());
        System.out.println(strings.length-count);
    }

    static int longestPalSubstr(String str)
    {

        int n = str.length();
        int maxLength = 1, start = 0;
        for(int i = 0; i < str.length(); i++)
        {
            for(int j = i; j < str.length(); j++)
            {
                int flag = 1;
                for(int k = 0;
                    k < (j - i + 1) / 2; k++)
                    if (str.charAt(i + k) !=
                            str.charAt(j - k))
                        flag = 0;
                if (flag != 0 &&
                        (j - i + 1) > maxLength)
                {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return maxLength;
    }
}
