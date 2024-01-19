package Heap_Sort.MedianFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {

    public static void main(String[] args) {
        //5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4
        MedianFinderClass medianFinderClass=new MedianFinderClass();
        medianFinderClass.addNum(40);
        System.out.println(medianFinderClass.findMedian());
        medianFinderClass.addNum(12);
        System.out.println(medianFinderClass.findMedian());
        medianFinderClass.addNum(16);
        System.out.println(medianFinderClass.findMedian());
        medianFinderClass.addNum(4);
        System.out.println(medianFinderClass.findMedian());
        medianFinderClass.addNum(5);
        System.out.println(medianFinderClass.findMedian());
        medianFinderClass.addNum(6);
        System.out.println(medianFinderClass.findMedian());
        medianFinderClass.addNum(7);
        System.out.println(medianFinderClass.findMedian());
        medianFinderClass.addNum(8);
        System.out.println(medianFinderClass.findMedian());
        medianFinderClass.addNum(9);
        System.out.println(medianFinderClass.findMedian());
        medianFinderClass.addNum(10);
        System.out.println(medianFinderClass.findMedian());
        // medianFinderClass.addNum(0);
        // System.out.println(medianFinderClass.findMedian());
        // medianFinderClass.addNum(4);
        // System.out.println(medianFinderClass.findMedian());
    }
    
}
class MedianFinderClass {
    PriorityQueue<Integer> minHeapRight ;
    PriorityQueue<Integer> maxHeapLeft;

    public MedianFinderClass() {
        this.minHeapRight=new PriorityQueue<>((a,b)->a-b);
        this.maxHeapLeft=new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        if(maxHeapLeft.isEmpty() ){
            maxHeapLeft.add(num);
            return;
        }
        if(minHeapRight.isEmpty()){
            if( num>maxHeapLeft.peek())
                minHeapRight.add(num);
            else{
                minHeapRight.add(maxHeapLeft.poll());
                maxHeapLeft.add(num);
            }
            return;
        }
        if(!minHeapRight.isEmpty() && num>=minHeapRight.peek()){
            minHeapRight.add(num);
            if(minHeapRight.size()>maxHeapLeft.size()){
                maxHeapLeft.add(minHeapRight.poll());
            }
            return;
        }else{
            maxHeapLeft.add(num);
            if(maxHeapLeft.size()>minHeapRight.size()+1){
                minHeapRight.add(maxHeapLeft.poll());
            }
        }
    }
    
    public double findMedian() {
        if(maxHeapLeft.size()>minHeapRight.size()){
            return maxHeapLeft.peek();
        }
        return (minHeapRight.peek()+maxHeapLeft.peek())/2.0;
    }

    // 5 10 5 4 3 4 5 6 7 6.5 7 6.5
}

