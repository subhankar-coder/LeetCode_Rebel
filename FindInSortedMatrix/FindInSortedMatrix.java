package FindInSortedMatrix;

import java.util.*;

public class FindInSortedMatrix{

	public static void main(String[] args) {
		int [][] matrix = {{2 ,4 ,8},{3 ,6 ,9},{4 ,7 ,16}};
		int target=5;

		int row=-1;
		int col =-1;

		int N = matrix.length;

		for(int i=0;i<N;i++){

			if(target>= matrix[i][0] && target<=matrix[i][N-1]){
				int c = lowerBound(matrix[i],0,N,target);
		
				if(matrix[i][c]==target){
					row=i;
					col=c;
					break;	
				}else{
					c = c-1;
					int pos = binarySearchCol(matrix,target,i,c,N);
					row=pos;
					col=row!=-1?c:-1;
					break;
					
				}
			}

			if(target< matrix[i][0]){
				
				break;
			}

		}
		System.out.println(row+" "+col);

	}
	public static int binarySearchCol(int [][] matrix,int target,int row,int col,int N){

		int [] arr = new int [N-row];

		// System.out.println(row+" "+col);

		for(int i=row;i<N;i++){
			arr[i-row]=matrix[i][col];
		}

		// System.out.println(Arrays.toString(arr));

		int r = Arrays.binarySearch(arr,target);

		return r<0?-1:r;
	}

	public static int lowerBound(int [] array,int low,int high,int target){


		while(low<high){

			int mid = low+(high-low)/2;
			// System.out.println(low+" "+high);

			if(target<=array[mid]){
				high=mid;
			}else{
				low=mid+1;
			}
		}


		return low;
	}
	public static boolean search(int matrix[][], int n, int m, int target) 
	{  
	    int i=0;
	    int j=m-1;
	    
	    while(i<n && j>=0){
	        if(matrix[i][j]==target){
	            return true;
	        }
	        
	        if(matrix[i][j]>target){
	            j--;
	        }
	        else{
	            i++;
	        }
	    }
	    
	    return false;
	} 


}