package com.company.csesGeometry;

public class Shu {
    public static void main(String[] args) {
        // i have n so i will how much i can get
        int n=4;int k=3;int temp=n;int limit=15;
        int max=factorial(n);
        while (max>limit){
            temp--;
            max=factorial(temp);
        }

        int ans=0;
        for (int i=1;i<=k;i++){
            for (int j=1;j<=temp;j++)
            if ( Math.pow(factorial(j),i)<=k) {
                ans++;
            }
            else break;


        }
        System.out.println(ans);

    }
   static int factorial(int n) {

       return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
   }


}
