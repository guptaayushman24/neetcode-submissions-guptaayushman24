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
    public static int globlMax = Integer.MIN_VALUE;
    public static int diameterOfTree (TreeNode root,int maxi){
        if (root==null){
            return 0;
        }
        int left = diameterOfTree (root.left,maxi);
        int right = diameterOfTree (root.right,maxi);

        globlMax = Math.max(globlMax,left+right);
        return 1+Math.max(left,right);


    }
    public int diameterOfBinaryTree(TreeNode root) {
        globlMax = 0;
        int maxi = Integer.MIN_VALUE;
        diameterOfTree (root,maxi);

        return globlMax;
    }
}
