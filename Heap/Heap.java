package Heap;

import java.lang.reflect.Array;

public class Heap<T> {
    public int count ;
    public T [] array;

    public Heap(int count,T [] array){
        this.count=count;
        this.array=array;
    }
    public Heap(Class<T> classz,int count){
        this.count=count;
        this.array=(T[])Array.newInstance(classz,count);
    }
    public int getRight(int i){
        if(i<0 || i>=this.count)
            return -1;
        
        if(2*i+2 <this.count)
            return 2*i+2;
        return -1;
    }
    public int getLeft(int i){
        if(i<0 || i>=this.count)
            return -1;
        
        if(2*i+1 <this.count)
            return 2*i+1;
        return -1;
    }
    public T getELe(int i){
        if(i>this.count)
            return null;
        return (T)this.array[i];
    }

}
