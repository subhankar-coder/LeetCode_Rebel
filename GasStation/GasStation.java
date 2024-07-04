package GasStation;

import java.util.*;

public class GasStation{
	public static void main(String[] args) {
		int [] petrol = {6,3,7};
		int [] distance ={4,6,3};
		int n = petrol.length;

		solve(petrol,distance,n);
	}
	public static void solve(int [] petrol,int [] distance,int n){

		int [] diff = new int [n];
		for(int i=0;i<n;i++){
			diff[i]=petrol[i]-distance[i];
		}

		int [] sum = new int [n+(n-1)];

		sum[0]=diff[0];

		for(int i=1;i<2*n-1;i++){
			sum[i]=sum[i-1]+diff[i%n];
		}
		
		int i=0,j=0;
		boolean isContinuous=true;
		int prefix=0;

		while(i<2*n-1){
			
		}	
	}
}