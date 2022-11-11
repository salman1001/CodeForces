package com.company.round710;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class G {
    static Scanner sc =new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<Character,Pair> hashMap=new HashMap<>();
        hashMap.put('c',new Pair(2,new ArrayList<>()));
        hashMap.put('a',new Pair(2,new ArrayList<>()));
        hashMap.put('b',new Pair(2,new ArrayList<>()));
        hashMap.put('d',new Pair(7,new ArrayList<>()));
        hashMap.put('q',new Pair(2,new ArrayList<>()));
        for (int i=0;i<hashMap.size();i++) System.out.print(hashMap.get('d'));



    }
    static class Pair{
        @Override
        public String
        toString() {
            return "Pair{" +
                    "count=" + count +
                    ", arrayList=" + arrayList +
                    '}';
        }

        int count=0;
        ArrayList<Integer> arrayList=new ArrayList<>();

        public Pair(int count, ArrayList<Integer> arrayList) {
            this.count = count;
            this.arrayList = arrayList;
        }

        public Pair() {
        }
    }
}
