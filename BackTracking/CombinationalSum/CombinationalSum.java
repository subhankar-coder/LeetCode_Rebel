package BackTracking.CombinationalSum;
import java.util.*;

public class CombinationalSum {
    private static ArrayList<Integer> res;
    public static void main(String[] args) {
        int [] array= {2,4,6,8};
        int target = 8;
        res=new ArrayList<>();
        solve(array,target,0,0);
    }
    public static void solve(int [] array,int target,int source,int index){
        if(target==0){
            System.out.println(res);
        }
        if(index==array.length)
            return;
        for(int i=source;i<array.length;i++){
            res.add(array[i]);
            solve(array,target-array[i],i,index+1);
            res.remove(res.size()-1);
        }
    }
    
}
