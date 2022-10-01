package com.company.csesGeometry;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BurnBinaryTree {
    static class Node {
        ArrayList<Node> adj=new ArrayList<>();
        int dist;
        boolean diam=false;

    }

    public static void main(String[] args) {

    }
    private  static Node far(Node[] nodes) {
        Node M=nodes[0];
        for (Node nn:nodes) if (nn.dist> M.dist) M=nn;
        return M;


    }

    private static void bfs(Node from, Node[] nodes) {
        for (Node nn:nodes) nn.dist=-1;
        from.dist=0;
        Queue<Node> myqueue=new LinkedList<>();
        myqueue.add(from);
        while (!myqueue.isEmpty()){
            Node next=myqueue.poll();
            for (Node nnn:next.adj){
                if (nnn.dist==-1){
                    nnn.dist=next.dist+1;
                    //  System.out.print(nnn.dist+"  ");

                    myqueue.add(nnn);
                }
            }
        }

    }



}
