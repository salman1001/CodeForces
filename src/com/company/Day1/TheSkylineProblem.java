package com.company.Day1;

import java.util.*;

public class TheSkylineProblem {
    static Scanner sc=new Scanner(System.in);


    static class Pair implements Comparator<Pair>,Comparable<Pair>{
        int x_cor;
        int height;

        public Pair(int end,int height){
            this.x_cor =end;
            this.height=height;
        }

        public Pair() {
        }

        @Override
        public int compareTo(Pair o) {
            if (o.x_cor==this.x_cor){
                return o.height<this.height?1:-1;

            }
            else return o.x_cor<this.x_cor?1:-1;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.x_cor==o2.x_cor){
                return o1.height>o2.height?1:-1;

            }
            else return o1.x_cor>o2.x_cor?1:-1;
        }
    }
    static class CustomIntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 < o2 ? 1 : -1;
        }
    }
    public static void main(String[] args) {
        int[][] demoArray={{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<Pair> arrayList=new ArrayList<>();
        //for (int i=0;i<2*demoArray.length;i++) arrayList.add(new Pair(-10,-10));
        for (int i=0;i<demoArray.length;i++){
            arrayList.add(new Pair(demoArray[i][0],(demoArray[i][2]*-1)));
            arrayList.add(new Pair(demoArray[i][1],(demoArray[i][2])));

        }
            Collections.sort(arrayList,new Pair());

//        for (int i=0;i<arrayList.size();i++) System.out.println(arrayList.get(i).x_cor+" "+arrayList.get(i).height);
//        System.out.println();

//
//        Collections.sort(arrayList, new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//
//            }
//        });
        int currentMax=0;
        List<Pair> ret=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(new CustomIntegerComparator());
        pq.add(0);
        for (int i=0;i<arrayList.size();i++){
            Pair p=arrayList.get(i);
            if(p.height<0){
                pq.add(p.height*-1);
                if (currentMax<(p.height*-1)){
                    currentMax=p.height*-1;
                    ret.add(new Pair(p.x_cor,currentMax));
                }
            }
            else {
                pq.remove(p.height);
                if (currentMax>pq.peek()){
                    currentMax=pq.peek();
                    ret.add(new Pair(p.x_cor,currentMax));

                }
            }


        }
        List<List<Integer>> rett=new ArrayList<>();
        for (int i=0;i<ret.size();i++) rett.add(new ArrayList<>());
        for (int i=0;i<ret.size();i++) {
            rett.get(i).add(ret.get(i).x_cor);
            rett.get(i).add(ret.get(i).height);


        }







    }
}
