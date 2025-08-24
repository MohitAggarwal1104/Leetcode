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

// USING ITRATIVE

// class Solution {
//     public ListNode deleteMiddle(ListNode head) {
//         ListNode temp=head;
//         int count =0;
//         if(head==null || head.next==null)return null;
//         while(temp!=null){
//             count++;
//             temp=temp.next;
//         }
//         temp=head;
//         for(int i=1;i<=count/2;i++){
//             if(i==count/2){
//                 temp.next=temp.next.next;
//                 break;
//             }
//             temp=temp.next;
//         }
//         return head;
//     }
// }

//USING TORTOISE AMD HERE

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        if (head == null || head.next == null) return null;
        fast=fast.next.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}