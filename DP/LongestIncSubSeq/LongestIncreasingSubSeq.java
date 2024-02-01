package DP.LongestIncSubSeq;

/*
 *  To get the longest increasing subSeq we need to run a loop form i=1 to n 
 * for every i we need to check the longest subseq till now . that we can do by running a loop j form j=0 to i
 * 
 * and need to check for the largest value form dp[]  s.t. dp[j]>largest and nums[j]>nums[i] , an we can store the largest
 * subseq overall in a variable called min = Math.max(dp[i],min)
 * 
 * the we  can return min
 */



public class LongestIncreasingSubSeq {

    public static void main(String[] args) {
        int [] nums={1,3,6,7,9,4,10,5,6};
        
        int [] dp = new int[nums.length];
        dp[0]=1;
        int min=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            int largest=1;
            int index=-1;
            for(int j=0;j<i;j++){
                if(dp[j]>=largest && nums[i]>nums[j]){
                    index=j;
                    largest=dp[j];

                }
            }
            if(index!=-1)
                dp[i]=largest+1;
            else
                dp[i]=largest;
            
            min=Math.max(dp[i], min);
        }
        System.out.println(min);
    }
    
}
