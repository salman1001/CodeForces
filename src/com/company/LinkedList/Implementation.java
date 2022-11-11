package com.company.LinkedList;

public class Implementation {

    private Node head;
    private Node tail;
    private int size;
    public Implementation() {
        this.size=0;
    }
    public void insertFirst(int val){
        Node node=new Node(val);
            node.next=head;
            head=node;
            if (tail==null) tail=head;
            size++;
    }
    public void insertRandom(int index,int val){
        Node node =new Node(val);
        int counter=1;
        Node temp=head;
        while (counter<index&&temp.next!=null){
            counter++;
            temp=temp.next;
        }
        node.next=temp.next;
        temp.next=node;
        size++;

    }

    public void insertLast(int val){
        if (tail==null) {
            insertFirst(val);
            return;
        }
        Node node=new Node(val);
        tail.next=node;
        tail=node;
        size++;
        //when tail not available
//        Node temp=head;
//        while (temp.next!=null) temp=temp.next;
//        temp.next=node;
//        tail=node;

    }

    public void print(){
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.value+"------>");temp=temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        Implementation implementation=new Implementation();
        implementation.insertFirst(0);
        implementation.insertFirst(3);
        implementation.insertFirst(4);
        implementation.insertFirst(5);
        implementation.print();
        implementation.insertLast(12);
        implementation.print();
        implementation.insertLast(78);
        implementation.print();
        implementation.insertRandom(30,1000);
        implementation.print();


    }
    private class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }
}
