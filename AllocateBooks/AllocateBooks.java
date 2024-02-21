package AllocateBooks;

import java.util.*;

public class AllocateBooks{

	public static void main(String[] args) {
		int [] times= {3,8};
		// Arrays.sort(times);
		int n = 1;
		int m =  2;

		long sum =0;
		for(int i=0;i<m;i++)
			sum+=(times[i]*1L);

		long start=1;

		while(start<=sum){
			long mid = (start+sum)/2;
			if(canFit(mid,n,times,m)>=0){
				sum = mid-1;
			}else{
				start= mid+1;
			}
		}
			System.out.println(start);
	}

	public static int canFit(long max,int k ,int [] times,int m){

		long total =0;
		int books=1;

		for(int i=0;i<m;i++){
			if(times[i]>max)
				return -1;
			if(total+times[i]<=max){
				total+=times[i];
			}else{
				total=times[i];
				books++;
			}
		}
		return k-books;
	}
}