import java.util.Arrays;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int [] array={-2,1,-3,4,-1,2,1,-5,4};
        int n= array.length;
        int [] sumArray=new int [n];
        int sum=0;
        int max=Integer.MIN_VALUE;
        int min=sumArray[0];

        for(int i=0;i<n;i++){
            max=Math.max(array[i],max);
            sum+=array[i];
            max=Math.max(sum, max);
            sumArray[i]=sum;
            max=Math.max(sumArray[i]-min,max);
            min=Math.min(min,sumArray[i]);
        }
        System.out.println(max);
    }
    
}
