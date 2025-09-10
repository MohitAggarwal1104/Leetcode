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
    public ListNode partition(ListNode head, int x) {
        ListNode newhead1=new ListNode(0);
        ListNode newhead2=new ListNode(0);
        ListNode ans1=newhead1;
        ListNode ans2=newhead2;
        ListNode temp=head;
         if (head == null) return null;
        if(temp.val<x){
                 ListNode newhead=new ListNode(temp.val);
                 newhead1.next=newhead;
                 newhead1=newhead1.next;
            }
            else{
                ListNode newhead=new ListNode(temp.val);
                 newhead2.next=newhead;
                 newhead2=newhead2.next;
            }
        while(temp.next!=null){
            if(temp.next.val<x){
                 ListNode newhead=new ListNode(temp.next.val);
                 newhead1.next=newhead;
                 newhead1=newhead1.next;
            }
            else{
                ListNode newhead=new ListNode(temp.next.val);
                 newhead2.next=newhead;
                 newhead2=newhead2.next;
            }
            temp=temp.next;
        }
        newhead2.next = null;
        if(ans2.next!=null)newhead1.next=ans2.next;
        return ans1.next;
    }
}