package SumOfRootToLeaf;

import TreeNode.TreeNode;

public class SumRootToLeaf {
    public  int sum=0;
    public static void main(String[] args) {
        
    }
    public int sumNumbers(TreeNode root) {
        calculateSum(root,"");
        return sum;
    }
    public void calculateSum(TreeNode root,String path){
        if(root==null){
            return ;
        }
        if(isLeaf(root)){
            // System.out.println(sum);
            sum=sum+Integer.valueOf(path+String.valueOf(root.val));
            
        }
        calculateSum(root.left,path+String.valueOf(root.val));
        calculateSum(root.right,path+String.valueOf(root.val));
    }
    public boolean isLeaf(TreeNode root){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        return false;
    }
}
