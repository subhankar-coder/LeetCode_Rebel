package Array.JumpGameII;

public class JumpGameII{
    public static void main(String[] args) {
        int [] array={4,1,1,3,1,1,1};
        System.out.println(solve(array));
    }
    public static int solve(int [] array){
        
        int [] dp = new int [array.length];
        dp[array.length-1]=0;
        for(int i=array.length-1;i>=0;i--){
            if(i==array.length-1)
                continue;
            if(i+array[i]>=array.length-1){
                dp[i]=1;
            }
                
            else{
                int min= dp[i+1];
                for(int j=i+1;j<=i+array[i];j++){
                    min=Math.min(min, dp[j]);
                }
                dp[i]=min+1;
                
            }
            
        }
        return dp[0];
    }
}