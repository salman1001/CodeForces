package coding.play.day6;

import java.util.Scanner;

public class RB {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int tc= sc.nextInt();
        for (int j=0;j<tc;j++){
            int  n=sc.nextInt();
            int[][] mat=new int[n][n];
            for (int i=0;i<n;i++){
                for (int k=0;k<n;k++){
                    if (k+1<n&&(k==i)){
                        mat[i][k]=1;
                        mat[i][k+1]=12;
                        k++;
                    }
                    else mat[i][k]=0;

                }

            }
            mat[n-1][n-1]=1;
            mat[n-1][0]=12;
            for (int i=0;i<n;i++){
                for (int k=0;k<n;k++) {
                    System.out.print(mat[i][k]+" ");
                }
                System.out.println();
                }

        }


    }
}
