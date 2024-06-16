package SmallestAfterSelf;

import java.util.*;

public class SmallestAfterSelf{
	public static void main(String[] args) {
		
		int[] arr = { 12, 1, 2, 3, 0, 11, 4 };
		int n = arr.length;
		int [][] array = new int [n][2];
		for(int i=0;i<n;i++){
			array[i][0]=arr[i];
			array[i][1]=i;
		}
		int [] ans = new int [n];
		mergeSort(array,0,n-1,ans);
		System.out.println(Arrays.toString(ans));
	}
	public static void mergeSort(int [][] array,int l,int h,int [] ans){

		if(l>=h){
			return ;
		}

		int mid = (l+h)/2;


		mergeSort(array,l,mid,ans);
		mergeSort(array,mid+1,h,ans);

		merge(array,mid,l,h,ans);
	}
	public static void merge(int [][] array,int mid,int l,int h,int [] ans){

		int [][] temp = new int [h-l+1][2];

		int i=l;
		int j= mid+1;
		int k =0;

		while(i<=mid && j<=h){

			if(array[i][0]>array[j][0]){

				ans[array[i][1]]+=(h-j+1);


				temp[k][0]=array[i][0];
				temp[k][1]=array[i][1];
				i++;
			}else{
				temp[k][0]=array[j][0];
				temp[k][1]=array[j][1];
				j++;
			}

			k++;
		}

		while(i<=mid){
			temp[k][0]=array[i][0];
			temp[k][1]=array[i][1];
			i++;
			k++;
		}

		while(j<=h){
			temp[k][0]=array[j][0];
			temp[k][1]=array[j][1];
			j++;
			k++;
		}

		k=0;

		for(i=l;i<=h;i++,k++){

			array[i][0]=temp[k][0];
			array[i][1]=temp[k][1];
		}


	}
}