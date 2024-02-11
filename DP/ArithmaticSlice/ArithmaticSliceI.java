package DP.ArithmaticSlice;

public class ArithmaticSliceI {

        static int count;
        public static void main(String[] args) {
            int [] nums ={1,2,3,4};
            int n = nums.length;
            for(int i=0;i<n-2;i++)
                System.out.println(solve(nums, i+1, n, nums[i+1]-nums[i]));
            
        }
        public static int solve(int [] nums,int index,int n,int lastDiff){
            if(index>=n )
                return 0;

            if(index+1>=n)
                return 0;
            
            int count=0;
            if(nums[index+1]-nums[index]==lastDiff){
                
                count+=1+solve(nums, index+1, n, nums[index]-nums[index-1]);
            }
            return count;
        }
}
