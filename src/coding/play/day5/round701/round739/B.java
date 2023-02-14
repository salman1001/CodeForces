package coding.play.day5.round701.round739;

import java.util.ArrayList;
import java.util.Scanner;

public class B {
    static Scanner sc=new Scanner(System.in);
    static ArrayList<Integer> primeList=new ArrayList<>();
    static long[] fact=new long[100000];
    static long[] infac=new long[100000];
    static long mod=100000007;
    static int[] location=new int[75];

    public static void main(String[] args) {
        // we will need ncr
        // lets get factorial and inverse factorial for the same
        //we will try to convert a number in the form of primefactors
        //36----->>>>2*2*3*3----->>>>>2^2*3^3
        //and make the number in the form of binary number
        //like if prime factor of a number has even no will form 0 else 1
        //36---->>>>>>000000000
        //will make a dp ....dp[i][j]--->>no of ways
        // to take 1...i such that xor is 0;
        //dp[0][0]---1
        int n=sc.nextInt();
        getAPrimes(100);
        fact[0]=fact[1]=infac[0]= infac[1]=1;
        for (int i=2;i<=n;i++){
            fact[i]=(i*fact[i-1]%mod);
        }

        infac[n]=modInverse(fact[n],mod);
        for (int i=n-1;i>=2;i--){
            infac[i]=((i+1)*infac[i+1])%mod;
        }
        int count=0;
        for (int a:primeList){
            if (a>70) break;
            location[a]=count;
            count++;
        }




















    }

    private static void getAPrimes(int maxN) {
        boolean prime[] = new boolean[maxN + 1];
        for (int i = 0; i <= maxN; i++)
            prime[i] = true;

        for (int p = 2; p * p <= maxN; p++) {
            if (prime[p] == true) {
                primeList.add(p);

                for (int i = p * p; i <= maxN; i += p)
                    prime[i] = false;
            }
        }
    }
    static long modInverse(long A, long M)
    {
        long m0 = M;
        long y = 0;
        long x = 1;

        if (M == 1)
            return 0;

        while (A > 1) {
            // q is quotient
            long q = A / M;

            long t = M;

            // m is remainder now, process
            // same as Euclid's algo
            M = A % M;
            A = t;
            t = y;

            // Update x and y
            y = x - q * y;
            x = t;
        }

        // Make x positive
        if (x < 0)
            x += m0;

        return x;
    }
    static long ncr(int n,int r){
        long aa=(infac[r]*infac[n-r])%mod;
        return (fact[n]*aa)%mod;
    }
}
