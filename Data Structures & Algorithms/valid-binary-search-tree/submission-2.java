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
    public boolean isValidBST(TreeNode root) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;

        return dfs(root, left, right);
    }

    private boolean dfs(TreeNode node, int left, int right) {
        if (node == null) {
            return true;
        }
        if (!(left < node.val && node.val < right)) {
            return false;
        }
        return dfs(node.left, left, node.val) &&
               dfs(node.right, node.val, right);
    }
}
