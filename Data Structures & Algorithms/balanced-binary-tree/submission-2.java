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
    Boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return balanced ;
        }

        getHeight(root);

        return balanced;

    }

    private int getHeight(TreeNode curr) {
        if (curr == null ){
            return 0;
        }

        int left = getHeight(curr.left);
        int right = getHeight(curr.right);

        if (left - right > 1) {
            balanced = false;
            return 0;
        }

        if (right - left > 1) {
            balanced = false;
            return 0;
        }

        return 1 + Math.max(left, right);
    }
}
