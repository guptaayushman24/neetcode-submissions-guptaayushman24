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
    public static boolean ifIsSameTree (TreeNode x,TreeNode y){
        if (x==null && y==null){
            return true;
        }


        if (x==null || y==null){
            return false;
        }

        if (x.val!=y.val){
            return false;
        }

        

        boolean left = ifIsSameTree (x.left,y.left);
        boolean right = ifIsSameTree (x.right,y.right);

        return left && right;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean ans =  ifIsSameTree (p,q);

        return ans;
    }
}
