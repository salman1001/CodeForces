package com.company.Day1;

import java.util.ArrayList;

public class EulerTour {
    public static void main(String[] args) {

    }
    static class Node{
        int pre,post;
        ArrayList<Node> adj=new ArrayList<>();
        public int dfs(Node from,int counter){
            this.pre=counter;
            for (Node nn:adj){
                if (nn==from) continue;
                counter=nn.dfs(this,counter+1);
            }
            return post=counter;
        }

    }
    static class BIT{
        int n;
        double[] tree;
        public BIT(int n){
            this.n=n;
            tree=new double[n+2];
        }
        double read(int i){
            i++;
            double sum=0;
            while (i>0){
                sum+=tree[i];
                i-=i&-i;
            }
            return sum;
        }
        void update(int i, double val) {
            i++;
            while (i <= n) {
                tree[i] += val;
                i += i & -i;
            }
        }

        double rangeSum(int from, int to) {
            return read(to)-read(from-1);
        }
    }

}
