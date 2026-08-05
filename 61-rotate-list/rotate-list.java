/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        int count=1;
        ListNode curr=head;
        while(curr.next!=null){ //find length
            count++;
            curr=curr.next;
        }
        k=k%count;// reduce unnecessary rotations
        if(k==0) return head;
        curr.next=head; //circular list
        int steps=count-k-1;
        ListNode newTail=head; //find new tail
        for(int i=0;i<steps;i++){
            newTail=newTail.next;
        }
        ListNode newHead=newTail.next; //new head
        newTail.next=null; //break the circle
        return newHead;
    }
}