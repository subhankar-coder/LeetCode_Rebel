package BurnBinaryTree;

import java.util.*;

import TreeNode.TreeNode;

public class BurnBinaryTree {

    static Map<Integer,Queue<TreeNode>> map ;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

    //   root.left=new TreeNode(2);
    //   root.left.left=new TreeNode(3);
    //   root.left.left.left=new TreeNode(4);
    //   root.left.left.left.left=new TreeNode(5);

        root.left=new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.left.right.left=new TreeNode(9);
        root.left.right.right=new TreeNode(2);

        root.right=new TreeNode(3);
        root.right.left=new TreeNode(10);
        root.right.right=new TreeNode(6);
        map = new HashMap<>();

        generateMap(root, root);

        int start =3;

        Set<Integer> set = new HashSet<>();
        set.add(start);

        Queue<TreeNode> queue = map.get(start);

        int level =0;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for(int i=0;i<len;i++){
                TreeNode node = queue.poll();
                if(!set.contains(node.val)){
                    set.add(node.val);
                    for(TreeNode nd: map.get(node.val)){
                        if(!set.contains(nd.val)){
                                queue.add(nd);
                        }
                    }
                }
            }
            level++;
        }

        System.out.println(level);

    //    for(Map.Entry<Integer,List<TreeNode>> entry: map.entrySet()){
    //     System.out.print(entry.getKey()+"  -> ");
    //     for(TreeNode nd : entry.getValue()){
    //         System.out.print(nd.val+"  ");
    //     }

    //     System.out.println();
    //    }

    
        
    }
    public static void generateMap(TreeNode root,TreeNode prev){

            int val = root.val;

            if(!map.containsKey(val)){
                map.put(val, new LinkedList<>());
            }
            if(prev.val!=val){
                map.get(val).add(prev);
            }
            if(root.left!=null){
                map.get(val).add(root.left);
                generateMap(root.left, root);
            }
            if(root.right!=null){
                map.get(val).add(root.right);
                generateMap(root.right, root);
            }
    }
    
}
