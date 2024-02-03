package DP.SuperUglyNumber;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SuperUglyNumber {
    public static void main(String[] args) {
        int [] primes = {2,3,5,7};
        int pLen = primes.length;
        long [] mulPrimes = new long [pLen];
        for(int i=0;i<pLen;i++){
            mulPrimes[i]=Long.valueOf(primes[i]);
        }
        int [] pIndex = new int [pLen];
        int n = 5911;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int i:primes){
            queue.offer(Long.valueOf(i));
        }
        long [] dp = new long [n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            long min = queue.poll();
            while(!queue.isEmpty() && queue.peek()==min)
                queue.poll();
            dp[i]=min;
            for(int j=0;j<pLen;j++){
                if(min==mulPrimes[j]){
                    pIndex[j]=pIndex[j]+1;
                    mulPrimes[j]=dp[pIndex[j]]*primes[j];
                    queue.offer(mulPrimes[j]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        // System.out.println(Integer.MIN_VALUE);
    }
}
