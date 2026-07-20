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
    public void pathFromRootToLeaf(
        TreeNode root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(res));
            // return;
        }
        pathFromRootToLeaf(root.left, ans, res);
        pathFromRootToLeaf(root.right, ans, res);
        res.remove(res.size() - 1);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        pathFromRootToLeaf(root, ans, res);
        System.out.println("List->>>"
            + " " + ans);

        for (int i = 0; i < ans.size(); i++) {
            int sum = 0;
            List<Integer> list = ans.get(i);
            for (int x : list) {
                sum = sum + x;
            }

            if (sum == targetSum) {
                System.out.println("Sum ->>>>"
                    + " " + sum);
                return true;
            }
        }
        return false;
    }
}