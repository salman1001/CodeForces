package com.company.Day1;

import com.company.codeforces.contest782.A;

import java.util.ArrayList;
import java.util.Scanner;

public class TreeBasicsSlothTwo {
    public static void main(String[] args) {
        Scanner fs=new Scanner(System.in);
        int n=fs.nextInt();
        Node[] nodes=new Node[n];
        for (int i=0; i<n; i++) nodes[i]=new Node(i+1);
        for (int i=1; i<n; i++) {
            int a=fs.nextInt()-1, b=fs.nextInt()-1;
            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
        }
        nodes[0].dfs(null,0);
        for (int i=1;i<20;i++){
            for (Node ee:nodes) {
                if (ee.lift[i-1]!=null){
                    ee.lift[i]=ee.lift[i-1].lift[i-1];
                }
            }
        }

    }
     static class  Node{
        ArrayList<Node> adj=new ArrayList<>();
        int depth,id;
        Node[] lift=new Node[20];
        public Node(int id){
            this.id=id;
        }
        public void dfs(Node par,int depth){
            this.depth=depth;
            lift[0]=par;
            for (int i=0;i<adj.size();i++){
                if (adj.get(i)!=par){
                    adj.get(i).dfs(this,depth+1);

                }
            }



        }
        public Node goUp(int noOfSteps){
            if (noOfSteps==0) return this;
            return lift[Integer.numberOfTrailingZeros(noOfSteps)].goUp(noOfSteps-Integer.lowestOneBit(noOfSteps));
        }
        public Node lca(Node o,int nJmps){
            if (this==o) return this;
            if (depth!=o.depth){
                if (depth>o.depth)  return goUp(depth-o.depth).lca(o,19);
                return lca(o.goUp(o.depth-depth),19);
            }
            if (lift[0]==o.lift[0]) return lift[0];
            while (lift[nJmps]==o.lift[nJmps]) nJmps--;
            return lift[nJmps].lca(o.lift[nJmps],nJmps);

        }

    }
}
