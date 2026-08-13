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
    public TreeNode invertTree(TreeNode root) {
        TreeNode current = root;
        if (current != null) {
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            current.left = invertTree(current.left);
            current.right = invertTree(current.right);
        }
        return current;
    }
}
