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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode groupPrev=dummy;
        while(true){
            ListNode kth=groupPrev; //find kth node
            for(int i=0;i<k && kth != null;i++){
                kth=kth.next;
            }
            if(kth==null) break; //less than k nodes left
            ListNode groupNext=kth.next;
            ListNode prev=groupNext; //reverse curr group
            ListNode curr=groupPrev.next;
            while(curr != groupNext){
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }
            ListNode temp=groupPrev.next; //connect reversed group
            groupPrev.next=kth;
            groupPrev=temp;
        }
        return dummy.next;
    }
}