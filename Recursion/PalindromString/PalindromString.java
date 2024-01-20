import java.util.*;
import java.io.*;

public class PalindromString {
    public static void main(String [] args  ){
        String str ="geeks";
        ArrayList<String> out= new ArrayList<>();
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        palindromPartHelper(str,0,"",res);
        System.out.println(res);
        
    }
    public static void palindromPartHelper(String str,int index,String out,ArrayList<ArrayList<String>> res){
        if (index == str.length()){
            String [] arr = out.split(" ");
            List<String> list = Arrays.asList(arr);
            list=list.subList(1,list.size());
            res.add(new ArrayList<>(list));
        }
        for (int i=index;i<str.length();i++){
            if (isPalindrom(str.substring(index,i+1))){
                palindromPartHelper(str,i+1,out+" "+str.substring(index,i+1),res);
                
            }
            
        }
    }
    public static boolean isPalindrom(String str){
        int len = str.length();
        int i=0;
        int j = len-1;
        while(i<=j){
            if (str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
                    
        }
        return true;
    }
}