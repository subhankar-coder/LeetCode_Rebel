/* 
 * 
 * We need to get the max amount of money Robber can take without alarming the police (if robber rob from two consecutive house )
 * And the houses are in a circular ring (i.e. the last one is in a loop with the first one)
 * 
 * To solve it we need to traverse through the array from i=2 to i=n-1
 * each time we need to check from j=0 to j<i-1 from dp[] to check the max amount robbed till now . also we are tracking 
 * wheather the robber has robbed the first house or not.
 * 
 * At the same time we have also took one array which elementes the first house and start from j=1 to j<i-1 and store the max Robbed
 * without the first home to array dpWithoutFirst [] .
 * 
 * we can return the answer as  max(max(dp[]),max(dpWithoutFirst[]))
 */

package DP.HouseRobberII;

public class HouseRobberII {
    public static void main(String[] args) {
        int [] nums = {8,4,8,5,9,6,5,4,4,10};

        int n = nums.length;
        LastTrail [] dp = new LastTrail[n];
        int [] dpWithoutFirst = new int[n];
        dpWithoutFirst[0]=nums[0];
        dpWithoutFirst[1]=nums[1];
      
        dp[0]=new LastTrail(nums[0],0);
        int res =dp[0].value;
        dp[1]=new LastTrail(nums[1],1);
        res=Math.max(res, dp[1].value);
        
        
        for(int i=2;i<n;i++){
        LastTrail lastTrail=null;
        int max = 0;
        int maxWithoutFirst=0;
            for(int j=0;j<i-1;j++){
                if(i==n-1 && dp[j].lastIndex==0 ){
                    if(max<=dp[j].value-nums[0]){
                        lastTrail=dp[j];
                        max=dp[j].value-nums[0];
                    }
                }else{

                    if(max<=dp[j].value ){
                        lastTrail=dp[j];
                        max=dp[j].value;
                    }
                }
                if(j!=0){
                    maxWithoutFirst=Math.max(maxWithoutFirst, dpWithoutFirst[j]);
                }
            }
            dp[i]=new LastTrail(max+nums[i], lastTrail.lastIndex);
            dpWithoutFirst[i]=maxWithoutFirst+nums[i];
            res=Math.max(res, dp[i].value);
            res=Math.max(res, dpWithoutFirst[i]);
        }

        System.out.println(res);
        // System.out.println(Arrays.toString(dp));
        // System.out.println(Arrays.toString(dpWithoutFirst));
    }    
}

class LastTrail{
    public int value;
    public int lastIndex;

    public LastTrail(int value,int lastIndex){
        this.lastIndex=lastIndex;
        this.value=value;
    }

    // @Override
    // public String toString(){
    //     return "Value  "+value+" LastIndex "+lastIndex;
    // }
}
