package TreeFromPre_In_Order;

import TreeNode.TreeNode;

public class TreeFromInPreOreder {
    public static int preIndex=0;
    
    public static void main(String[] args) {
     int [] preOrder = {-1};
     int [] inOrder = {-1};
     TreeNode res= createSubTree(preOrder, inOrder, 0, inOrder.length-1);
     res.printTreeIn2D();
     
    }
    public static TreeNode createSubTree(int [] preOrder,int [] inOrder,int inIndex,int inEnd){
        if (inIndex>inEnd){
            return null;
        }
        int data = preOrder[preIndex++];
        TreeNode root = new TreeNode(data);
        if(inIndex==inEnd){
            return root;
        }
        int offSet= inIndex;
        for(;offSet<inEnd;offSet++){
            if (inOrder[offSet]==data){
                break;
            }
        }
        root.left=createSubTree(preOrder, inOrder, inIndex, offSet-1);
        root.right= createSubTree(preOrder, inOrder,  offSet+1,inEnd);
        return root;
    }
}


