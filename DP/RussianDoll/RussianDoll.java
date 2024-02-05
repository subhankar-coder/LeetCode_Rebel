package DP.RussianDoll;

import java.util.*;

public class RussianDoll {

    public static void main(String[] args) {
        
        int [][] envelops = {{9,8},{7,4},{6,8},{4,5},{7,5}};
        int n = envelops.length;
        List<Envelop> envelopList = new ArrayList<>();
        for(int i=0;i<n;i++){
            envelopList.add(new Envelop(envelops[i][0], envelops[i][1]));
        }
        BSTImp(envelopList,n);
        envelopList.sort(Comparator.comparing(Envelop::getHeight).thenComparing(Envelop::getWidth));
        int [] dp = new int[n];
        int res = 1;
        dp[0]=1;

        for(int i=1;i<n;i++){
            int max=1;
            for(int j=0;j<i;j++){
                // if(j<i){
                if(envelopList.get(j).height < envelopList.get(i).height && envelopList.get(j).width<envelopList.get(i).width){
                    max=Math.max(max,dp[j]+1);
                }
            }
            dp[i]=max;
            res=Math.max(res,dp[i]);
           
        }
        // System.out.println(Arrays.toString(dp));
    }
    public static void BSTImp(List<Envelop> envelopList,int n ){
        envelopList.sort(Comparator.comparing(Envelop::getWidth).thenComparing(Envelop::getHeight));
        
        // int [] dp = new int[n];
        List<Integer> dp = new ArrayList<>();
        dp.add(envelopList.get(0).height);

        for(int i=1;i<n;i++){
            if(envelopList.get(i).height>dp.get(dp.size()-1)){
                dp.add(envelopList.get(i).height);
            }else{
                int pos = Collections.binarySearch(dp,envelopList.get(i).height);
                if(pos<0){
                    pos = -(pos+1);
                }
                dp.set(pos, envelopList.get(i).height);
            }
        }
        System.out.println(dp.size());
    }
    
}

class Envelop{

    public int height;
    public int width;

    public Envelop(int height,int width){
        this.height=height;
        this.width=width;
    }
    public int getHeight(){
        return  -this.height;
    }
    public int getWidth(){
        return this.width;
    }
    @Override
    public String toString(){
        return "height "+this.height+" width "+this.width;
    }
}
