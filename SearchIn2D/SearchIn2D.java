package SearchIn2D;

public class SearchIn2D {

    public static void main(String[] args) {
        int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int r=matrix.length;
        int c=matrix[0].length;
        System.out.println(searchElement(matrix, r, c, 3));
    }
    public static boolean searchElement(int [][] matrix,int R,int C,int target){
        
        for(int row=0;row<R;row++){
            if(matrix[row][0]<= target && matrix[row][C-1]>=target && doBinarySearch(matrix[row], 0, C, target)){
                return true;
            }
        }
        return false;
        
    }
    public static boolean doBinarySearch(int [] array,int start,int end,int target){
        int mid = (start+end)/2;
        if(array[mid]==target){
            return true;
        }
        if(start>=end){
            return false;
        }
        if(array[mid]<target && doBinarySearch(array, mid+1, end, target)){
            return true;
        }else if(doBinarySearch(array, start, mid, target)){
            return true;
        }
        return false;
    }
    
}
