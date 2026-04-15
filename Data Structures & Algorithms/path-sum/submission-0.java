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
    public boolean isSumPossible (TreeNode root,int targetSum,int sum){
        if (root==null){
            return false;
        }
        if (root.left==null && root.right==null){
            if (sum+root.val==targetSum){
                return true;
            }

            return false;
        }
        boolean left = isSumPossible (root.left,targetSum,sum+root.val);
        boolean right = isSumPossible (root.right,targetSum,sum+root.val);

        return left || right;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return isSumPossible (root,targetSum,sum);
    }
}