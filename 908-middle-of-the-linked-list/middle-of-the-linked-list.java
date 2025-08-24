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

// Using COUNT 

// class Solution {
//     public ListNode middleNode(ListNode head) {
//         ListNode temp = head;
//         int count =0;
//         while(temp!=null){
//             count++;
//             temp=temp.next;
//         }
//         temp=head;
//         int need = (count/2)+1;
//         for(int i=1;i<=need;i++){
//             if(i==need)break;
//             temp=temp.next;
//         }
//         return temp;
//     }
// }

// USING TORTOISE AND HERE ALGORITMS

class Solution {
    public ListNode middleNode(ListNode head) {
       ListNode slow=head;
       ListNode fast=head;

       while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
       }

       return slow;
    }
}