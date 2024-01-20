package BSTIterator;

import java.util.ArrayList;
import java.util.List;

import TreeNode.TreeNode;

public class BSTIterator {
    public static void main(String[] args) {
        
    }
}
class BSTIteratorHelper {
    public List<Integer> list=new ArrayList<Integer>();
    public TreeNode root;
    public int currIndex=1;
    public int len;
    public BSTIteratorHelper(TreeNode root) {
        this.root=root;
        inOrder(root);
        len=list.size();
        list.add(0,list.get(0)-1);
    }
    
    public int next() {
        return list.get(currIndex++);
    }
    
    public boolean hasNext() {
        return currIndex<=len;
    }
    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}

