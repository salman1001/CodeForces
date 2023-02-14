package coding.play.leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class Pair{
        int r,col,m;

        public Pair(int r, int col, int m) {
            this.r = r;
            this.col = col;
            this.m = m;
        }
    }
    public static void main(String[] args) {
        int[][] gid=new int[12][45];
        Queue<Pair> queue=new LinkedList<Pair>();
        int counter=0;
        int[][] vis=new int[12][45];
        for (int i=0;i<gid.length;i++){
            for (int j=0;j<gid[i].length;j++){
                if (gid[i][j]==2){
                    vis[i][j]=2;
                    queue.add(new Pair(i,j,0));

                }
                else {
                    vis[i][j]=0;

                }
                if (gid[i][j]==1){
                    counter++;
                }

            }
        }
        int maxMin=0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while (!queue.isEmpty()){
            int r= queue.peek().r;
            int c= queue.peek().col;
            int m= queue.peek().m;
            maxMin=Math.max(maxMin,m);
            queue.poll();
            for (int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if (nrow>=0&&nrow<45&&ncol>=0&&ncol<34&&vis[nrow][ncol]==0&&gid[nrow][ncol]==1){
                    queue.add(new Pair(nrow,ncol,m+1));
                    //vis[][]
                }

            }


        }

    }
}
