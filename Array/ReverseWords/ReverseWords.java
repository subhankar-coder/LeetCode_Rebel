package Array.ReverseWords;
import java.util.*;
public class ReverseWords {
    public static void main(String[] args) {
        String word="a good   example";
        int i=0;int j=word.length()-1;
        String temp="";
        String res="";
        while(i<=j){
            if(word.charAt(i)!=' '){
                
                temp+=Character.toString(word.charAt(i));
                if((i+1<j && word.charAt(i+1)==' ')||i==j){
                    StringBuilder str=new StringBuilder();
                    str.append(temp);
                    if(res.equals(""))
                        res=new String(str);
                    else
                        res=new String(str)+" "+res;
                    temp="";
                }
                
            }
            i++;

        }
        System.out.println("The word:"+res+":");
    }
}
