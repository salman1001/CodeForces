package coding.play.round697;

import java.util.Scanner;

public class B {
    static Scanner sc=new Scanner(System.in);
    static boolean[] pos=new boolean[1100000];
    public static void main(String[] args) {
        int tc= sc.nextInt();
        pos[0]=true;
        for (int i=0;i<1000005;i++){
            pos[i+2020]|=pos[i];
            pos[i+2021]|=pos[i];

        }
        for (int i=0;i<tc;i++){
            int n= sc.nextInt();
            if (pos[n]) System.out.println("YES");
            else System.out.println("NO");



        }



    }
}
