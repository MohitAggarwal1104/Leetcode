/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node pseudoHead = new Node(0);
        Node copyCurr = pseudoHead;

        while (curr != null) {
            Node clone = curr.next;
            curr.next = clone.next;
            copyCurr.next = clone;
            copyCurr = clone;
            curr = curr.next;
        }

        return pseudoHead.next;
    }
}