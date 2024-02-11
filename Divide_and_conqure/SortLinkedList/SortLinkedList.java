package Divide_and_conqure.SortLinkedList;

import LinkedList.Node.Node;

public class SortLinkedList {
    public static void main(String[] args) {
        int [] nums = {4,2,1,3};
        int n=nums.length;
        int i=1;
        Node node=new Node(nums[0]);
        while(node!=null && i<n){
            node.next=new Node(nums[i]);
            node=node.next;
            i++;
        }
    }
    public void sortLinkedList(Node node){
        
    }
    
}
