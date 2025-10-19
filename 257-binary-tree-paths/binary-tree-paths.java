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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        if (node == null) return;

        // Add current node to path
        path += node.val;

        // If leaf node → add path to result
        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }

        // Continue path with "->"
        path += "->";

        // Recurse left and right
        dfs(node.left, path, paths);
        dfs(node.right, path, paths);
    }
}
