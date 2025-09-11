// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     ArrayList<Integer> seen=new ArrayList<>();
//     public boolean findTarget(TreeNode root, int k) {
//         if (root == null) return false;
//         if (seen.contains(k - root.val)) return true;
//         seen.add(root.val);
//         return findTarget(root.left, k) || findTarget(root.right, k);
//     }
// }
import java.util.Stack;

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private boolean forward; // true = inorder, false = reverse inorder
    
    public BSTIterator(TreeNode root, boolean forward) {
        this.forward = forward;
        pushAll(root);
    }
    
    public int next() {
        TreeNode node = stack.pop();
        if (forward) {
            pushAll(node.right);
        } else {
            pushAll(node.left);
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = forward ? node.left : node.right;
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        
        // Left iterator (smallest → next bigger)
        BSTIterator l = new BSTIterator(root, true);
        // Right iterator (largest → next smaller)
        BSTIterator r = new BSTIterator(root, false);
        
        int i = l.next();
        int j = r.next();
        
        while (i < j) {
            int sum = i + j;
            if (sum == k) return true;
            else if (sum < k) {
                if (l.hasNext()) i = l.next();
                else return false;
            } else {
                if (r.hasNext()) j = r.next();
                else return false;
            }
        }
        
        return false;
    }
}
