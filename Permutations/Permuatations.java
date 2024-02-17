package Beautifulpermuatations;


import java.util.*;

public class Permuatations{
	static int count;
	static int [] visited;
	public static void main(String[] args) {
		int n = 3;
		visited=new int[n+1];
		count=0;
		solve(1,n);
		System.out.println(count);
	}
	public static void solve(int index,int n){


		if(index>n){
			count++;
			// System.out.println(Arrays.toString(arr));
			return;
		}

		for(int i=1;i<=n;i++){
				System.out.println(" before swipe i "+i+" index "+index+" is visited "+visited[i]);
				if(visited[i]!=1 && (index%i==0 || i%index==0)){
					visited[i]=1;
					solve(index+1,n);
					// System.out.println(" after swipe i "+i+" index "+index+"  "+ Arrays.toString(arr));
					visited[i]=0;
				}
		}
	}
}