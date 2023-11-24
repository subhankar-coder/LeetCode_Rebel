//not solved

package BackTracking.MaxNoByKSwipe;

public class MaxNoByKSwipe {

    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        String str = "254";
        int k=1;
        solve(str.toCharArray(),k,0,0);
        System.out.println(max); 
    }
    public static void swap(String str,int i,int j){
        char [] array = str.toCharArray();
        char temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    public static void solve(char[] str,int k,int source,int index ){
        if(source==str.length)
            return;
        for(int i=source;i<str.length;i++){
            
            char temp = str[i];
            str[i]=str[source];
            str[source]=temp;
            solve(str,k,source+1,index+1);
            temp = str[i];
            str[i]=str[source];
            str[source]=temp;
        }
    }
    
}
