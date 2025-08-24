/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


 // USING HASHMAP
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         // HashMap<ListNode,Integer> map = new HashMap<>();
//         // ListNode temp=headA;
//         // while(temp!=null){
//         //     map.put(temp,1);
//         //     temp=temp.next;
//         // }

//         // temp=headB;
//         // while(temp!=null){
//         //     if(map.containsKey(temp)){
//         //         return temp;
//         //     }
//         //     temp=temp.next;
//         // }
//         // return null;
//     }
// }

//OPTIMISE SPACE COMPLEXITY

// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         ListNode t1=headA;
//         ListNode t2=headB;
//         int l1=0;
//         int l2=0;
//         while(t1!=null){
//             l1++;
//             t1=t1.next;
//         }
//         while(t2!=null){
//            l2++;
//            t2=t2.next;
//         }

//         if(l1<l2){
//             return collision(headA,headB,l2-l1);
//         }
//         else{
//             return collision(headB,headA,l1-l2);
//         }
//     }
//     public ListNode collision(ListNode t1,ListNode t2,int diff){
//         while(diff!=0){
//             diff--;
//             t2=t2.next;
//         }
//         while(t1!=t2){
//             t1=t1.next;
//             t2=t2.next;
//         }
//         return t1;
//     }
// }

//OPTIMISE TIME COMPLEXITY
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1=headA;
        ListNode t2=headB;
        if(headA==null || headB==null)return null;
        if(t1==t2)return t1;
        while(t1!=t2){
            t1=t1.next;
            t2=t2.next;
            if(t1==t2)return t1;

            if(t1==null)t1=headB;
            if(t2==null)t2=headA;
        }
        return t1;
    }
}