package LongestIncPath2DMat;

import java.util.*;


public class LongestIncPath2DMatrix{

	static int[][] visited;
	static int count =1;

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
		mat.add(new ArrayList<>(Arrays.asList(1,2,3)));
		mat.add(new ArrayList<>(Arrays.asList(5,6,4)));
		mat.add(new ArrayList<>(Arrays.asList(9,5,11)));

		int n=3;
		int m=3;

		visited=new int [n][m];

		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(visited[i][j]!=1)
					countPathLen(mat,n,m,i,j,1);

		System.out.println(count);
			
	}
	public static void countPathLen(ArrayList<ArrayList<Integer>> mat,int n,int m,int r,int c,int res){
		if(r>=n || r<0 || c>=m || c<0 || visited[r][c]==1)
			return;

		// System.out.println("row "+r+" col "+c+" trail "+trail);
		visited[r][c]=1;

		count=Math.max(count,res);

		if(r+1<n && mat.get(r+1).get(c)>mat.get(r).get(c))
			countPathLen(mat,n,m,r+1,c,res+1);

		if(r-1>=0 && mat.get(r-1).get(c)>mat.get(r).get(c))
			countPathLen(mat,n,m,r-1,c,res+1);

		if(c+1<m && mat.get(r).get(c+1)>mat.get(r).get(c))
			countPathLen(mat,n,m,r,c+1,res+1);

		if(c-1>=0 && mat.get(r).get(c-1)>mat.get(r).get(c))
			countPathLen(mat,n,m,r,c-1,res+1);

		visited[r][c]=0;

	}
}