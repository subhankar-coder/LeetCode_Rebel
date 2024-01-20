package AverageNodeVal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeNode.TreeNode;

public class AvarageNodeValBST {
 private static List<Double> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode treeNode =new TreeNode(3);
        treeNode.left=new TreeNode(9);
        treeNode.left.left=new TreeNode(15);
        treeNode.left.left=new TreeNode(7);
        treeNode.right=new TreeNode(20);
        levelOrderTraversal(treeNode);
        System.out.println(list);
    }
    // public static List<Double> listOfAvg(TreeNode node){
    //     return levelOrderTraversal(node);
    // }

    public static void levelOrderTraversal(TreeNode node){
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            int count= queue.size();
            double sudoCount =count;
            double sum=0;

            while (count>0) {
                TreeNode treeNode = queue.poll();
                sum+=treeNode.val;
                if(treeNode.left!=null)
                    queue.add(treeNode.left);
                if(treeNode.right!=null)
                    queue.add(treeNode.right);

                count--;
            }
            
            Double resDouble= sum/sudoCount;
            list.add(resDouble);
        }
    }
    
}
