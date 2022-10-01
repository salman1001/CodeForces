package com.company.binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Traversal {
    public static void main(String[] args) {
        Node node=new Node();
        Node left=new Node(); left.data=2;
        Node right=new Node(); right.data=3;

        node.data=1;node.left=left;node.right=right;
        node.left.left=new Node(4);
        node.left.left.right=new Node(5);
//        Node left1=new Node(); left1.data=4;
//        Node right1=new Node(); right1.data=5;
//
//        Node left2=new Node(); left2.data=6;
//        Node right2=new Node(); right2.data=7;
//
//        left.left=left1;
//        left.right=right1;
//        right.left=left2;
//        right.right=right2;

      //  levelOrder(node);
       // preOrder(node);
       // System.out.println();
       // iterativePreOrder(node);
        inOrder(node);


    }

    static void postOrder(Node node){
        if (node==null) return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.data+" ");

    }
    static void inOrder(Node node){
        if (node==null) return;
        preOrder(node.left);
        System.out.print(node.data+" ");
        preOrder(node.right);

    }
    /*

            1
         2      3
       4   5  6   7

       2451367

     */
    static void preOrder(Node node){
        if (node==null) return;
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);

    }
    static void levelOrder(Node node){
        int height=0;
        Deque<Node> deque=new ArrayDeque<>();
        deque.add(node);
        while (!deque.isEmpty()){
            height++;
            for (int i=0;i<deque.size();i++){
                Node node1=deque.removeFirst();
                if (node1.left!=null) deque.add(node1.left);
                if (node1.right!=null) deque.add(node1.right);
            }
//            Node node1=deque.removeFirst();
//           // System.out.print(node1.data+" ");
//            if (node1.left!=null) {
//
//                deque.add(node1.left);
//            }
//            if (node1.right!=null) {
//
//                deque.add(node1.right);
//            }
//            if (deque.size()==0) System.out.println("Your Height is "+node1.height);
        }
    }
    static void iterativePreOrder(Node node){
        //  Node....Left....Right
        Deque<Node> deque=new ArrayDeque<>();
        deque.add(node);
        while (!deque.isEmpty()){
            Node node1=deque.removeFirst();
            System.out.print(node1.data+" ");
            if (node1.right!=null) deque.addFirst(node1.right);
            if (node1.left!=null) deque.addFirst(node1.left);
        }


    }
    static void iterativePostOrder(Node node){
        //  Left....Right.....
        Deque<Node> deque=new ArrayDeque<>();
        deque.add(node);
        while (!deque.isEmpty()){
            Node node1=deque.removeFirst();
            System.out.print(node1.data+" ");
            if (node1.right!=null) deque.addFirst(node1.right);
            if (node1.left!=null) deque.addFirst(node1.left);
        }


    }

    static void iterativeInOrder(Node node){
        //  Left........ Node........Right
        Deque<Node> deque=new ArrayDeque<>();
        while (true){
            if (node!=null) {
                deque.addFirst(node);
                node=node.left;
            }
            else {
                if (deque.isEmpty()) break;
                node=deque.removeFirst();

            }
//            System.out.print(node1.data+" ");
//            if (node1.right!=null) deque.addFirst(node1.right);
//            if (node1.left!=null) deque.addFirst(node1.left);
        }


    }
    static class Node{
        int data=-1;
        Node left=null;
        Node right=null;

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }
    }


    static void morrisTraversaPreorder(){
        Node root=new Node(3);
        Node cur=root;
        while(cur!=null){
            if (cur.left!=null){
                Node pre=cur.left;
                while (pre.right!=null&pre.right!=cur) pre=pre.right;
                if (pre.right==null){
                    pre.right=cur;
                    cur=cur.left;
                }
                else {
                    pre.right=null;
                    System.out.println(cur.data+" ");
                    cur=cur.right;
                }



            }
            else {
                System.out.print(cur.data+" ");
                cur=cur.right;
            }



        }
    }


    static void  flattenBinaryToLinkedList(){
        Node root=new Node(6);
        Node cur=root;
        while (cur!=null ){
            if (cur.left!=null){
                Node pred= cur.left;
                while (pred.right!=null) pred=pred.right;
                pred.right=cur.right;
                cur.right=cur.left;

            }
            cur=cur.right;
        }


    }
    static void morrisTraversalInorder(){
        Node root=new Node(3);
        Node cur=root;
        while(cur!=null){
            if (cur.left!=null){
                Node pre=cur.left;
                while (pre.right!=null&pre.right!=cur) pre=pre.right;
                if (pre.right==null){
                    pre.right=cur;
                    cur=cur.left;
                }
                else {
                    pre.right=null;
                    System.out.println(cur.data+" ");
                    cur=cur.right;
                }



            }
            else {
                System.out.print(cur.data+" ");
                cur=cur.right;
            }



        }
    }
}