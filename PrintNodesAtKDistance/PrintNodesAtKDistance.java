package PrintNodesAtKDistance;


import java.util.*;


public class PrintNodesAtKDistance{

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode(3);
		root.left = new BinaryTreeNode(5);
		root.right = new BinaryTreeNode(1);
		root.left.left = new BinaryTreeNode(6);
		root.left.right = new BinaryTreeNode(2);
		root.left.right.left=new BinaryTreeNode(7);
		root.left.right.right= new BinaryTreeNode(4);

		root.right.left=new BinaryTreeNode(0);
		root.right.right=new BinaryTreeNode(8);
	}
	public static void solve(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> target,int k){

		if(root==target){
			return;
		}
		
	}
}

class BinaryTreeNode<T>{
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data){
		this.data=data;
	}
}