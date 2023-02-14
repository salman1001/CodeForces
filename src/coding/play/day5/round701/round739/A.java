package coding.play.day5.round701.round739;

import java.util.Scanner;

public class A {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for (int i=0;i<tc;i++){
            int k=sc.nextInt();
            for (int j=1;j<10000;j++){
                if (j%10!=3&&j%3!=0){
                    k--;
                    if (k==0) {
                        System.out.println(j);
                        continue;
                    }
                }
            }
        }

    }
}
