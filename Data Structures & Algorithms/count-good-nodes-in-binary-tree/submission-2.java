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
    static int count = 0;
    public static void countNumberOfGoodNodes (TreeNode root,int maxi){
        if (root==null){
            return;
        }

        if (root.val>=maxi){
            maxi = root.val;
            count++;
        }

        countNumberOfGoodNodes (root.left,maxi);
        countNumberOfGoodNodes (root.right,maxi);
    }
    public int goodNodes(TreeNode root) {
        int maxi = Integer.MIN_VALUE;
        count = 0;
        countNumberOfGoodNodes (root,maxi);

        return count;
    }
}
