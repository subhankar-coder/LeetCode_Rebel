package BackTracking.GenerateParentheses;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n=3;
        generateParentheses(0,0,"",n);
    }
    public static void generateParenthesesDFS(String res,int left,int right){
        if(right==0 && left==0){
            System.out.println(res);
            // return;
        }
        if(left<0 || right<0  || right<left)
            return;
        res+="(";
        generateParenthesesDFS(res, left-1, right);
        res=res.substring(0,res.length()-1);

        res+=")";
        generateParenthesesDFS(res,left,right-1);
        res=res.substring(0,res.length()-1);
        
    }
    public static void generateParentheses( int right,int left,String res,int n){
        
        if(res.length()==2*n){
            System.out.println(res);
        }
        if(left<n){
            generateParentheses(right, left+1, res+"(", n);
        }
        if(left>right){
            generateParentheses(right+1, left, res+")", n);
        }
        // res=res.substring(0, res.length()-1);
    }
    
}
