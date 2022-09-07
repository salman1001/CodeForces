package com.company.round701;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class F {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int[][] arr={
                {1,3},{2,6},{8,10},{15,18}
        };
        int[][] ret=merge(arr);
        for (int i=0;i<ret.length;i++){
            for (int j=0;j<ret[0].length;j++){
                System.out.print(ret[i][j]+" ");
            }
            System.out.println();
        }


    }
 static    public int[][] merge(int[][] in) {
        int a=in.length;
        int[] arrx=new int[a];
        int[] arry=new int[a];
        for (int i=0;i< in.length;i++){
            arrx[i]= in[i][0];
            arry[i]= in[i][1];

        }
        Arrays.sort(arrx);Arrays.sort(arry);
        int xt=0;int y=0;int x=0;
        ArrayList<int[]> res=new ArrayList<>();
        while(x<=a){
            while(xt<a-1&&arry[y]>=arrx[++xt]){
                System.out.println("Called "+arry[y]+" " +arrx[xt]);
            }

            res.add(new int[]{arrx[x],arry[--xt]});
            x=xt;
            y=xt;

        }
        return res.toArray(new int[0][]);



    }
}
