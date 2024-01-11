package MaxSumCircularSubArray;

public class MaxSumCircularSubArray {
    public static void main(String[] args) {
        int [] array={-5,3,5};
        int n=array.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,array[i]);
            int min=array[i];
            int [] sumArray=new int [n];
            sumArray[0]=array[i];
            int j=(i+1)%n;
            int k=1;
            while(j!=i && k<n){
                max=Math.max(max,sumArray[k-1]+array[j]);
                sumArray[k]=sumArray[k-1]+array[j];
                max=Math.max(max,sumArray[k]-min);
                min=Math.min(min,sumArray[k]);
                k++;
                j=(j+1)%n;
            }
        }
        System.out.println(max);
    }
    
}
