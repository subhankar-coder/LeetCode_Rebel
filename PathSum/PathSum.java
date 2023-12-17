package PathSum;

import TreeNode.TreeNode;

public class PathSum {

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(5);
        treeNode.left=new TreeNode(4);
        treeNode.left.left=new TreeNode(11);
        treeNode.left.left.left=new TreeNode(2);
        treeNode.left.left.right=new TreeNode(7);

        treeNode.right=new TreeNode(8);
        treeNode.right.left=new TreeNode(13);
        treeNode.right.right=new TreeNode(4);
        treeNode.right.right=new TreeNode(1);

        // TreeNode treeNode=new TreeNode(1);
        // treeNode.left=new TreeNode(2);

        System.out.println(pathSum(treeNode, 22));

        // treeNode.printTreeIn2D();
    }

    public static boolean pathSum(TreeNode root,int target){
       if(root==null){
        return false;
       }
       return pathSumHelper(root, target,0);
    }
    public static boolean pathSumHelper(TreeNode root,int target,int pathSum){
        if (isLeaf(root) && target==pathSum+root.val){
            return true;
        }
        if(root!=null)
            return pathSumHelper(root.left, target,pathSum+root.val)||pathSumHelper(root.right, target,pathSum+root.val);
        return false;
 
    }
    public static boolean isLeaf(TreeNode root){
        if(root==null){
            return false;
        }
        if (root.left==null && root.right==null){
            return true;
        }
        return false;
    }
}
