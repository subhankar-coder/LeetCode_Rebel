package DP.UniqueBST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TreeNode.TreeNode;

public class UniqueBST{
	static int N;

	static Map<String,List<TreeNode>> map;
	public static void main(String[] args) {
		
		int n =3;
		N=n;
		int [] array = new int[n];
		for(int i=1;i<=n;i++){
			array[i-1]=i;
		}
		map=new HashMap<>();
		List<TreeNode> res=createBST( 1, n);
		System.out.println(res);
		// root.printTreeIn2D();
		// System.out.println(numOfNodes(root));
	}
	public static List<TreeNode> createBST(int start,int end){
		
		if(map.containsKey(start+" "+end))
			return map.get(start+" "+end);
		if(start==end){
			return Arrays.asList(new TreeNode(start));
		}
		if(start>end){
			return Arrays.asList((TreeNode)null);
		}
		List<TreeNode> res = new ArrayList<>();
		for(int i=start;i<=end;i++){
			for(TreeNode left : createBST( start, i-1)){
				for(TreeNode right : createBST(i+1,end)){
					TreeNode root = new TreeNode(i,left,right);
					res.add(root);
				}
			}
		}
		map.put(start+" "+end, res);
		return res;
	}
	public static int numOfNodes(TreeNode root){
		if(root==null){
			return 0;
		}
		return 1+numOfNodes(root.left)+numOfNodes(root.right);
	}
}
