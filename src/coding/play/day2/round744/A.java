package coding.play.day2.round744;

import java.util.Scanner;

public class A {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc=sc.nextInt();
        String s=sc.next();
        int a=0,b=0,c=0;
        for (int i=0;i<s.length();i++){
            switch (s.charAt(i)) {
                case 'A' -> a++;
                case 'B' -> b++;
                case 'C' -> c++;
            }

        }
        if (a+c==2*b) System.out.println("YES");
        else System.out.println("NO");


    }

}
