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
    public void traverseBinaryTree (TreeNode root,PriorityQueue<Integer> pq){
        if (root==null){
            return;
        }
        pq.add(root.val);
        traverseBinaryTree(root.left,pq);
        traverseBinaryTree(root.right,pq);
    }
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        traverseBinaryTree (root,pq);
        int ans = 0;
        while (k>0){
            ans = pq.remove();
            k--;
        }

        return ans;
    }
}
