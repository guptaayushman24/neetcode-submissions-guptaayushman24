class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Returns height if balanced, -1 if unbalanced
    private int checkHeight(TreeNode root) {
        if (root == null) return 0;  // ✅ base case

        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) return -1;  // ✅ left subtree unbalanced

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) return -1; // ✅ right subtree unbalanced

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // ✅ current node unbalanced

        return 1 + Math.max(leftHeight, rightHeight); // ✅ return actual height
    }
}