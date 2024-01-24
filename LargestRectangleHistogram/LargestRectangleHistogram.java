package LargestRectangleHistogram;

import java.util.*;
public class LargestRectangleHistogram {
    public static void main(String[] args) {
        
        // int [] heights={10,10,4,8,12,13,3,14,8,16,6,12,7,19,17,2,2,11,10,12};
        int [] heights={2,1,5,6,2,3};
        int n = heights.length;
        int area = heights[0];

        List<Histogram> stack=new ArrayList();
        stack.add(new Histogram(0, heights[0]));
        
        for(int i=1;i<n;i++){
            if(stack.get(stack.size()-1).value>= heights[i]){
                Histogram top=null;
                while(!stack.isEmpty() && stack.get(stack.size()-1).value>=heights[i]){
                    top=stack.remove(stack.size()-1);
                }
                area=Math.max(area,heights[i]*(i-top.index+1));
                if(!stack.isEmpty()){
                    for(int j=0;j<stack.size();j++){
                        area=Math.max(area, Math.max(stack.get(j).value*(i-stack.get(j).index+1), heights[i]));
                       }
                }
                Histogram ele = new Histogram(top.index, heights[i]);
                stack.add(ele);
            }else {
                // area=Math.max(area, Math.max(heights[i], stack.peek().value*(i-stack.peek().index+1)));
               for(int j=0;j<stack.size();j++){
                area=Math.max(area, Math.max(stack.get(j).value*(i-stack.get(j).index+1), heights[i]));
               } 
                stack.add(new Histogram(i, heights[i]));
            }
        }
        // System.out.println(area);
        largestRectangleArea(heights);
    }
    public static int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int []leftMin = new int[n];
        int []rightMin= new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                leftMin[i]=0;
                st.push(i);
            }else{
                while (!st.isEmpty() && heights[st.peek()]>=heights[i]) {
                    st.pop();
                }
                if(st.isEmpty()){
                    leftMin[i]=0;
                    st.push(i);
                }else{
                    leftMin[i]=st.peek()+1;
                    st.push(i);
                }
            }
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                rightMin[i]=n-1;
                st.push(i);
            }else{
                while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    rightMin[i]=n-1;
                    st.push(i);
                }else{
                    rightMin[i]=st.peek()-1;
                    st.push(i);
                }
            }
        }
        int maxArea=0;
        for(int i=0;i<n;i++){
            maxArea=Math.max(maxArea, heights[i]*(rightMin[i]-leftMin[i]+1));
        }
        System.out.println(maxArea);
        return 0;
    }    
}

class Histogram{
    int index ;
    int value;
    public Histogram(int index,int value){
        this.index=index;
        this.value=value;
    } 
}
