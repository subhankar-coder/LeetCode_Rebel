package DP.LongestWiggleSeq;

public class LongestWiggleSeq {
    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,2,1,1,1,3,3,3,2,2,2};
        int n = nums.length;
        int res = 1;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]!=0)
                res=Math.max(res,solve(nums, n, nums[i]-nums[i-1],i)+1) ;
        }
        System.out.println(res);
    }
    public static int solve(int []nums ,int n,int lastDiff,int index){
            if(lastDiff==0)
                return 0;

            if(index>=n-1){
                return 1;
            }
            // if(lastDiff)
            int current = nums[index+1]-nums[index];
            int max=1;
            for(int i=index+1;i<n;i++){
               
               current=nums[i]-nums[index];
               if(current!=0){

                   int res = current==0?0:1;
                   // int res2= 0;
                   if((lastDiff<0 && current>0 )||(lastDiff>0 && current<0)){
                       res+=solve(nums, n, current, i);
                           
                   // }else{
                   //     if(nums[i]-nums[index]!=0){
   
                   //     }
                   }
                   max=Math.max(max, res);
               }
            }
        return max;
    }
    
}
