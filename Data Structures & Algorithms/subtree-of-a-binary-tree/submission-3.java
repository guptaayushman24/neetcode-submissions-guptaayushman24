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
    public static boolean isSubTree (TreeNode x,TreeNode y){
        if (x==null && y==null){
            return true;
        }

        if (x==null || y==null){
            return false;
        }

        if (x.val!=y.val){
            return false;
        }

        boolean left = isSubTree (x.left,y.left);
        boolean right = isSubTree (x.right,y.right);

        return left && right;
    }
    public static boolean function (TreeNode root,TreeNode subRoot){
        if (root==null){
            return false;
        }

        if (isSubTree(root,subRoot)){
            return true;
        }

       return function (root.left,subRoot) || function (root.right,subRoot);

    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean ans = function (root,subRoot);

        return ans;
    }
}
