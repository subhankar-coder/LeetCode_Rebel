package Array.IntegerToRoman;
import java.util.*;
public class IntegerToRoman {
    public static void main(String[] args) {
        int num=1994;
        String res ="";
        HashMap<Integer,String> romanToInt=new HashMap<>();
        romanToInt.put(1,"I");
        romanToInt.put(5,"V");
        romanToInt.put(10,"X");
        romanToInt.put(50,"L");
        romanToInt.put(100,"C");
        romanToInt.put(500,"D");
        romanToInt.put(1000,"M");

        Integer [] keys={1,5,10,50,100,500,1000};
        int subIndex=4;
        for(int j=6;j>=0;j--){
            
            if(num!=0 && (num / keys[j])!=0){
                
                for(int i=0;i<num/keys[j];i++){
                    res+=romanToInt.get(keys[j]);
                }
                num=num%keys[j];
            }
            subIndex=getSubIndex(num);
            int index=keys[j]-keys[subIndex];
            if( num!=0 && num/index!=0){
                res+=romanToInt.get(keys[subIndex])+romanToInt.get(keys[j]);
                num=num%index;
            }
        }
        System.out.println(res);
    }
    public static int getSubIndex(int num){
        if(num>=4 && num<10){
            return 0;
        }else if(num>=40 && num<100){
            return 2;
        }else {
            return 4;
        }
    }
    
}
