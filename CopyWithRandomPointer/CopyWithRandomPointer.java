package CopyWithRandomPointer;
import java.util.*;
public class CopyWithRandomPointer{

	 public  Node HEAD;
	public static void main(String ... args){
		
	}
    public Node copyRandomList(Node head) {
        if (head==null){
            return null;
        }
        int i=0;
        HEAD=head;
        int count =0;
        Node tempHead=head.next;
        Node tempHead2=head;
        Node dupHead=new Node(head.val);
        Node dupHead2=dupHead;
        Node dupHead3=dupHead;
        Node dupHead4=dupHead;
        HashMap<Integer,Node> mp=new HashMap<>();
        List<Integer> num= new ArrayList<>();
        while(tempHead!=null){
            dupHead.next=new Node(tempHead.val);
            dupHead=dupHead.next;
            tempHead=tempHead.next;
        }
        while(dupHead3!=null){
            mp.put(count,dupHead3);
            count++;
            dupHead3=dupHead3.next;
        }
        while(tempHead2!=null){
            num.add(nodeNum(tempHead2.random));
            tempHead2=tempHead2.next;
        }
        while(dupHead4!=null){
            if (num.get(i)!=-1){
                dupHead4.random=mp.get(num.get(i));
            } 
            dupHead.random=mp.get(num.get(i));
            dupHead4=dupHead4.next;
            i++;
        }
        return dupHead2;
    }
    public int nodeNum(Node node){
        if (node==null){
            return -1;
        }
        Node head=HEAD;
        int count=0;
        while(head.next!=null){
            if (head==node){
                // System.out.println(node.val+" "+count);
                return count;
            }
            count++;
            head=head.next;
        }
        // System.out.println(node.val+" "+count);
        return count;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}