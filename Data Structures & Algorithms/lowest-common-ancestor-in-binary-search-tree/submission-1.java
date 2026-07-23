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
    public static void buildChildParentHashMap (TreeNode root,HashMap<Integer,TreeNode> hm){
        if (root==null){
            return;
        }

        if (root.left!=null){
            hm.put(root.left.val,root);
            buildChildParentHashMap (root.left,hm);
        }

        if (root.right!=null){
            hm.put(root.right.val,root);
            buildChildParentHashMap (root.right,hm);
        }


    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<Integer,TreeNode> hm = new HashMap<>();
        buildChildParentHashMap (root,hm);

        HashSet<Integer> hs = new HashSet<>();
        TreeNode curr = p;
        // Collect all the ancestors of p in the hashset
        while (curr!=null){
            hs.add(curr.val);
            curr = hm.get(curr.val);
        }

        // Check if q is present in the hashset
        curr = q;
        while (curr!=null){
            if (hs.contains(curr.val)){
                return curr;
            }

            curr = hm.get(curr.val);
        }

        return root;
    }
}
