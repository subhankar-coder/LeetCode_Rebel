package KthSmallestBST;

import TreeNode.TreeNode;

public class KthSmallestBST {
    private static int count=0;
    private static int val=0;
    public static void main(String[] args) {
        // TreeNode treeNode=new TreeNode(3);
        // treeNode.left=new TreeNode(1);
        // treeNode.left.right=new TreeNode(2);
        // treeNode.right=new TreeNode(4);

        TreeNode node= new TreeNode(1);
        node.right=new TreeNode(2);

        System.out.println(kthSmallest(node,2));
    }
    public static int kthSmallest(TreeNode root, int k) {
        return inOrder(root,k);
    }
    public static int inOrder(TreeNode root,int k){
        if(root==null)
            return 0;
        
        inOrder(root.left,k);
        count++;
        if(count==k){
            val=root.val;
        }
        if(count>=k)
            return val;
        
        inOrder(root.right,k);

        return val;
    }
    
}
