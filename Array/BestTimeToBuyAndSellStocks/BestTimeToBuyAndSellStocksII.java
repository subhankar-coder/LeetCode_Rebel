package Array.BestTimeToBuyAndSellStocks;

public class BestTimeToBuyAndSellStocksII {
    public static void main(String[] args) {
        int []array = {7,1,5,3,6,4};
        int buy=array[0];
        int maxProfit=0;
        int buy1=array[0];
        int maxProfit1=0;
        for(int i=0;i<array.length;i++){
            if(array[i]-buy1>maxProfit1){
                maxProfit1=array[i]-buy1;
            }else if(buy1>array[i])
                buy1=array[i];
        }
        for(int i=0;i<array.length;i++){
            if(array[i]-buy>0){
                maxProfit+=array[i]-buy;
                buy=array[i];
            }else if(buy>array[i]){
                buy=array[i];
            }
        }
        System.out.println(Math.max(maxProfit,maxProfit1));
    }
}
