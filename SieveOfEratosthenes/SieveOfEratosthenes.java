package SieveOfEratosthenes;


import java.util.*;


public class SieveOfEratosthenes{

	public static void main(String[] args) {
		
		int n=1;
		
		boolean [] primes = new boolean [n];
		Arrays.fill(primes,true);

		int count =1;
		for(int p =2;p*p<n;p++){

			if(primes[p]==true){
				for(int i=p*p;i<n;i+=p){
					if(primes[i]==true){

						primes[i]=false;
						count++;
					}
				}
			}
		}
		System.out.print(n-count-1);

	}
}