package DP.MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {

        int [][] intervals = {{0,2},{1,3},{2,3},{3,5},{4,6}};
        int n = intervals.length;

        Arrays.sort(intervals,new Comparator<int [] >() {

            @Override
            public int compare(int[] o1, int[] o2) {
               if(o1[0]==o2[0])
                    return o1[1]-o2[1];
                else
                    return o1[0]-o2[0];
            }
        });
        int count =0;
        int end = intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<end){
                end=Math.min(end,intervals[i][1]);
                count++;
            }else{
                end = intervals[i][1];
            }
        }
        System.out.println(count);
    }
}
