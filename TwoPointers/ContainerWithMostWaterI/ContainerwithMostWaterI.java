package TwoPointers.ContainerWithMostWaterI;

public class ContainerwithMostWaterI {
    public static void main(String[] args) {
        int [] height={1,2,1};
        int i=0;
        int j=height.length-1;
        int maxArea=Integer.MIN_VALUE;
        while(i<j){
            maxArea=Math.max(maxArea,Math.min(height[i],height[j])*(j-i));
            if(height[j]<height[i])
                j--;
            else
                i++;
        }
    }
    
}
