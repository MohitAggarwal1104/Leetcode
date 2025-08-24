// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         // Stack<Integer> st=new Stack<>();
//         // ListNode temp=head;
//         // while(temp!=null){
//         //     st.push(temp.val);
//         //     temp=temp.next;
//         // }
//         // temp=head;
//         // while(temp!=null){
//         //     if(temp.val!=st.pop())return false;
//         //     temp=temp.next;
//         // }
//         // return true;

//         if(head==null || head.next==null)return true;
//         ListNode slow=head;
//         ListNode fast=head;
//         while(fast.next!=null && fast.next.next!=null){
//             slow=slow.next;
//             fast=fast.next.next;
//         }

//         ListNode newHead = reverse(slow.next);
//         ListNode first=head;
//         ListNode second=newHead;
//         while(second!=null){
//             if(first.val!=second.val){
//                 // reverse(newHead);
//                 return false;
//             }
//             first=first.next;
//             second=second.next;
//         }
//         // reverse(newHead);
//         return true;
//     }
//     public ListNode reverse(ListNode head){
//         if(head==null || head.next==null)return head;
//         ListNode newhead=reverse(head.next);
//         ListNode front=head.next;
//         front.next=head;
//         head.next=null;
//         return newhead;
//     }
// }
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Compare both halves
        ListNode left = head, right = prev;
        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }
}
