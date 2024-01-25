package FindDuplicate;

import java.util.Stack;

public class FindDuplicate {
    public static void main(String[] args) {
        // char [][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
       char [][] matrix={{'1'}};
        int n = matrix.length;
        int m = matrix[0].length;
        int [] last=new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            last[i]=Integer.parseInt(Character.toString(matrix[0][i]));
        }
        int i=0;
        do{
            System.out.println(getMaxArea(last));
            if(i+1>=n)
                break;
            last=addArrays(last,matrix[i+1],m);
            i++;
        }while(i<n);
    }
    public static int [] addArrays(int [] last,char [] array,int n){
        for(int i=0;i<n;i++){
            last[i]=last[i]+Integer.valueOf(Character.toString(array[i]));
            if(array[i]=='0'){
                last[i]=0;
            }
        }
        return last;
    }
    public static int getMaxArea(int [] nums){
        int n = nums.length;
        
        int [] left = new int[n];
        int [] right = new int[n];

        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                stack.add(i);
                left[i]=0;
            }else{
                while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                 stack.pop();   
                }
                if(stack.empty()){
                    left[i]=0;
                }else{
                    left[i]=stack.peek()+1;
                }
                stack.add(i);
            }
        }

        stack.clear();
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.add(i);
                right[i]=n-1;
            }else{
                while (!stack.empty() && nums[stack.peek()] >= nums[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()){
                    right[i]=n-1;
                }else{
                    right[i]=stack.peek()-1;
                }
                stack.add(i);
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]*(right[i]-left[i]+1));
        }

        return max;
    }    
}
