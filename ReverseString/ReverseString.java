package ReverseString;

public class ReverseString {

    public static void main(String[] args) {
        String str = "";
        System.out.println(solve(str));
    }
    public static String solve(String str){
        if(str.length()==1)
            return str;

        String first = str.substring(0, 1);
        String res = solve(str.substring(1,str.length()));
        return res+first;
    }
    
}
