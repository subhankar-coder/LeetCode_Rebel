package DP.HouseRobberIII;

import TreeNode.TreeNode;
import java.util.*;

public class HouseRobberIII {

    static Map<TreeNode,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left=new TreeNode(1);
        root.right=new TreeNode(3);
        // root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(4);
        // root.right.right=new TreeNode(1);

        // root.printTreeIn2D();
        System.out.println(rob(root));
    }
    public static int rob(TreeNode root) {
        if(root==null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
        
        int val = root.val;
        if(root.left!=null)
            val+=rob(root.left.left)+rob(root.left.right);
        if(root.right!=null)
            val+=rob(root.right.left)+rob(root.right.right);
        int res = Math.max(val,rob(root.left)+rob(root.right));
        map.put(root,res);
        return res;
    }
}
