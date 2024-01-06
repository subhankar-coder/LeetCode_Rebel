package DP.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleSumPathDP {
    public static void main(String[] args) {
        List<List<Integer>> triangle= Arrays.asList(Arrays.asList(2),Arrays.asList(3,4),Arrays.asList(6,5,7),Arrays.asList(4,1,8,3));
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(triangle.get(triangle.size()-1));
        getMinPathSum(triangle, dp, triangle.size());
    }
    public static int getMinPathSum(List<List<Integer>> triangle,List<List<Integer>> dp,int n){

        int triIndex=n-2;
        int dpIndex=0;

        while (triIndex>=0 && dpIndex<n) {
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<triangle.get(triIndex).size();i++){
                level.add(Math.min(triangle.get(triIndex).get(i)+dp.get(dpIndex).get(i),triangle.get(triIndex).get(i)+dp.get(dpIndex).get(i+1)));
            }
            dp.add(level);
            dpIndex++;
            triIndex--;
        }

        return dp.get(dp.size()-1).get(0);

    }
    
}
