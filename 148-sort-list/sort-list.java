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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Step 1: Find the middle of the list
        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;

        // Break the list into two halves
        middle.next = null;

        // Step 2: Sort both halves recursively
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nextOfMiddle);

        // Step 3: Merge the sorted halves
        return sortedMerge(left, right);
    }

    // Merge two sorted lists
    private ListNode sortedMerge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        ListNode result;
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    // Find the middle node of the list
    private ListNode getMiddle(ListNode head) {
        if (head == null) return head;

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
