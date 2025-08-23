/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root, p.val, q.val);
    }

    public TreeNode LCA(TreeNode node, int a, int b) {
        if (a < node.val && b < node.val) {
            return LCA(node.left, a, b);
        } else if (a > node.val && b > node.val) {
            return LCA(node.right, a, b);
        } else {
            return node;
        }
    }
}
