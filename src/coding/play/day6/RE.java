package coding.play.day6;

import java.util.Scanner;

public class RE {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc=sc.nextInt();
        for (int i=0;i<tc;i++){
            int n= sc.nextInt();
            int[] arr=new int[n];
            boolean isposs=true;
            for (int j=0;j<n;j++){
                arr[j]= sc.nextInt()%2;
                if (j>0&&arr[j-1]==arr[j]) isposs=false;
            }
            System.out.println(isposs?"YES":"NO");




        }




    }
}
