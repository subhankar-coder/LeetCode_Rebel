package KthAncestorOfBT;

import java.util.*;

public class KthAncestorOfBT{
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right=new BinaryTreeNode(5);

		levelOrderTraversal(root,4,1);
	}
	public static void levelOrderTraversal( BinaryTreeNode<Integer> root,int targetNodeVal, int kth){

		List<HashMap<Integer,Integer>> cache = new ArrayList<>();
		HashMap<Integer,Integer> initial = new HashMap<>();
		initial.put(root.data,-1);
		cache.add(initial);
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()){
			int len = queue.size();
			HashMap<Integer,Integer> li= new HashMap<>();
			boolean shallBreak = false;
			for(int i=0;i<len;i++){
				BinaryTreeNode<Integer> curr = queue.poll();
				if(curr.data==targetNodeVal){
					shallBreak=true;
					break;
				}
				if(curr.left!=null){

					li.put(curr.left.data,curr.data);
					queue.add(curr.left);
					if(curr.left.data==targetNodeVal){
						shallBreak=true;
						break;
					}
				}

				if(curr.right!=null){
					li.put(curr.right.data,curr.data);
					queue.add(curr.right);
					if(curr.right.data==targetNodeVal){
						shallBreak=true;
						break;
					}
				}
			}

			if(!li.isEmpty())
				cache.add(li);

			if(shallBreak)
				break;

		}

		if(kth>=cache.size()){
			System.out.println(-1);
			return;
		}
		
		for(int i=cache.size()-1;i>0 && kth>0;i--,kth--){
			targetNodeVal = cache.get(i).get(targetNodeVal); 
		}

		System.out.println(targetNodeVal);

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