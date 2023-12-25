package IsValidBST;

import TreeNode.TreeNode;

public class IsValidBST{
    public static void main(String ... args){
        
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right=new TreeNode(6);
        treeNode.right.left=new TreeNode(3);
        treeNode.right.right=new TreeNode(7);

        // TreeNode node=new TreeNode(2);
        // node.left=new TreeNode(1);
        // node.right=new TreeNode(3);
        System.out.println(isValidBST(treeNode));
    }
    public static boolean isValidBST(TreeNode root){
        if(root==null)
            return true;
        if(root.left!=null && root.val<=maxValue(root.left))
            return false;
        if(root.right!=null && root.val>=minValue(root.right))
            return false;

        return isValidBST(root.left) && isValidBST(root.right);
    }
    public static int maxValue(TreeNode node){
        if(node==null){
            return Integer.MIN_VALUE;
        }
        int value=node.val;
        int left=maxValue(node.left);
        int right=maxValue(node.right);

        return Math.max(value,Math.max(left, right));
    }
    public static int minValue(TreeNode node){
        if (node==null){
            return Integer.MAX_VALUE;
        }
        int value=node.val;
        int left=minValue(node.left);
        int right=minValue(node.right);

        return Math.min(value,Math.min(left, right));
    }
    
}