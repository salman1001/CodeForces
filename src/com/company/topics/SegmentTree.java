package com.company.topics;

public class SegmentTree implements QueryInterface {
    int n;
    int[] lo,hi,min,delta;
    public SegmentTree(int n) {
        this.n=n;
        lo=new int[4*n+1];
        hi=new int[4*n+1];
        min=new int[4*n+1];
        delta=new int[4*n+1];

        init(1,0,n-1);
    }

    private void init(int i, int a, int b) {
        lo[i]=a;
        hi[i]=b;
        if (a==b) return;
        int m=(a+b)/2;
        init(2*i,a,m);
        init(2*i+1,m+1,b);
    }


    @Override
    public void increment(int a, int b, int val) {
        increment(1,a,b,val);

    }
    void increment(int index,int a ,int b ,int val){
        if (b<lo[index]||hi[index]<a) return;
        if (a<=lo[index]&&hi[index]<=b) {
            delta[index]+=val;
            return;
        }
        prop(index);
        increment(2*index,a,b,val);
        increment(2*index+1,a,b,val);
        update(index);
    }
    void prop(int i){
        delta[2*i]+=delta[i];
        delta[2*i+1]+=delta[i];
        delta[i]=0;

    }
    void update(int i){
        min[i]=Math.min(min[2*i]+delta[2*i],min[2*i+1]+delta[2*i+1]);
    }

    @Override
    public int minimum(int i, int j) {
        return minimum(1,i,j);
    }
    int minimum(int index,int a,int b){
        if (b<lo[index]||hi[index]<a) return Integer.MAX_VALUE;
        if (a<=lo[index]&&hi[index]<=b) return min[index]+delta[index];
        prop(index);
        int minLeft=minimum(2*index,a,b);
        int minRight=minimum(2*index+1,a,b);

        update(index);
        return Math.min(minLeft,minRight);



    }



    public static void main(String[] args) {

    }
}
interface QueryInterface{
     void increment(int i,int j,int val);
     int minimum(int i,int j);
}
class SlowRange implements QueryInterface{
    int [] arr;

    public SlowRange(int n) {
        arr=new int[n];
    }


    @Override
    public void increment(int i, int j, int val) {
        for (int k=i;k<=j;k++) arr[k]+=val;

    }

    @Override
    public int minimum(int i, int j) {
        int res=arr[i];
        for (int k=i+1;k<=j;k++) res=Math.min(res,arr[k]);
        return res;
    }
}
