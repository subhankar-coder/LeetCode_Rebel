package  MinDistanceBetweenTwoBSTNOde;

import TreeNode.TreeNode;

public class MinDistanceBetweenTwoBSTNode {
    private int MIN_DIST=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {

        if(root==null){
            return MIN_DIST;
        }
        int min = helper(root,Integer.MAX_VALUE,root.val);
        MIN_DIST=Math.min(MIN_DIST,min);

        getMinimumDifference(root.left);
        getMinimumDifference(root.right);

        return MIN_DIST;       
    }

    public int helper(TreeNode node,int minDist,int rootVal){
        if(node==null){
            return minDist;
        }
        if(rootVal!=node.val)
            minDist=Math.min(minDist,Math.abs(rootVal-node.val));
        int left = helper(node.left,minDist,rootVal);
        int right = helper(node.right,minDist,rootVal);

        return Math.min(left,right);
    }
}
