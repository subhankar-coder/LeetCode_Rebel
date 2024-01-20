package LCABinaryTree;

import TreeNode.TreeNode;

public class LCABT {

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(3);
        treeNode.left=new TreeNode(5);
        treeNode.left.left=new TreeNode(6);
        treeNode.left.right=new TreeNode(2);
        treeNode.left.right.left=new TreeNode(7);
        treeNode.left.right.right=new TreeNode(4);

        treeNode.right=new TreeNode(1);
        treeNode.right.left=new TreeNode(0);
        treeNode.right.right=new TreeNode(8);
        System.out.println(lowestCommonAncestor(treeNode,treeNode.left,treeNode.left.right.right).val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root==null){
            return null;
        }
        if(root==p || root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left!=null && right!=null){
            return root;
        }else{
            return(left!=null? left:right);
        }
    }
    
}
