package RemoveConsecutiveNodeWithZeroSum;

import java.util.*;

public class RemoveConsecutiveNodeWithZeroSum{
  public static void main(String[] args) {
  
//  	1,3,2,-3,-2,5,5,-5,1
  	ListNode head = new ListNode(1);
  	head.next = new ListNode(3);
  	head.next.next=new ListNode(2);
  	head.next.next.next = new ListNode(-3);
  	head.next.next.next.next=new ListNode(-2);
  	head.next.next.next.next.next=new ListNode(5);
  	head.next.next.next.next.next.next=new ListNode(5);
  	head.next.next.next.next.next.next.next=new ListNode(-5);
  	head.next.next.next.next.next.next.next.next = new ListNode(1);
  	
  	
  	ListNode dupHead = new ListNode(-100001);
  	dupHead.next=head;
  	  
  	Map<Integer,ListNode> map = new HashMap<>();
  	map.put(0,dupHead);
  	int sum =0;
  	Set<ListNode> deleted=new HashSet<>();
  	while(head!=null){
  		sum+=head.val;
  		if(map.containsKey(sum) && !deleted.contains(map.get(sum))){
  			ListNode temp = map.get(sum);
  			ListNode dup = temp.next;
  			while(dup!=head.next){
  				deleted.add(dup);
  				dup=dup.next;
  			}
  			temp.next = head.next;
  			
  		}else{
  			map.put(sum,head);
  		}
  		head = head.next;
  	}
  	while(dupHead!=null){
  		System.out.println(dupHead.val);
  		dupHead=dupHead.next;
  		
  		
  	}
  }
}

  public class ListNode {
      int val; 
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

