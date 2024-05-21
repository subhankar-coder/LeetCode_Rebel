package PaintHouse;

public class PaintHouse {

    public int paintHouse(int [][] array){
        int previous_red = array[0][0];
        int previous_blue= array[0][1];
        int previous_green = array[0][2];
        int current_red=0;
        int current_blue=0;
        int current_green=0;
        
        for(int i=1;i<array.length;i++){
            
            current_red = Math.min(previous_blue,previous_green)+array[i][0];
            current_blue=Math.min(previous_green,previous_red)+array[i][1];
            current_green=Math.min(previous_blue,previous_red)+array[i][2];
            
            previous_red=current_red;
            previous_blue=current_blue;
            previous_green=current_green;
            
        }
        return Math.min(previous_red,Math.min(previous_blue,previous_green));
    }
    
}
