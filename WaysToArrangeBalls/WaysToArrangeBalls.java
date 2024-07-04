package WaysToArrangeBalls;

public class WaysToArrangeBalls {

    private static int count=0;
    public static void main(String[] args) {
        int a=2,b=2,c=2;

        System.out.println(solve(a, b, c,-1,""));
        

        
    }
    public static int solve(int a,int b,int c,int last,String res){
        
        if(a+b+c==0){
            return 1; 
        }
        int aresponse=0,bresponse=0,cresponse=0;
        for(int i=0;i<3;i++){
            if(i!=last){
                if(i==0 && a>0)
                    aresponse=solve(a-1, b, c,  0,res+"A");
                else if(i==1 && b>0)
                    bresponse=solve(a, b-1, c,  1,res+"B");
                else if(i==2 && c>0)
                    cresponse= solve(a, b, c-1,  2,res+"C");
            }
        }

        return aresponse+bresponse+cresponse;

    }
    
}
