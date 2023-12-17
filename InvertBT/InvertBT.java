package InvertBT;

import TreeNode.TreeNode;

public class InvertBT{
    public static void main(String[] args) {
        // TreeNode treeNode=new TreeNode(4);
        // treeNode.left=new TreeNode(2);
        // treeNode.right=new TreeNode(7);
        // treeNode.left.left=new TreeNode(1);
        // treeNode.left.right=new TreeNode(3);
        // treeNode.right.left=new TreeNode(6);
        // treeNode.right.right=new TreeNode(9);
        TreeNode treeNode= new TreeNode(1);
        treeNode.left=new TreeNode(2);

        invertTree(treeNode);
        treeNode.printTreeIn2D();
    }
    public static  TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }else if (root.left==null && root.right==null){
            return root;
        }
        
        invertTree(root.left);
        invertTree(root.right);
        
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        
        
        return root;
        
    }

}

