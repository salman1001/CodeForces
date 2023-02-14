package coding.play.day5.round701;

import java.util.Scanner;

public class A {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc=sc.nextInt();

     for (int k=0;k<tc;k++){
         System.out.println("1");
            long a=sc.nextLong();
            long b= sc.nextLong();

            int ans= (int) 10e9;
            for (long i=b;i<=a;i++){
                System.out.println("2");

                int thi=0;
                long g=a;
                while (g > 0) {
                    g/=i;
                    thi++;
                }
                thi+=i-b;
                ans=Math.min(thi,ans);


                if (thi>ans){
                    break ;
                }

            }
            if (b>a) ans=1;
         System.out.println("3");

          //  System.out.println(ans);

        }





    }
}
