/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> ro=new LinkedList<>();
        int sum=0;
        if(root==null)return 0;
        ro.add(root);
        while(!ro.isEmpty()){
            TreeNode p=ro.poll();
            if(p.left!=null){
                if (p.left.left == null && p.left.right == null) {
                    sum += p.left.val;
                }
                ro.add(p.left);
            }
            if(p.right!=null){
                ro.add(p.right);
            }
        }
        return sum;
    }
}