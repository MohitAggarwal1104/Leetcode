// class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         ListNode prev = dummy;
//         ListNode curr = head;
//         while (curr != null) {
//             while (curr.next != null && curr.val == curr.next.val) {
//                 curr = curr.next;
//             }
//             if (prev.next == curr) {
//                 prev = prev.next;
//             } else {
//                 prev.next = curr.next;
//             }
//             curr = curr.next;
//         }

//         return dummy.next;
//     }
// }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode tem1 = head;
        ListNode tem2 = head.next;
        ListNode newNode = new ListNode(0);
        ListNode temp = newNode;

        while (tem1 != null) {
            boolean isDuplicate = false;
            while (tem2 != null && tem1.val == tem2.val) {
                tem2 = tem2.next;
                isDuplicate = true;
            }

            if (!isDuplicate) {
                temp.next = new ListNode(tem1.val);
                temp = temp.next;
            }

            tem1 = tem2;
            if (tem2 != null) tem2 = tem2.next;
        }

        return newNode.next;
    }
}
