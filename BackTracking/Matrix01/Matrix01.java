package Matrix01;

import java.util.*;

public class Matrix01{

	static int R;
	static int C;
	static boolean [][] visited;
	static int [][] res;
	public static void main(String[] args) {
		// int [][] mat = {{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},{0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},{0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,1,1,1,0,1},{1,1,1,1,1,1,1,0,1,0},{1,1,1,1,0,1,0,0,1,1}};
		int [][] mat = {{0,0,0},{0,1,0},{0,0,0}};
		R = mat.length;
		C = mat[0].length;

		res = new int [R][C];
		Queue<int []> queue=new LinkedList<int []>();
		visited=new boolean[R][C];
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				if(mat[i][j]==0){
					res[i][j]=0;
					// visited[i][j]=true;
					queue.add(new int []{i,j});
				}else{
					res[i][j]=Integer.MAX_VALUE;
				}
			}
		}
		bfsDp(mat,queue);
		
		for(int [] arr:res){
			System.out.println(Arrays.toString(arr));
		}
	}
	public static void bfsDp(int [][]mat,Queue<int []> queue){
		int level=0;
		while(!queue.isEmpty()){

			int len=queue.size();
			for(int i=0;i<len;i++){
				int [] curr = queue.poll();
				int row = curr[0];
				int col = curr[1];

				if(!visited[row][col]){
					visited[row][col]=true;

					System.out.println(" row "+row+" col "+col);
					if(row+1<R && mat[row+1][col]!=0){
						queue.add(new int []{row+1,col});
						res[row+1][col]=Math.min(res[row+1][col],level+1);

					}
					if(row-1>=0 && mat[row-1][col]!=0){
						queue.add(new int []{row-1,col});
						res[row-1][col]=Math.min(res[row-1][col],level+1);

					}

					if(col-1>=0 && mat[row][col-1]!=0){
						queue.add(new int []{row,col-1});
						res[row][col-1]=Math.min(res[row][col-1],level+1);

					}
					if(col+1<C && mat[row][col+1]!=0){
						queue.add(new int []{row,col+1});
						res[row][col+1]=Math.min(res[row][col+1],level+1);

					}
				}
			}
			level++;	
		}
	}
	public static int bfs(int [][] mat,int r,int c){

		int level =0;
		Queue<int []> queue = new LinkedList<>();
		int [][] visited = new int [R][C];
		// System.out.println(R+" "+C);
		queue.add(new int [] {r,c});


		int lev=Integer.MAX_VALUE;
		while(!queue.isEmpty()){

			int len = queue.size();
			for(int i=0;i<len;i++){
				int [] curr = queue.poll();
				int row =curr[0];
				int col=curr[1];
				if(visited[row][col]==0){
					visited[row][col]=1;

					if(mat[row][col]==0){
						return Math.min(lev,level);
					}else if( res[row][col]!=-1){
						lev=Math.min(lev,res[row][col]+1);
					}else{
						if(row+1<R ){
							queue.add(new int [] {row+1,c});
						}
						if(row-1>=0)
								queue.add(new int[]{row-1,c});
						if(col+1<C)
								queue.add(new int [] {row,col+1});
						if(col-1>=0)
								queue.add(new int [] {row,col-1});
					}
				}
			}
			level++;
		}

		return lev;
	}
	public static int dfs(int [][] mat,int r,int c){

		System.out.println("row "+r+" col "+c);
		if(visited[r][c] ){
			return res[r][c];
		}

		if(mat[r][c]==0){
			visited[r][c]=true;
			res[r][c]=0;
			return 0;
		}

		visited[r][c]=true;
		int left=Integer.MAX_VALUE;
		int right=Integer.MAX_VALUE;
		int up=Integer.MAX_VALUE;
		int down=Integer.MAX_VALUE;

		if(r+1<R){
			down=dfs(mat,r+1,c);
		}
		if(r-1>=0)
			up = dfs(mat,r-1,c);
		if(c+1<C)
				right = dfs(mat,r,c+1);
		if(c-1>=0)
				left = dfs(mat,r,c-1);

		int min = 1+Math.min(Math.min(up,Math.min(right,left)),down);

		System.out.println("row "+r+" col "+c+" min "+min+" left "+left +" right "+right+" up "+up +" down ");

		return res[r][c]=min;
	}

}