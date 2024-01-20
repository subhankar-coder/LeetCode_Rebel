package CountNodes;

import TreeNode.TreeNode;

public class CountNodesBT {

    public static void main(String[] args) {
        
    }
    public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    
}
