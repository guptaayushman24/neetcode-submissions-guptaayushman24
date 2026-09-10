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
    static int maxHeight = 0;
    public static int findDiameter (TreeNode root){
        if (root==null){
            return 0;
        }

        int leftSide = findDiameter (root.left);
        int rightSide = findDiameter (root.right);

        maxHeight = Math.max(maxHeight,leftSide+rightSide);

        return 1+Math.max(leftSide,rightSide);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxHeight = 0;
        findDiameter (root);
        
        return maxHeight;
    }
}
