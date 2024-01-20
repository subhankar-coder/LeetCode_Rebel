package BackTracking.PrintStringWithSpace;
import java.util.*;

public class PrintAllPossibleString {
    public static void main(String[] args) {
        String str ="ABC";
        char [] array = new char [2*str.length()];
        array[0]=str.charAt(0);
        printPattern(1,1,array,str,str.length());


    }
    public static void printPattern(int i,int j,char [] array,String str,int n){
        if(i==n){
            System.out.println(Arrays.toString(array));
            return;
        }
        array[j]=str.charAt(i);
        printPattern(i+1,j+1,array,str,n);
        array[j]=' ';
        array[j+1]=str.charAt(i);
        printPattern(i+1,j+2,array,str,n);
    }
    
}