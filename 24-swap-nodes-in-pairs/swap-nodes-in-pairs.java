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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        ListNode prev = null;
        ListNode current = head;
        while (current != null && current.next != null) {
            ListNode first = current;
            ListNode second = current.next;
            first.next = second.next;
            second.next = first;
            if (prev != null) {
                prev.next = second;
            }
            prev = first;
            current = first.next;
        }
        return newHead;
    }
}
