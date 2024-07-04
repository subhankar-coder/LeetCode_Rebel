package BoxStackingProblem;

import java.util.*;


public class BoxStackingSingleInstanceOfBox{

	public static void main(String[] args) {
		
	}
	public int maxHeight(int[][] cuboids) {

        int n = cuboids.length;
        for(int i=0;i<n;i++){
            Arrays.sort(cuboids[i]);
        }

        Arrays.sort(cuboids,new Comparator<int []>(){

            public int compare(int [] a,int [] b){
                
                if(a[0]!=b[0]){
                    return b[0]-a[0];
                }else{
                    if(b[1]!=a[1]){
                        return b[1]-a[1];
                    }else{
                        if(b[2]!=a[2]){
                            return b[2]-a[2];
                        }
                    }
                }
                return 0;
            }
        });
        
        int [] dp = new int [n];
        int maxHeight=-1;


        // for(int [] arr:cuboids){
        //     System.out.println(Arrays.toString(arr));
        // }

        for(int i=0;i<n;i++){
            int val =0;
            for(int j=0;j<i;j++){
                if(cuboids[i][0]<=cuboids[j][0] && cuboids[i][1]<=cuboids[j][1] && cuboids[i][2]<=cuboids[j][2]){
                    val = Math.max(val,dp[j]);
                }
            }
            dp[i]=val+cuboids[i][2];
            maxHeight=Math.max(maxHeight,dp[i]);
        }

        // System.out.println(Arrays.toString(dp));
        return maxHeight;
    }
}