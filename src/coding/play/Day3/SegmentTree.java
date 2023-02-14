package coding.play.Day3;

public class SegmentTree {
    public static void main(String[] args) {


    }
    static class Seg{
        int leftMost,rightmost;
        Seg lChild,rChild;
        int sum;
        public Seg(int leftMost,int rightmost,int[] a){
            this.leftMost=leftMost;
            this.rightmost=rightmost;
            if (leftMost==rightmost) sum=a[leftMost];
            int mid=leftMost+rightmost/2;
            lChild=new Seg(leftMost,mid,a);
            rChild=new Seg(mid+1,rightmost,a);
            recal();
        }

        private void recal() {
            if (leftMost==rightmost) return;
            sum=lChild.sum+rChild.sum;
        }
        private void pointUpdate(int pos,int val){
            if (leftMost==rightmost) {
                sum=val;
                recal();
                return;
            }
            if (pos<= lChild.rightmost) lChild.pointUpdate(pos,val);
            else rChild.pointUpdate(pos,val);
            recal();

        }
        private int  rangeSum(int l,int r){
            if (l>rightmost||r<leftMost) return 0;
            if (l<=leftMost&&r>=rightmost) return sum;
            return lChild.rangeSum(l,r)+ rChild.rangeSum(l,r);
        }
    }








}
