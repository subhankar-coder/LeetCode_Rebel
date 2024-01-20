package Recursion.AllPossibleSolution;

import java.util.Stack;

class AllPossibleSolution{
    public static void main(String[] args) {
        String str ="123";
        String [] dict = new String[]{"+","*","-"};
        //printAllSolution(str,0,"",dict,6);
        System.out.println(calculate("1-2-3"));
    }
    public static void printAllSolution(String str,int index,String out,String [] dict,int target){
        if(index==str.length() ){
           System.out.println(out+" "+calculate(out));
          return  ;
        }
        for(int i=index;i<str.length();i++){
            for (String exp : dict){
                if(index==0){
                    printAllSolution(str, i+1,str.substring(index,i+1),dict,target);
                }else{

                    printAllSolution(str, i+1,out+exp+str.substring(index,i+1),dict,target);
                }

            }
        }
    }
    public static int calculate(String str){
        Stack<String> stack=new Stack<>();
        String val="";
        int length=str.length();
        int j=0;
        int start=0;
        while(j<length){
            if(String.valueOf(str.charAt(j)).equals("+") || String.valueOf(str.charAt(j)).equals("-") || String.valueOf(str.charAt(j)).equals("*")){
                stack.push(str.substring(start, j));
                stack.push(String.valueOf(str.charAt(j)));
                start=j+1;             
            }
            j++;
        }
        if(str.length()!=stack.size()){
            stack.push(str.substring(start, j));
        }
        while(stack.size()>1){
            if(stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("*")){
                stack.push(String.valueOf(calculateHelper(stack.pop(),Integer.parseInt(stack.pop()),Integer.parseInt(val))));
               
            }
            else{
                val = stack.pop();
            }
        }
        return Integer.parseInt(stack.peek());
    }
    public static int calculateHelper(String operation,int b,int a){
        switch(operation){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            default:
                return Integer.MAX_VALUE;
        }
        
    }
}