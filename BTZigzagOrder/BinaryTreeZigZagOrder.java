package BTZigzagOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeNode.TreeNode;

public class BinaryTreeZigZagOrder {

    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(3);
        treeNode.left=new TreeNode(9);
        treeNode.right=new TreeNode(20);
        treeNode.right.left=new TreeNode(15);
        treeNode.right.right=new TreeNode(7);
        System.out.println(zigzagLevelOrder(treeNode));
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root==null)
            return list;
        boolean fromLeft = true;

        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count=queue.size();
            List<Integer> tmpList = new ArrayList<>();

            while(count>0){
                TreeNode node = queue.poll();
                tmpList.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);

                if(node.right!=null){
                    queue.add(node.right);
                }
                count--;
            }
            if(!fromLeft){
                tmpList=reverseList(tmpList);
            }
            fromLeft = !fromLeft;
            list.add(tmpList);

        }
        return list;
    }
    public static List<Integer> reverseList(List<Integer> lst){

        if(lst.size()==0)
            return lst;
        int value = lst.get(0);

        lst.remove(0);
        reverseList(lst);
        lst.add(value);
        return lst;
    }
}
