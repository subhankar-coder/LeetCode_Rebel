package BackTracking.NCombination;
import java.util.*;
public class nCombinationOfString {
    public static void main(String[] args) {
        int r=3;
        char [] res = new char [r];
        String str = "12345";
        printAllCombination(str,0,str.length(),3,0,res);
    }
    public static void printAllCombination(String str,int start,int n,int r,int index,char [] res){
        if(start==r){
            System.out.println(Arrays.toString(res));
            return;
        }
        if(index>=n)
            return;
        res[start]=str.charAt(index);
        printAllCombination(str,start+1,n,r,index+1,res);
        printAllCombination(str,start,n,r,index+1,res);        
    }
    
}
