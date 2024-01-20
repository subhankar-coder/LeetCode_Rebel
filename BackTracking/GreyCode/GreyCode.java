package BackTracking.GreyCode;
import java.util.*;

public class GreyCode {
    public static void main(String[] args) {
        int n=3;
        String str ="";
        for(int i=0;i<n;i++){
            str+="0";
        }
        List<Integer> result=new ArrayList<>();
        generateGrayCode(str,n,result);
        System.out.println(result);
    }
    public static String reverseBit(String str,int pos){
        char [] stringArray=str.toCharArray();
        if(str.charAt(pos)=='0'){
            stringArray[pos]='1';
        }else{
            stringArray[pos]='0';
        }
        return new String(stringArray);
            
    }
    public static void generateGrayCode(String str,int n,List<Integer> result){
        if(!result.contains(Integer.parseInt(str,2)))
                result.add(Integer.parseInt(str,2));
            else
                return;
        for(int i=n-1;i>=0;i--){
            String res = reverseBit(str,i);
            generateGrayCode(res,n,result);
        }
    }
    
}
