package SymmetricTree;

import TreeNode.TreeNode;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.left.left=new TreeNode(3);
        treeNode.left.right=new TreeNode(4);

        treeNode.right=new TreeNode(2);
        treeNode.right.left=new TreeNode(4);
        treeNode.right.right=new TreeNode(3);

        System.out.println(isSymmetric(treeNode));
    }
    public static boolean isSymmetric(TreeNode root){
        return isMirror(root, root);
    }
    public static boolean isMirror(TreeNode root1,TreeNode root2){
        if (root1==null && root2==null){
            return true;
        }
        if (root1!=null && root2!=null && root1.val==root2.val){
            return isMirror(root1.left, root2.right)&&isMirror(root1.right, root2.left);
        }
        return false;
    }
    
}
