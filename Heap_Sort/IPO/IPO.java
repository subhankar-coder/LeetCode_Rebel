package Heap_Sort.IPO;


import java.io.Console;

import Heap.Heap;

class ProfitCapital{
    int profit;
    int capital;
    public ProfitCapital(int profit,int capital){
        this.profit=profit;
        this.capital=capital;
    }
    @Override
    public String toString(){
        return this.capital+" "+this.profit;
    }
}
public class IPO {

    public static void main(String[] args) {
        int w=0;
        int k=2;
        int [] profits={1,2,3};
        int [] capital={0,1,1};
        int n = capital.length;
        ProfitCapital [] profitCapitals=new ProfitCapital[n];
        for(int i=0;i<n;i++){
            ProfitCapital profitCapital=new ProfitCapital(profits[i],capital[i]);
            profitCapitals[i]=profitCapital;
        }
       Heap heap = new Heap(n,profitCapitals);

       for(;k>0 && heap.count>0;k--){
            for(int i=(heap.count-1)/2;i>=0;i--){

                prelocateDown(heap,i,w);

            }
            ProfitCapital res =( ProfitCapital)heap.getELe(0);
            // System.out.println(res.profit);
            if(res.capital<=w)
                w+=res.profit;
            ProfitCapital last = (ProfitCapital) heap.getELe(heap.count-1);
            heap.count--;
            heap.array[0]=last;
            ProfitCapital [] newProfile= new ProfitCapital[heap.count];
            System.arraycopy(heap.array, 0, newProfile, 0, heap.count);
            heap.array=newProfile;
        }
        System.out.println(w);

    }
    public static void  prelocateDown(Heap heap,int i,int w){
        int l,r,max;

        l=heap.getLeft(i);
        r=heap.getRight(i);

        if(l==-1 && r==-1)
            return ;
    
        max=-1;
        int maxProfit=Integer.MIN_VALUE;
        ProfitCapital leftEle = l!=-1?(ProfitCapital) heap.getELe(l):null;
        ProfitCapital rightEle = r!=-1?(ProfitCapital)heap.getELe(r):null;
        // ProfitCapital maxEle = max!=-1?(ProfitCapital) heap.getELe(max):null;

        if(l!=-1 && leftEle!=null  && leftEle.capital<=w && maxProfit<leftEle.profit){
            max=l;
            maxProfit=leftEle.profit;
        }
        if(r!=-1 && rightEle!=null  && rightEle.capital<=w && maxProfit<rightEle.profit){
            max=r;
            maxProfit=rightEle.profit;
        }
        ProfitCapital beginEle = i!=-1?(ProfitCapital) heap.getELe(i):null;
        if(i!=-1 &&  beginEle.capital<=w && maxProfit<beginEle.profit){
            max=i;
            maxProfit=beginEle.profit;
        }

        
        if(max!=i && max!=-1){

            ProfitCapital temp = (ProfitCapital)heap.array[i];
            heap.array[i]=heap.array[max];
            heap.array[max]=temp;
            
            prelocateDown(heap, max, w);
        }
        
        
    }
}
