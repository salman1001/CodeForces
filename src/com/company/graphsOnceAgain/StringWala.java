package com.company.graphsOnceAgain;
import java.util.ArrayList;
import java.util.Scanner;
public class StringWala {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str= sc.nextLine();
        int k= sc.nextInt();
        char[] chars=new char[str.length()];
        for (int i=0;i<str.length();i++){
            chars[i]='?';
        }
       // ArrayList<Integer> arr=new ArrayList<>();
        int[] arr2=new int[26];
       // for (int i=0;i<str.length();i++) arr.add(0);

        boolean isPoss=true;
        for (int i=0;i<str.length();i++) {
            int temp1=str.charAt(i)-'a';
            int to=arr2[temp1];
            to++;
            arr2[temp1]=to;
            //int temp=arr.get(temp1);temp++;arr.add(temp1,temp);
            //arr.get(temp1)=arr.get(temp1)+1;

        }
        for (int i=0;i<arr2.length;i++){
            for (int j=0;j<arr2[i];j++){
                int i1 = (j * k) % str.length();
              //  if (chars[i1]=='?'||chars[i1]==(char) (i+'a')){
               // System.out.print(i+" ");
                    chars[i1]=(char) ((i +'a'));
                System.out.print(chars[i]+" ");
              // System.out.print((char) ((i +'a'))+" ");
              //  }
              //  else {
                  //  System.out.print(chars[i1]+"   "+i+"   "  );
                //    isPoss=false;
               // }
            }
        }
        StringBuilder st=new StringBuilder();
        for (int i=0;i<str.length();i++){
             st.append(chars[i]);
        }
        //System.out.println();
       // System.out.println(isPoss?st.toString():-1);
    }
}