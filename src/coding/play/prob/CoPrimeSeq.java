package coding.play.prob;

import java.util.HashMap;
import java.util.Scanner;

public class CoPrimeSeq {
    static Scanner sc=new Scanner(System.in);
    static int mx=100000;
    static int mod=10000007;
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[100007];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int i=0;i<n;i++){
//            hashMap.put(i,0);
//        }
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            arr[i] = val;
            hashMap.put(val, hashMap.getOrDefault(val, 0) + 1);
        }
        //get with gcd of i will have its multiples so get its multiple first;
        int[] f = new int[100005];
        int[] g = new int[100005];
        for (int i = 1; i <= mx; i++) {
            long count = 0;
            for (int j = i; j <= mx; j += i) {
                count += hashMap.getOrDefault(arr[j], 0);
            }
            g[i] =(power(2,count,mod)-1)%mod;
            g[i]=(g[i]+mod)%mod;


        }


        // i have the multiple of i ...
        // now subtrsct rom it

        for (int i=mx;i>=1;i--) {
            f[i]=g[i];
            for (int j=2*i;j<=mx;j+=i){
                f[i]-=f[j];
                f[i]=(f[i]+mod)%mod;
            }

        }
        System.out.println(f[1]);

    }




        static int power(int x, long y, int p) {
            int res = 1;
            x = x % p;
            if (x == 0)
                return 0;

            while (y > 0)
            {
                if ((y & 1) != 0)
                    res = (res * x) % p;
                y = y >> 1; // y = y/2
                x = (x * x) % p;
            }
            return res;
        }


    }



