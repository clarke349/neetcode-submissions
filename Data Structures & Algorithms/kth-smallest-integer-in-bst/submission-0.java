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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int result = 0;

        dfs(root, minHeap);

        for (int i = 0; i < k; i++) {
            result = minHeap.poll();
        }

        return result;
    }

    private void dfs(TreeNode root, PriorityQueue<Integer> minHeap) {
        if (root == null) return;

        minHeap.add(root.val);
        dfs(root.left, minHeap);
        dfs(root.right, minHeap);
    }
}
