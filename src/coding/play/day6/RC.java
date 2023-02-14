package coding.play.day6;

import java.util.Scanner;

public class RC {
    static Scanner sc=new Scanner(System.in);
    static long[] fac=new long[1005];
    static long mod = 1000000007;

    public static void main(String[] args) {

     //   int tc= sc.nextInt();
       // for (int j=0;j<tc;j++){
            int n= sc.nextInt();int x=sc.nextInt();int pos= sc.nextInt();
            fac[0]=fac[1]=1l;
            for (int i=2;i<=n;i++){
                fac[i]=(i*fac[i-1])%mod;
            }
            int l=0,r=n;
            long less=x-1;
            long ans=1;
            long more=n-x;
            int count=n;
            while (l<r){
                int m=(l+r)/2;
                if (pos==m){
                    l=m+1;

                }
                else if (pos<m){
                    ans=(ans*more)%mod;
                    more--;
                    r=m;



                }
                else if (pos>m){
                    ans=(ans*less)%mod;
                    less--;
                    l=m+1;

                }
                count--;
            }
      //  System.out.println(ans);
      //  System.out.println(count);
        //System.out.println(fac[count]);
            if (count>0) ans=(ans*fac[ count])%mod;
            System.out.println(ans);

      //  }







    }
}
