package BoundaryTravershal;

import java.util.*;
import TreeNode.TreeNode;

public class BoundaryTravershal{
	public static void main(String[] args) {
		TreeNode root = new TreeNode(100);
		root.left=new TreeNode(50);
		root.left.left=new TreeNode(25);
		root.left.right=new TreeNode(75);
		root.left.left.right=new TreeNode(30);
		root.left.left.right.right=new TreeNode(35);
		root.left.right.left=new TreeNode(70);
		root.left.right.right=new TreeNode(80);

		root.right=new TreeNode(150);
		root.right.left=new TreeNode(140);
		root.right.right=new TreeNode(200);

		root.printTreeIn2D();
		

		root.printTreeIn2D();

		if(root.left!=null){

			printLeftBoundary(root.left);
			leafNodes(root.left);
		}
		if(root.right!=null){
			leafNodes(root.right);
			printRightBoundary(root.right);
		}

		
	}

	public static void printLeftBoundary(TreeNode node ){

			if(node==null)
				return;
			if(node.left!=null){
					System.out.println(node.val);
					printLeftBoundary(node.left);
			}
			else if(node.right!=null){
					System.out.println(node.val);
				printLeftBoundary(node.right);
			}

	}
	public static void printRightBoundary(TreeNode node){
		
		if(node==null)
			return;
		if(node.right!=null){
			printRightBoundary(node.right);
			System.out.println(node.val);
		}else if(node.left!=null){
			printRightBoundary(node.left);
			System.out.println(node.val);
		}
	}
	public static void leafNodes(TreeNode node){
		if(node==null)
			return;
		if(node.left==null && node.right==null){
			System.out.println(node.val);
		}
		if(node.left!=null){
			leafNodes(node.left);
		}
		if(node.right!=null)
			leafNodes(node.right);
	}	
}