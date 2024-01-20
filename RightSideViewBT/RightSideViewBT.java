package RightSideViewBT;

import java.util.*;

import TreeNode.TreeNode;

public class RightSideViewBT {
    public static List<Integer>list =new ArrayList<>();
    public static void main(String[] args) {
        
    }
    public static void populate(TreeNode root,int index){
        if(root==null){
            return;
        }
        if(index<list.size()){
            list.remove(index);
        }
        list.add(index,root.val);
        populate(root.left,index+1);
        populate(root.right,index+1);
    }
}
