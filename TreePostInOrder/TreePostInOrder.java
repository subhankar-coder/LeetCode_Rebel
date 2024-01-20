package TreePostInOrder;

import TreeNode.TreeNode;

public class TreePostInOrder {
    public static int postIndex;
    public static void main(String[] args) {
    int [] inOrder = {9,3,15,20,7};
     int [] postOrder = {9,15,7,20,3};
     postIndex=postOrder.length-1;
     TreeNode root=createSubTree(postOrder, inOrder, 0, postIndex);
     root.printTreeIn2D();
    }
    public static TreeNode createSubTree(int [] postOrder,int [] inOrder,int inIndex,int inEnd){
        if (inIndex>inEnd){
            return null;
        }
        int data = postOrder[postIndex--];
        TreeNode root = new TreeNode(data);
        if(inIndex==inEnd){
            return root;
        }
        int offSet= inIndex;
        for(;offSet<=inEnd;offSet++){
            if (inOrder[offSet]==data){
                break;
            }
        }
        root.right=createSubTree(postOrder, inOrder, offSet+1, inEnd);
        root.left=createSubTree(postOrder, inOrder, inIndex, offSet-1);
        return root;
    }
}
