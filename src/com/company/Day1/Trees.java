package com.company.Day1;

import com.sun.source.tree.Tree;

public class Trees {
    public static void main(String[] args) {
            TreeNode left=new TreeNode(9);
            TreeNode right=new TreeNode(19);
            TreeNode treeNode=new TreeNode(12,left,right);
            dfs(treeNode);



    }

    private static int dfs(TreeNode treeNode) {
        int sum=treeNode.val;
        sum+=dfs(treeNode.left);
        sum+=dfs(treeNode.right);
        return sum;



    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
