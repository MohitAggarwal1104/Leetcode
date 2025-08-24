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
        ListNode temp=head,nextNode,prevNode=null;
        while(temp!=null){
            ListNode KthNode=FindKthNode(temp,k);
            if(KthNode==null){
                if(prevNode!=null)prevNode.next=temp;
                break;
            }
            nextNode=KthNode.next;
            KthNode.next=null;
            Reverse(temp);
            if(temp==head){
                head=KthNode;
            }
            else{
                prevNode.next=KthNode;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }
    public ListNode FindKthNode(ListNode head1,int k){
        int count=1;
        while(head1!=null && count!=k){
            count++;
            head1=head1.next;
        }
        return head1;
    }
    public ListNode Reverse(ListNode head1){
        if(head1==null || head1.next==null) return head1;
        ListNode NewNode=Reverse(head1.next);
        ListNode front=head1.next;
        front.next=head1;
        head1.next=null;
        return NewNode;
    }
}