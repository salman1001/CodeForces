package coding.play.round696;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B {
    static Scanner sc=new Scanner(System.in);
    static ArrayList<Integer> primeList=new ArrayList<>();
    public static void main(String[] args) {
        int tc=sc.nextInt();
        genPrime();
        //for (Integer i:primeList) System.out.println(i);
        for (int i=0;i<tc;i++){
            int d=sc.nextInt();
            int start=1; int counter=0;
            long ans=start;
            for (Integer j:primeList){
                if (j-start>=d){
                    ans*=j;
                    counter++;
                    start=j;
                    if (counter==2) break;

                }
            }
            System.out.println(ans);

        }


    }

    private static void genPrime() {
        boolean[] isprime=new boolean[1000009];
        Arrays.fill(isprime,true);
        for (int i=2;i*i<=1000006;i++){
            if (isprime[i]){
                for (int j=i*i;j<=1000006;j+=i){
                    isprime[j]=false;
                }
            }
        }
        for (int i=2;i<1000006;i++){
            if (isprime[i]) primeList.add(i);
        }

    }
}
