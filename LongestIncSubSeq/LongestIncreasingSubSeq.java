package LongestIncSubSeq;

public class LongestIncreasingSubSeq {

    public static void main(String[] args) {
        int [] nums={1,3,6,7,9,4,10,5,6};
        
        int [] dp = new int[nums.length];
        dp[0]=1;
        int min=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            int largest=1;
            boolean isFound= false;
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
