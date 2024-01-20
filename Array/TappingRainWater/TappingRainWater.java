package Array.TappingRainWater;

public class TappingRainWater {
    public static void main(String[] args) {
        int [] array={4,2,0,3,2,5};
        int [] upMax=new int [array.length];
        int [] downMax= new int[array.length];
        int up=0;
        int down=0;
        for(int i=0,j=array.length-1;i<array.length && j>=0 ;i++,j--){
            upMax[i]=up;
            up=Math.max(up,array[i]);
            downMax[j]=down;
            down=Math.max(down,array[j]);
        }
        int sum=0;
        for(int i=0;i<array.length;i++){
            if(Math.min(upMax[i],downMax[i])-array[i]>0){
                sum+=Math.min(upMax[i],downMax[i])-array[i];
            }
        }
        System.out.println(sum);
    }
    
}
