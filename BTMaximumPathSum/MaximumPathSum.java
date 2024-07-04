package BTMaximumPathSum;

import TreeNode.TreeNode;

public class MaximumPathSum {
    public static int res =Integer.MIN_VALUE;

    public static void main(String[] args) {
        // TreeNode treeNode=new TreeNode(-10);
        // treeNode.left=new TreeNode(9);
        // treeNode.right=new TreeNode(20);
        // treeNode.right.left=new TreeNode(15);
        // treeNode.right.right=new TreeNode(7);
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        maxPathSum(treeNode);
        System.out.println(res);
    }
    public static int maxPathSum(TreeNode root){
        if (root==null){
            return 0;
        }
        int l=maxPathSum(root.left);
        int r=maxPathSum(root.right);

        int max_single = Math.max(root.val,Math.max(l, r)+root.val);
        int max_top = Math.max(max_single, root.val+l+r);
        res = Math.max(res,max_top );
        return max_single;
    }
		
}
