package Divide_and_conqure.BSTFromArray;

import TreeNode.TreeNode;

public class BSTFromArray {

     public static void main(String[] args) {
        int [] array={-10,-3,0,5,9};
        int n=array.length;
        int rootIndex=n/2;
        TreeNode root=createBST(null, array, 0, n);
        printInorder(root);
        
     }  
     public static TreeNode createBST(TreeNode root,int [] array,int leftIndex,int rightIndex){
        if(leftIndex>=rightIndex)
            return null;
        
        int mid=(leftIndex+rightIndex)/2;
        root=new TreeNode(array[mid]);
        root.left=createBST(root, array, leftIndex, mid);
        root.right=createBST(root, array, mid+1, rightIndex);
        return root;
     }
     public static void printInorder(TreeNode root){
        if(root==null)
            return;
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
        
     }
}