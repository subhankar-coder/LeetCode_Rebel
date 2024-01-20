package LevelOrderTraversalBT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeNode.TreeNode;

public class levelOrderTraversalBT {
    private List<List<Integer>> list = new ArrayList<>();
     public List<List<Integer>> levelOrder(TreeNode root) {


        if(root==null)
            return list;
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()){
            int count =queue.size();
            List<Integer> tempList = new ArrayList<>();

            while(count>0){
                TreeNode temp = queue.poll();
                tempList.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
                count--;
            }
            list.add(tempList);
        }

        return list;

    }
}
