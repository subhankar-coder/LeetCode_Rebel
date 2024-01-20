package Array.ZigZagArray;
import java.util.*;
public class ZigZagArray {
    public static void main(String[] args) {
        String str="PAYPALISHIRING";
        int i=0;
        int len=str.length();
        int row=4;
        int j=0;
        String res="";
        ArrayList<Character>list;
        HashMap<Integer,ArrayList<Character>> map = new HashMap<>();
        boolean flag=true;
        while(i<len){
            if(!map.containsKey(j))
                map.put(j,new ArrayList<>());
            list=map.get(j);
            if(j==0)
                flag=true;
            if(j<row-1 && flag){
                list.add(str.charAt(i));
                map.put(j,list);
                j++;
            }else{
                list.add(str.charAt(i));
                map.put(j,list);
                flag=false;
                j--;
            }
            i++;
        }
        for(int index=0;index<row;index++){
            
            res+=map.get(index).toString().substring(1,3*map.get(index).size()-1).replaceAll(",","").replaceAll(" ","");
        }  
        
        System.out.println(res);
    }
    
}
