package MaxSubSeqScore;

import java.util.*;

public class MaxSubSeqScore {
    public static void main(String[] args) {
        
        int [] nums1={1,3,3,2};
        int [] nums2={2,1,3,4};
        int k=3;
        int n = nums1.length;
        Queue<Value> minHeap = new PriorityQueue<>((a,b)->a.num1-b.num1);
        List<Value> numValues=new ArrayList<>();
        for(int i=0;i<n;i++){
            Value val = new Value(nums1[i], nums2[i]);
            numValues.add(val);
        }

        numValues.sort((o1,o2)->o2.num2-o1.num2);
       

        long res = Long.MIN_VALUE;
        long sum =0;
        // long min=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=numValues.get(i).num1;
            minHeap.add(numValues.get(i));
            // mulHeap.add(numValues.get(i));
            if(minHeap.size()>k){
                sum-=minHeap.poll().num1;
                // mulHeap.remove(val);
            }
            if(minHeap.size()==k){
                res=Math.max(res, sum*numValues.get(i).num2);
            }
        }
        System.out.println(res);
    }

}
class Value{
    int num1;
    int num2;
    public Value(int num1,int num2){
        this.num1=num1;
        this.num2=num2;
    }
}