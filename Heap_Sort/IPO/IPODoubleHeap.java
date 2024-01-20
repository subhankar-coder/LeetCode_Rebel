package Heap_Sort.IPO;

import java.util.PriorityQueue;

public class IPODoubleHeap {
    public static void main(String[] args) {
        int k=2;
        int w =0;
        int [] profits={1,2,3,4};
        int [] capital={0,1,1,0};
        
        PriorityQueue<ProfitCapital> minHeap = new PriorityQueue<>((a,b)->a.capital-b.capital);
        PriorityQueue <ProfitCapital> maxHeap = new PriorityQueue<>((a,b)->b.profit-a.profit);
        for(int i=0;i<profits.length;i++){
            minHeap.add(new ProfitCapital(profits[i], capital[i]));
        }

        for(;k>0;k--){
            ProfitCapital peek = minHeap.peek();
            while(peek!=null && peek.capital<=w){
                maxHeap.add(peek);
                minHeap.poll();
                peek=minHeap.peek();
            }
            if(maxHeap.isEmpty())
                break;
            w+=maxHeap.poll().profit;
        }
        System.out.println(w);
    }
    
}
