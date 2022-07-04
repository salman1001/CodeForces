package com.company.Day1;

import java.util.*;

public class DiameterOfTheTree {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int  n= sc.nextInt();
        Node[] nodes=new Node[n];
        for (int i=0;i<n;i++) nodes[i]=new Node();
        for (int i=0;i<n-1;i++){
            int a= sc.nextInt();
            int b= sc.nextInt();
            a--;b--;
            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);


        }
        bfs(nodes[0],nodes);
        Node mostFar=far(nodes);
        bfs(mostFar,nodes);
        System.out.println(3*far(nodes).dist);

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

    static class Node {
        ArrayList<Node> adj=new ArrayList<>();
        int dist;

    }
}
