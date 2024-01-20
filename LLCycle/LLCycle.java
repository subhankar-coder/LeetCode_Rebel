package LLCycle;

public class LLCycle{

	public static void main(String ... args){

		 ListNode head = new ListNode(3);
		 head.next= new ListNode(2);
		 head.next.next=new ListNode(0);
		 head.next.next=new ListNode(-4);
		 head.next.next.next=head.next;

		 ListNode initial = head;

		 while (head.next!=null && initial!=null && initial.next!=null){
		 	if (head.val==initial.val){
		 		System.out.println("true");
		 		return;
		 	}
		 	head=head.next;
		 	initial=initial.next.next;
		 }
		 System.out.println("false");
	}
	public static void printList(ListNode  head){
		while(head.next!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}

}
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }