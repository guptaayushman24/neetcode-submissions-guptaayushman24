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
    public void createChildParentHashMap (TreeNode root,HashMap<Integer,TreeNode> hm){
        if (root.left!=null){
            hm.put(root.left.val,root);
            createChildParentHashMap(root.left,hm);
        }
        if (root.right!=null){
            hm.put(root.right.val,root);
            createChildParentHashMap(root.right,hm);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<Integer,TreeNode> hm = new HashMap<>();
        TreeNode node = new TreeNode (-1);
        createChildParentHashMap(root,hm);

        HashSet<Integer> ancestors = new HashSet<>();
        TreeNode curr = p;

        // Collecting all the ancestors of the p
        while (curr!=null){
            ancestors.add(curr.val);
            curr = hm.get(curr.val);
        }   

        // Checking if the ancestors exsit of the q
        curr = q;
        while (curr!=null){
            if (ancestors.contains(curr.val)){
                return curr;
            }
            curr = hm.get(curr.val);
        }

        return root;
    }
}
