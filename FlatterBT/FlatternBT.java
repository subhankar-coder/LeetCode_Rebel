package FlatterBT;

import java.util.ArrayList;
import java.util.List;

import TreeNode.TreeNode;

public class FlatternBT {
    public static void main(String[] args) {
        
    }
    public void flatten(TreeNode root) {
        
        List<Integer> list =getPreOrder(root,new ArrayList<>());
        if(list!=null && list.size()>=1){
            for(int i=1;i<list.size();i++){
            root.right=new TreeNode(list.get(i));
            root.left=null;
            root=root.right;
        }
        }
        
    }
    public List<Integer> getPreOrder(TreeNode root,List<Integer> list){
        if(root==null){
            return null;
        }
        list.add(root.val);
        getPreOrder(root.left,list);
        getPreOrder(root.right,list);
        return list;
    }
}
