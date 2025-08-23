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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null)
            return true;
        if (root == null)
            return false;
        if (root.val == subRoot.val && checkTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean checkTree(TreeNode a, TreeNode b) {
        if (a != null && b != null && a.val != b.val)
            return false;
        if ((a == null && b != null) || (a != null && b == null))
            return false;
        if (a == null)
            return true;
        return checkTree(a.left, b.left) && checkTree(a.right, b.right);
    }
}
