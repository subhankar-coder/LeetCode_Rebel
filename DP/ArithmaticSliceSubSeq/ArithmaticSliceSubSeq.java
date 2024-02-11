package DP.ArithmaticSliceSubSeq;

import java.util.*;

public class ArithmaticSliceSubSeq {

    static Map<String,Integer> map;
    public static void main(String[] args) {
        // int [] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int [] nums={2,2,3,4};
        int n=nums.length;
        // int res =0;
        // map = new HashMap<>();
        // for(int i=0;i<n-2;i++)
        //          res+=solve(nums, i, nums.length, 0, Integer.MIN_VALUE,0);


        // System.out.println(res);
        totalArithMaticSubseq(nums, n);
        }

    public static  int solve(int [] nums,int index,int n,int rec,long lastDiff,int lastIndex){
           String key = index+" "+rec+" "+lastDiff;
            if(index==n-1){
            
                return Long.valueOf(nums[n-1])-Long.valueOf(nums[lastIndex] )==lastDiff &&rec>=2?1:0;
            }
            if(map.containsKey(key))
                return map.get(key);
            if(index>=n)
                return 0;
            int count=rec>=2?1:0;
            for(int i=index+1;i<n;i++){
                if(lastDiff==Integer.MIN_VALUE || lastDiff==Long.valueOf(nums[i])-Long.valueOf(nums[index] )){
                    count += solve(nums, i, n, rec+1,lastDiff==Integer.MIN_VALUE?Long.valueOf(nums[i])-Long.valueOf(nums[index]):lastDiff,index);           
                }
            }
            map.put(key,count);
            return count;
        }

        public static void totalArithMaticSubseq(int [] nums,int n){

            int count=0;
            Map<Long,Integer> [] map = new HashMap[n];

            map[0]=new HashMap<>();

            for(int i=1;i<n;i++){
                map[i]=new HashMap<>();
                for(int j=0;j<i;j++){
                    Long diff = 1l*nums[i]-1L*nums[j];
                    if(map[j].containsKey(diff)){
                        if(map[i].containsKey(diff))
                            map[i].put(diff,  map[j].get(diff)+map[i].get(diff));
                        else
                            map[i].put(diff, map[j].get(diff)+1);
                        count+=(map[j].get(diff)-1);
                    }else{
                        if(map[i].containsKey(diff))
                            map[i].put(diff, map[i].get(diff)+1);
                        else
                            map[i].put(diff,2);
                    }
                }
            }
            // for(Map<Long,Integer> mp:map)
            //     System.out.println(mp);
            System.out.println(count);
        }
}
