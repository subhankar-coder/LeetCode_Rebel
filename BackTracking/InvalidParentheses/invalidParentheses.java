package BackTracking.InvalidParentheses;

import java.util.*;

public class invalidParentheses {
    public static void main(String[] args) {
        String str = "()())()";
        solveUsingBFS(str);
    }
    public static boolean isParentheses(char c){
        if(c=='(' || c==')')
            return true;

        return false;
    }
    public static boolean isValidString(String str){
        int len = str.length();
        int count =0;
        for(int i=0;i<len;i++){
            if(str.charAt(i)=='(')
                count++;
            else if(str.charAt(i)==')')
                count--;
            if(count<0)
                return false;
        }
        return count==0;
    }
    public static void solveUsingBFS(String str){
        Queue<String> q= new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(str);
        visited.add(str);
        while(!q.isEmpty()){
            String curr = q.peek();
            q.remove();
            int len= curr.length();
            // boolean flag=false;
            if(isValidString(curr)){
                System.out.println(curr);
                continue;
            }
            // if(flag)
            //     continue;
            for(int i=0;i<len;i++){
                if(!isParentheses(curr.charAt(i)))
                    continue;
                String temp = curr.substring(0,i)+curr.substring(i+1);
                if(!visited.contains(temp)){
                    visited.add(temp);
                    q.add(temp);
                }

            }
        }

    }
}
