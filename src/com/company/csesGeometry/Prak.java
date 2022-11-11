package com.company.csesGeometry;

public class Prak {
    public static void main(String[] args) {
        int n=1;
        n=n%14;
        int[] cells={1,0,0,0,0,1,0,0};
        if (n==0) n+=14;
        int[] ans=new int[10];
        ans[0]=0;ans[8]=0;
        for (int i=0;i<cells.length-1;i++) ans[i+1]=cells[i];

        for (int i=n;i>=0;i--){

            for (int j=1;j<7;j++){
                if (ans[j-1]==ans[j+1]) ans[j]=0;
                else ans[j]=1;

            }
        }
        for (int i=1;i<9;i++) System.out.print(ans[i]+" ");
    }
}
