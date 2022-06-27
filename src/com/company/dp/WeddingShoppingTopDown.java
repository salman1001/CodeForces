package com.company.dp;

/*
Wedding Shopping. The abridged problem statement: Given different options for
each garment (e.g. 3 shirt models, 2 belt models, 4 shoe models, . . . ) and a certain limited
budget, our task is to buy one model of each garment. We cannot spend more money than
the given budget, but we want to spend the maximum possible amount.

Suppose we have the following test case A with M = 20, C = 3:
Price of the 3 models of garment g=0 → 648 // the prices are not sorted in the input
Price of the 2 models of garment g=1 → 5 10
Price of the 4 models of garment g=2 → 1 535
*/
import java.util.Scanner;
public class WeddingShoppingTopDown{
    private static int M,C,K;
    private static int[][] price = new int[25][25]; // price[g (<= 20)][model (<= 20)]
    private static int[][] memo = new int[210][25]; // dp table memo[money (<= 200)][g (<= 20)]
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,j,TC,score;
        TC=sc.nextInt();
        while (TC-->0){
            M=sc.nextInt();
            C=sc.nextInt();
            for (i=0;i<C;i++){
                K=sc.nextInt();
                price[i][0]=K;
                for ( j=1;j<=K;j++)
                    price[i][j]=sc.nextInt();
            }
            for (i = 0; i < 210; i++)
                for (j = 0; j < 25; j++)
                    memo[i][j] = -1; // initialize DP memo table

            score=shop(M,0);
            if (score < 0) System.out.printf("no solution\n");
            else           System.out.printf("%d\n", score);
        }
    }
    private static int shop(int money, int g) {
        if (money<0) return -1000000000;
        if (g==C) return M-money;
        if (memo[money][g]!=-1) return memo[money][g];
        int ans=-1000000000;
        for (int model=1;model<=price[g][0];model++){
            ans=Math.max(ans,shop(money-price[g][model],g+1));

        }
        return memo[money][g]=ans;
    }
}
