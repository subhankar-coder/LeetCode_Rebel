package Sort.MergeSort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] array={12, -1,11, 13,0, 5, 15, 13};
        int n=array.length;
        int res []=mergeSort(array, 0, n-1);
        System.out.println(Arrays.toString(res));
    }
    public static int [] mergeSort(int [] array,int start,int end){
        if(start>=end){
            int [] partial=Arrays.copyOfRange(array, start,end+1);
            return partial;
        }
        int mid=(start+end)/2;
        int [] left=mergeSort(array, start, mid);
        int [] right=mergeSort(array, mid+1, end);

        int mergeLength=left.length+right.length;
        int [] parial= new int[mergeLength];
        
        for(int i=0,l=0,r=0;i<mergeLength && (l<left.length || r<right.length);i++){
            if(l>=left.length && r<right.length){
                parial[i]=right[r++];
            }
            if(r>=right.length && l<left.length){
                parial[i]=left[l++];
            }
            if(l<left.length && r<right.length){
                if(left[l]<right[r]){
                    parial[i]=left[l++];
                }else{
                    parial[i]=right[r++];
                }
            }
        }
        return parial;
    }
    
}
