package coding.play.Day3;

public class SegmentTreeMod {
    public static void main(String[] args) {
        /*

        SegmentTree
        leftlimit rightlimit
        lchild rchild max changes done till now
        the value its self
        ---
        point update
        range update with mod
        query over the range the sum in nutshell



         */
    }
    static class Seg{
        int leftMost;
        int rightMost;
        Seg lChild;
        Seg rchild;
        int maxMod;
        int sum;
        public Seg(int leftMost, int rightMost,int arr[]) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost==rightMost){
                maxMod=arr[leftMost];
                sum=arr[leftMost];
            }
            else {
                int mid=leftMost+rightMost/2;
                lChild=new Seg(leftMost,mid,arr);
                rchild=new Seg(mid+1,rightMost,arr);
                recal();
            }
        }

        private void recal() {
            if (leftMost==rightMost) return;
            else {
                maxMod=Math.max(lChild.maxMod, rchild.maxMod);
                sum=lChild.sum+ rchild.sum;
            }
        }
        private void pointUpdate(int index,int val){
            if (leftMost==rightMost){
                sum=val;
                maxMod=val;
            }
            else {
                if (lChild.rightMost>=index){
                    lChild.pointUpdate(index,val);
                }
                else {
                    rchild.pointUpdate(index,val);

                }

            }
            recal();
        }
        private void rangeMod(int l,int r,int x){
            if (r<leftMost||l>rightMost) return;
            else if(l<=leftMost&&r>=rightMost){

            }
            else {

            }
            recal();
        }
    }

}
