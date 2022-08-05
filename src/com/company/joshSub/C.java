package com.company.joshSub;

import java.io.PrintWriter;
import java.util.Scanner;

public class C {
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[][] dp = new long[k+1][n+ 1];
        dp[0][1] = 1;
        long mod = 1000000007;
        PrintWriter printWriter=new PrintWriter(System.out);
        for (int i=0;i<k;i++){
        for (int j = 1; j <= n; j++) {
            for (int v = j; v <= n; v+=j) {
              // printWriter.println("Changing value of  "+(i+1)+" "+v+"  from "+i+"  "+j);
                dp[i+1][v] = (dp[i+1][v] + dp[i][j]) % mod;
            }
        }
    }
        long ans=0;
        for (int i=1;i<=n;i++) {
            System.out.println( ans +"    "+(dp[k][i]));
            ans=(ans+dp[k][i])%mod;
        }
        //System.out.println(ans);
      //  printWriter.close();

    }
}
