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
    int preOrderIndex = 0;
    public int search (int [] inorder,TreeNode root,int left,int right){
        for (int i=left;i<=right;i++){
            if (inorder[i]==root.val){
                return i;
            }
        }

        return -1;
    }
    public TreeNode constructTree (int [] preorder,int [] inorder,int left,int right){
        if (left>right){
            return null;
        }

        TreeNode root = new TreeNode (preorder[preOrderIndex]);
        int indexInInorder = search (inorder,root,left,right);
        
        preOrderIndex++;
        root.left = constructTree (preorder,inorder,left,indexInInorder-1);
        root.right = constructTree (preorder,inorder,indexInInorder+1,right);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int left = 0;
        int right = inorder.length-1;
        return constructTree (preorder,inorder,left,right);
    }
}
