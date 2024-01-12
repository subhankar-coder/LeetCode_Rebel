package MaxSumCircularSubArray;

public class MaxSumCircularSubArray {
    public static void main(String[] args) {
        int [] array={9,-4,-7,9};
        int n= array.length;
        int sum=array[0];
        int max_till_now=array[0];
        int min_till_now=array[0];
        int max_overall=array[0];
        int min_overall=array[0];

        for(int i=1;i<n;i++){
            sum+=array[i];
            max_till_now=Math.max(max_till_now+array[i],array[i] );
            max_overall=Math.max(max_overall, max_till_now);
            min_till_now=Math.min(min_till_now+array[i], array[i]);
            min_overall=Math.min(min_till_now, min_overall);
        }

        
        if(min_overall==sum)
            System.out.println(max_overall);
        System.out.println(Math.max(max_overall, sum-min_overall));
    }
    
}
