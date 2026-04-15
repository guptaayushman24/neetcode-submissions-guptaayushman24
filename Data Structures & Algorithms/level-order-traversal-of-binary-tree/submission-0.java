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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root==null){
            return ans;
        }
        q.add(root);
        while (q.size()>0){
            int n = q.size();
            List<Integer> list = new ArrayList();
            for (int i=0;i<n;i++){
                TreeNode node = q.remove();
                list.add(node.val);
                if (node.left!=null){
                    q.add(node.left);
                }
                if (node.right!=null){
                    q.add(node.right);
                }
            }
            ans.add(new ArrayList<>(list));

        }

        return ans;
    }
}
