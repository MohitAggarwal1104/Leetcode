/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 // Using Tortoise and hare algo

// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         if(head==null || head.next==null)return null;
//         ListNode slow=head;
//         ListNode fast=head;
//         while(fast!=null && fast.next!=null){
//             fast=fast.next.next;
//             slow=slow.next;
//             if(fast==slow){
//                 slow=head;
//                 while(fast!=slow){
//                     fast=fast.next;
//                     slow=slow.next;
//                 }
//                 return slow;
//             }
//         }
//         return null;
//     }
// }

//using HashMap

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.HashSet;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();

        ListNode temp = head;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp; // This is the start of the loop
            }
            visited.add(temp);
            temp = temp.next;
        }

        return null; // No cycle
    }
}
