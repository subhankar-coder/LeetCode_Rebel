package Array.BestTimeToBuyAndSellStocks;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        int [] array = {7, 1, 5, 3, 6, 4};
        int buy=array[0];
        int maxProfit=0;
        for(int i=0;i<array.length;i++){
            if(array[i]-buy > maxProfit){
                maxProfit=array[i]-buy;
            }else if(buy>array[i]){
                buy=array[i];
            }
            
        }
        System.out.println(maxProfit);
    }
    
}
