package Array.JumpGame;

public class JumpGame {

    public static void main(String[] args) {
        int [] array = {2,3,1,1,4};
        System.out.println(solve(array,0,array[0]));
    }
    public static boolean solve(int [] array,int source,int k){
        int target=array.length-1;
        for(int i=array.length-1;i>=0;i--){
            int curr=target-i;
            if(curr <= array[i])
            target=i;
            if(target<=0)
                return true;
        }


        return false;
    
    }
    
}
